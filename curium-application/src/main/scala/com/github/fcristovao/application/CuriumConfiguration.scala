package com.github.fcristovao.application

import com.datasift.dropwizard.scala.validation.constraints.{NotEmpty, Valid}
import com.github.fcristovao.config.HerokuDataSourceFactory
import io.dropwizard.Configuration


case class CuriumConfiguration(@Valid database: HerokuDataSourceFactory,
                               @NotEmpty customerName: String) extends Configuration {
}



