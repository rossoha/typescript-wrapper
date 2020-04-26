package typescript.parser

import java.time.format.DateTimeFormatter

import cats._
import io.circe.Json
import japgolly.scalagraal.Expr.Result
import japgolly.scalagraal.GraalJs._
import japgolly.scalagraal.{ContextSync, Expr, Language}
import org.graalvm.polyglot.{Source, Value}
import org.webjars.WebJarAssetLocator
import typescript.types.SourceFile
import typescript.types.enums.ScriptTarget

import scala.jdk.CollectionConverters._

class Parser private (rootTsExpr: Expr[Value])(private val ctx: ContextSync) {

  trait Typescript {

    def createSourceFile(
        fileName: String,
        sourceText: String,
        languageVersion: String
    ): Value
  }

  ctx.eval(rootTsExpr)
  val typescript: Id[Result[Typescript]] = ctx.eval(Expr("ts").as[Typescript])

  def parse(source: Source): Either[Exception, SourceFile] = {
    typescript
      .map(
        _.createSourceFile(
          "dummy.ts",
          source.getCharacters.toString,
          ScriptTarget.Latest.toString
        )
      )
      .map(Parser.parse)
      .flatMap(_.as[SourceFile])
  }
}

object Parser {

  private lazy val typescript = new WebJarAssetLocator().getFullPath("typescript", "typescript.js")
  private lazy val typescriptExpr: Expr[Value] = Expr.requireFileOnClasspath(typescript)(Language.JS)

  def apply(context: ContextSync): Parser = new Parser(typescriptExpr)(context)

  val dateFormatter = DateTimeFormatter.ISO_DATE

  private[parser] def parse(value: Value): Json = {
    value match {
      case v if v.hasArrayElements => parseArray(v)
      case v if v.hasMembers => parseObject(v)
      case v if v.isNull => Json.Null
      case v if v.isNumber => parseNumber(v)
      case v if v.isString => Json.fromString(v.asString())
      case v if v.isBoolean => Json.fromBoolean(v.asBoolean())
      case v if v.isTimeZone => Json.fromString(v.asTimeZone().getId)
      case v if v.isDuration => Json.fromLong(v.asDuration().toMillis)
      case v if v.isDate => Json.fromString(dateFormatter.format(v.asDate()))
      case v if v.isTime => Json.fromString(dateFormatter.format(v.asTime()))
      case v if v.isInstant => Json.fromString(dateFormatter.format(v.asInstant()))
      case v if v.isException => throw v.throwException()
      case _ => Json.Null
    }
  }

  private def parseNumber(value: Value): Json = {
    value match {
      case v if v.fitsInInt() => Json.fromInt(v.asInt())
      case v if v.fitsInLong() => Json.fromLong(v.asLong())
      case v if v.fitsInDouble() => Json.fromDoubleOrString(v.asDouble())
    }
  }

  private def parseObject(value: Value): Json = {
    val keys = value.getMemberKeys.asScala.filter(_ != "parent")
    Json.fromFields(keys.map(key => key -> parse(value.getMember(key))))
  }

  private def parseArray(value: Value): Json =
    Json.fromValues(Range(0, value.getArraySize.toInt).map(idx => parse(value.getArrayElement(idx))))

}
