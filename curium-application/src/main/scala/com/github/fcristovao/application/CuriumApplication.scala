package com.github.fcristovao.application

import com.datasift.dropwizard.scala.ScalaApplication
import com.datasift.dropwizard.scala.jdbi._
import de.thomaskrille.dropwizard_template_config.TemplateConfigBundle
import io.dropwizard.setup.{Bootstrap, Environment}
import com.github.fcristovao.dao.CustomerDao
import com.github.fcristovao.resources.Customers


object CuriumApplication extends ScalaApplication[CuriumConfiguration] {
  override def init(bootstrap: Bootstrap[CuriumConfiguration]) {
    bootstrap.addBundle(new TemplateConfigBundle())
  }

  def run(conf: CuriumConfiguration, env: Environment) {
    val db = JDBI(env, conf.database)
    val dao = db.daoFor[CustomerDao]

    env.jersey().register(new Customers(dao, conf.customerName))
  }
}