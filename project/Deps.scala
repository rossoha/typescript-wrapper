import sbt.stringToOrganization

object Deps {

  val circe = "io.circe"                             %% "circe-core"                 % "0.13.0"
  val circeP = "io.circe"                            %% "circe-parser"               % "0.13.0"
  val circeG = "io.circe"                            %% "circe-generic"              % "0.13.0"
  val enumeratumCirce = "com.beachape"               %% "enumeratum-circe"           % "1.5.23"
  val scalaGraal = "com.github.japgolly.scala-graal" %% "core"                       % "0.4.0"
  val graalJs = "org.graalvm.js"                     % "js"                          % "20.0.0"
  val webjars = "org.webjars"                        % "webjars-locator-core"        % "0.44"
  val `typescript` = "org.webjars.npm"               % "typescript"                  % "3.8.3"

}
