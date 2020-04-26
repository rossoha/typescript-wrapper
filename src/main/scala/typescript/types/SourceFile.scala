package typescript.types

import io.circe.Decoder
import io.circe.generic.semiauto._
import typescript.types.enums.{ScriptKind, SyntaxKind}
import typescript.types.statements.Statement


case class SourceFile(
    identifiers: Map[String, String],
//    statements: List[Statement],
    fileName: String,
    scriptKind: ScriptKind,
    nodeCount: Int,
    identifierCount: Int,
    isDeclarationFile: Boolean,
    hasNoDefaultLib: Boolean
) extends Statement {
  override val kind: SyntaxKind = SyntaxKind.SourceFile
}

object SourceFile {
  implicit val decoder: Decoder[SourceFile] = deriveDecoder[SourceFile]
}
