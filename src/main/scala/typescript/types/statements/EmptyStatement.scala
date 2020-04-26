package typescript.types.statements

import typescript.types.enums.SyntaxKind

case object EmptyStatement extends Statement {
  override val kind: SyntaxKind = SyntaxKind.EmptyStatement
}
