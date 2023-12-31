import Dependencies._

ThisBuild / scalaVersion     := "2.13.11"
ThisBuild / version          := "0.1.0-SNAPSHOT"
ThisBuild / organization     := "tech.mozek"
ThisBuild / organizationName := "Mozek Technologies Ltd"

lazy val root = (project in file(".")).settings(
  name := "Mandelbrot Scala",
  libraryDependencies ++= Seq(
    "org.typelevel"          %% "spire"                      % "0.18.0",
    "org.scalafx"            %% "scalafx"                    % "20.0.0-R31",
    "org.scala-lang.modules" %% "scala-parallel-collections" % "1.0.4",
    "org.scalatest"          %% "scalatest"                  % "3.2.16" % "test"),
  scalacOptions := {
    Seq(
      "-deprecation",
      "-encoding",
      "utf8",
      "-feature",
      "-language:higherKinds",
      "-language:postfixOps",
      "-unchecked",
      "-Xlint:deprecation",
      "-Xlint:inaccessible",           // Warn about inaccessible types in method signatures.
      "-Xlint:infer-any",              // Warn when a type argument is inferred to be `Any`.
      "-Xlint:missing-interpolator",   // A string literal appears to be missing an interpolator id.
      "-Xlint:nullary-unit",           // Warn when nullary methods return Unit.
      "-Xlint:option-implicit",        // Option.apply used implicit view.
      "-Xlint:package-object-classes", // Class or object defined in package object.
      "-Xlint:poly-implicit-overload", // Parameterized overloaded implicit methods are not visible as view bounds.
      "-Xlint:private-shadow",         // A private field (or class parameter) shadows a superclass field.
      "-Xlint:stars-align",            // Pattern sequence wildcard must align with sequence component.
      "-Xlint:type-parameter-shadow",  // A local type parameter shadows a type already in scope.
      "-Ywarn-dead-code",
      "-Ywarn-numeric-widen",
      "-Ywarn-unused:explicits",
      "-Ywarn-unused:implicits",
      "-Ywarn-unused:locals",
//        "-Ywarn-unused:imports",
      "-Ywarn-unused:params",
      "-Ywarn-unused:patvars",
      "-Ywarn-unused:privates",
      "-Ywarn-value-discard",
      "-Ytasty-reader",
      "-Xfatal-warnings", // Transforms all warnings into errors
      "-Xsource:3",
      "-Xsource:3.1" // make sure code is forward compatible with scala 3
    )
  },
  Compile / doc / scalacOptions ++= Seq("-groups", "-implicits"))

// See https://www.scala-sbt.org/1.x/docs/Using-Sonatype.html for instructions on how to publish to Sonatype.
