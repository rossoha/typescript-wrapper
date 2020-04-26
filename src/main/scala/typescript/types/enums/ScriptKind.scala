package typescript.types.enums

import enumeratum.values.{IntCirceEnum, IntEnum, IntEnumEntry}

sealed abstract class ScriptKind(val value: Int) extends IntEnumEntry

object ScriptKind extends IntEnum[ScriptKind] with IntCirceEnum[ScriptKind] {
  val values = findValues
  case object Unknown extends ScriptKind(0)
  case object JS extends ScriptKind(1)
  case object JSX extends ScriptKind(2)
  case object TS extends ScriptKind(3)
  case object TSX extends ScriptKind(4)
  case object External extends ScriptKind(5)
  case object JSON extends ScriptKind(6)

  /**
    * Used on extensions that doesn't define the ScriptKind but the content defines it.
    * Deferred extensions are going to be included in all project contexts.
    */
  case object Deferred extends ScriptKind(7)
}
