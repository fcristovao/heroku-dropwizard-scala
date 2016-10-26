package com.github.fcristovao.api

import java.time.OffsetDateTime

import io.dropwizard.jackson.JsonSnakeCase


object JsonCustomerV1 {
  final val MEDIA_TYPE = "application/vnd.fcristovao.curium.customer-v1+json"
}

@JsonSnakeCase
case class JsonCustomerV1(id: String, name: String, timestamp: OffsetDateTime)
