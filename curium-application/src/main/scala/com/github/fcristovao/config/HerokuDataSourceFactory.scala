package com.github.fcristovao.config

import java.net.URI

import io.dropwizard.db.DataSourceFactory
import org.apache.commons.lang3.NotImplementedException

object HerokuDataSourceFactory {
  type DriverClass = String
  type DriverURL = String
  type Username = String
  type Password = String

  private val POSTGRES = (uri: URI) =>
    ("org.postgresql.Driver",
      "jdbc:postgresql://" + uri.getHost + ':' + uri.getPort + uri.getPath,
      uri.getUserInfo.split(":")(0),
      uri.getUserInfo.split(":")(1))


  private var parsers = Map[String, (URI) => (DriverClass, DriverURL, Username, Password)]()

  def add(scheme: String, transformer: (URI) => (DriverClass, DriverURL, Username, Password)) = {
    parsers += (scheme -> transformer)
  }

  add("postgres", POSTGRES)
}

class HerokuDataSourceFactory extends DataSourceFactory {
  import com.github.fcristovao.config.HerokuDataSourceFactory._

  def setHerokuUrl(uri: String): Unit = {
    val dbUri = URI.create(uri)
    HerokuDataSourceFactory.parsers.get(dbUri.getScheme) match {
      case Some(parser) =>
        setProperties _ tupled parser(dbUri)
      case None =>
        val supportedSchemes: String = HerokuDataSourceFactory.parsers.keys.mkString("[", ", ", "]")
        throw new NotImplementedException(s"Only $supportedSchemes are currently supported for Heroku")
    }
  }

  def setProperties(driverClass: DriverClass, driverURL: DriverURL, username: Username, password: Password): Unit = {
    // The if's ensure we don't override anything already set
    if (this.getDriverClass == null) {
      this.setDriverClass(driverClass)
    }
    if (this.getUrl == null) {
      this.setUrl(driverURL)
    }
    if (this.getUser == null) {
      this.setUser(username)
    }
    if (this.getPassword == null) {
      this.setPassword(password)
    }
  }
}
