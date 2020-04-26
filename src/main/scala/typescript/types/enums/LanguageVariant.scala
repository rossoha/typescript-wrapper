package typescript.types.enums

import enumeratum.values.{IntEnum, IntEnumEntry}

sealed abstract class LanguageVariant(val value: Int) extends IntEnumEntry

object LanguageVariant extends IntEnum[LanguageVariant] {
  val values = findValues
  case object Standard extends LanguageVariant(0)
  case object JSX extends LanguageVariant(1)
}
