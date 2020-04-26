package typescript.types.enums

import enumeratum.values.{IntCirceEnum, IntEnum, IntEnumEntry}

sealed abstract class NodeFlags(val value: Int) extends IntEnumEntry

object NodeFlags extends IntEnum[NodeFlags] with IntCirceEnum[NodeFlags] {
  val values =  findValues
  case object None extends NodeFlags(value = 0)
  case object Let extends NodeFlags(value = 1)
  case object Const extends NodeFlags(value = 2)
  case object NestedNamespace extends NodeFlags(value = 4)
  case object Synthesized extends NodeFlags(value = 8)
  case object Namespace extends NodeFlags(value = 16)
  case object OptionalChain extends NodeFlags(value = 32)
  case object ExportContext extends NodeFlags(value = 64)
  case object ContainsThis extends NodeFlags(value = 128)
  case object HasImplicitReturn extends NodeFlags(value = 256)
  case object HasExplicitReturn extends NodeFlags(value = 512)
  case object GlobalAugmentation extends NodeFlags(value = 1024)
  case object HasAsyncFunctions extends NodeFlags(value = 2048)
  case object DisallowInContext extends NodeFlags(value = 4096)
  case object YieldContext extends NodeFlags(value = 8192)
  case object DecoratorContext extends NodeFlags(value = 16384)
  case object AwaitContext extends NodeFlags(value = 32768)
  case object ThisNodeHasError extends NodeFlags(value = 65536)
  case object JavaScriptFile extends NodeFlags(value = 131072)
  case object ThisNodeOrAnySubNodesHasError extends NodeFlags(value = 262144)
  case object HasAggregatedChildData extends NodeFlags(value = 524288)
  case object JSDoc extends NodeFlags(value = 4194304)
  case object JsonFile extends NodeFlags(value = 33554432)
  case object BlockScoped extends NodeFlags(value = 3)
  case object ReachabilityCheckFlags extends NodeFlags(value = 768)
  case object ReachabilityAndEmitFlags extends NodeFlags(value = 2816)
  case object ContextFlags extends NodeFlags(value = 25358336)
  case object TypeExcludesFlags extends NodeFlags(value = 40960)

  
}
