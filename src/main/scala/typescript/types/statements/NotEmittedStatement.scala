package typescript.types.statements

import typescript.types.enums.SyntaxKind

case object NotEmittedStatement extends Statement {
  override val kind: SyntaxKind = SyntaxKind.NotEmittedStatement
}
