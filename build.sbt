/* ScalablyTyped configuration */
enablePlugins(ScalablyTypedConverterGenSourcePlugin)

scalaVersion := "2.13.2"
name := "slinky-material-ui"
version := "0.1"

/* javascript / typescript deps */
Compile / npmDependencies ++= Seq(
  "@types/react" -> "16.9.34",
  "@types/react-dom" -> "16.9.6",
  "@material-ui/core" -> "3.9.4"
)

Test / npmDependencies ++= Seq(
  "react" -> "16.13.1",
  "react-dom" -> "16.13.1",
)

/* disabled because it somehow triggers many warnings */
scalaJSLinkerConfig ~= (_.withSourceMap(false))

// because npm is slow
useYarn := true

stExperimentalEnableImplicitOps := true

// say we want custom code for slinky
stFlavour := Flavour.Slinky

// focus only on these libraries
stMinimize := Selection.AllExcept("material-ui")

// shade into another package
stOutputPackage := "com.olvind.materialui.facade"

// Testing? let's do it manually - run Test/fastOptJS::startWebpackDevServer and go to http://localhost:8080
Test / scalaJSUseMainModuleInitializer := true
Test / scalaJSUseTestModuleInitializer := false

publishMavenStyle := true
homepage := Some(new URL("https://github.com/ScalablyTyped/material-ui-slinky"))
startYear := Some(2020)
pomExtra := (
  <scm>
    <connection>scm:git:github.com:/ScalablyTyped/material-ui-slinky</connection>
    <developerConnection>scm:git:git@github.com:ScalablyTyped/material-ui-slinky.git</developerConnection>
    <url>github.com:ScalablyTyped/material-ui-slinky.git</url>
  </scm>
    <developers>
      <developer>
        <id>oyvindberg</id>
        <name>Øyvind Raddum Berg</name>
      </developer>
    </developers>
  )
licenses += ("MIT", url("http://opensource.org/licenses/MIT"))
bintrayRepository := "libs"
