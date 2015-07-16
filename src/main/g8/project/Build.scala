import sbt._
import sbt.Keys._

object EtlBuild extends Build {
  lazy val geotrellisEtl = Project(
    id = "$name;format="lower,hyphen"$",
    base = file("."),
    settings = Project.defaultSettings ++ net.virtualvoid.sbt.graph.Plugin.graphSettings ++ Seq(
      name := "$name;format="lower,hyphen"$",
      organization := "geo",
      version := "0.1-SNAPSHOT",
      scalaVersion := "2.10.4",
      libraryDependencies ++= Seq(        
        "com.azavea.geotrellis" %% "geotrellis-spark-etl" % "$geotrellis_version$",
        "org.apache.spark" %% "spark-core" % "$spark_version$" % "provided"
      )
    )
  )
}
