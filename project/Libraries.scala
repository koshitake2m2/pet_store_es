import sbt.librarymanagement.ModuleID
import sbt.librarymanagement.syntax._

/** ライブラリのバージョン管理 */
object Libraries {

  private lazy val catsVersion = "2.7.0"
  private lazy val catsEffectVersion = "3.3.8"
  private lazy val log4catsVersion = "2.2.0"
  private lazy val slf4jVersion = "1.7.36"
  lazy val cats = Seq(
    "org.typelevel" %% "cats-core" % catsVersion,
    "org.typelevel" %% "cats-effect" % catsEffectVersion
  ) ++ log4cats

  lazy val log4cats = Seq(
    "org.typelevel" %% "log4cats-core" % log4catsVersion,
    "org.typelevel" %% "log4cats-slf4j" % log4catsVersion,
    "org.slf4j" % "slf4j-api" % slf4jVersion,
    "org.slf4j" % "slf4j-simple" % slf4jVersion
  )

  // reference: https://github.com/estatico/scala-newtype
  private lazy val newtypeVersion = "0.4.4"
  lazy val newtype = Seq(
    "io.estatico" %% "newtype" % newtypeVersion
  )

  // reference: https://github.com/fthomas/refined
  private lazy val refinedVersion = "0.9.28"
  lazy val refined = Seq(
    "eu.timepit" %% "refined" % refinedVersion,
    "eu.timepit" %% "refined-cats" % refinedVersion,
    "eu.timepit" %% "refined-shapeless" % refinedVersion
  )

  private lazy val scalatestVersion = "3.2.11"
  lazy val scalatest = Seq(
    "org.scalatest" %% "scalatest" % scalatestVersion % Test
  )

  private lazy val circeVersion = "0.14.1"
  private lazy val circeConfigVersion = "0.8.0"
  lazy val circe = Seq(
    "io.circe" %% "circe-generic" % circeVersion,
    "io.circe" %% "circe-literal" % circeVersion,
    "io.circe" %% "circe-generic-extras" % circeVersion,
    "io.circe" %% "circe-parser" % circeVersion,
    "io.circe" %% "circe-refined" % circeVersion,
    "io.circe" %% "circe-config" % circeConfigVersion
  )

  lazy val commonDomain: Seq[ModuleID] = cats ++ newtype ++ refined ++ circe ++ scalatest
  lazy val commonApplication: Seq[ModuleID] = commonDomain ++ log4cats

  private lazy val mysqlConnectorJavaVersion = "8.0.28"
  lazy val mysql = Seq(
    "mysql" % "mysql-connector-java" % mysqlConnectorJavaVersion
  )

  private lazy val doobieVersion = "1.0.0-RC2"
  lazy val doobie = Seq(
    "org.tpolecat" %% "doobie-core" % doobieVersion,
    "org.tpolecat" %% "doobie-h2" % doobieVersion,
    "org.tpolecat" %% "doobie-hikari" % doobieVersion,
    "org.tpolecat" %% "doobie-refined" % doobieVersion,
    "org.tpolecat" %% "doobie-scalatest" % doobieVersion % Test
  )

  private lazy val http4sVersion = "0.23.11"
  lazy val http4s = Seq(
    "org.http4s" %% "http4s-dsl" % http4sVersion,
    "org.http4s" %% "http4s-blaze-client" % http4sVersion,
    "org.http4s" %% "http4s-blaze-server" % http4sVersion,
    "org.http4s" %% "http4s-circe" % http4sVersion
  )

  private lazy val mongodbScalaDriverVersion = "4.5.1"
  lazy val mongodb = Seq(
    "org.mongodb.scala" %% "mongo-scala-driver" % mongodbScalaDriverVersion
  )

}
