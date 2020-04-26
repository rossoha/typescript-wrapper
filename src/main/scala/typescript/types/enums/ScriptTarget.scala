package typescript.types.enums

import enumeratum.values.{IntCirceEnum, IntEnum, IntEnumEntry}

sealed abstract class ScriptTarget(val value: Int) extends IntEnumEntry  

object ScriptTarget  extends IntEnum[ScriptTarget] with IntCirceEnum[ScriptTarget] {
  val values = findValues
  case object ES3 extends ScriptTarget(0)
  case object ES5 extends ScriptTarget(1)
  case object ES2015 extends ScriptTarget(2)
  case object ES2016 extends ScriptTarget(3)
  case object ES2017 extends ScriptTarget(4)
  case object ES2018 extends ScriptTarget(5)
  case object ES2019 extends ScriptTarget(6)
  case object ES2020 extends ScriptTarget(7)
  case object ESNext extends ScriptTarget(99)
  case object JSON extends ScriptTarget(100)
  val Latest = ESNext
}
