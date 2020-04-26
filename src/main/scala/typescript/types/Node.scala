package typescript.types

//import typescript.types.Types.{Decorator, JSDoc, ModifierFlags, ModifiersArray, NodeArray, NodeFlags, Symbol, TextRange}
import typescript.types.enums.SyntaxKind

trait Node extends TextRange {
  val kind: SyntaxKind
  var id = Node.nextID()
}

object Node {
  private var _lastID: Int = 0

  private def nextID(): Int = {
    _lastID += 1
    _lastID
  }
}
