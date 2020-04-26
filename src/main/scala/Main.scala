import japgolly.scalagraal.GraalJs._
import japgolly.scalagraal.{ContextSync, _}
import org.webjars.WebJarAssetLocator
import typescript.parser.Parser

object Main extends App {

  val locator = new WebJarAssetLocator()

  val fileToParse = locator.getFullPath("typescript", "typescript.d.ts")

  val ctx: ContextSync = ContextSync()

  private val sourceFile = Parser(ctx).parse(SourceUtil.requireFileOnClasspath(fileToParse))

  println("-" * 100)
  println(sourceFile)
  println("-" * 100)

}
