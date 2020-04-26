package typescript.types.statements

import io.circe.{Decoder, DecodingFailure, HCursor}
import typescript.types.enums.SyntaxKind
import typescript.types.{Node, SourceFile}

trait Statement extends Node

object Statement {

  implicit val decodeStatement: Decoder[Statement] = Decoder.instance { c: HCursor =>
    c.downField("kind").as[SyntaxKind] match {
      case Right(SyntaxKind.SourceFile) => SourceFile.decoder.tryDecode(c)
      case Right(SyntaxKind.NotEmittedStatement) => Right(NotEmittedStatement)
      case Right(x) => Left(DecodingFailure(s"Not found ${x.toString}", List()))
    }
  }
}
