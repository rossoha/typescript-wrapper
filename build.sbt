import sbt.Keys.{scalaVersion, _}
import sbt._

lazy val `typescript-wrapper` = project
  .in(file("."))
  .settings(
    Global / resolvers ++= Seq(Resolver.mavenCentral, Resolver.jcenterRepo) ++ Resolver.defaults,
    scalaVersion := "2.13.2",
    libraryDependencies ++= Seq(
      Deps.circe,
      Deps.circeP,
      Deps.circeG,
      Deps.enumeratumCirce,
      Deps.scalaGraal,
      Deps.graalJs,
      Deps.webjars,
      Deps.typescript
    )
  )
