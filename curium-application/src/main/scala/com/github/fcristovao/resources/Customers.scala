package com.github.fcristovao.resources

import java.time.OffsetDateTime
import javax.ws.rs.core.{Context, UriInfo}
import javax.ws.rs._

import com.codahale.metrics.annotation.Timed
import com.github.fcristovao.api.JsonCustomerV1
import com.github.fcristovao.dao.CustomerDao
import com.github.fcristovao.domain.{Customer, CustomerId}

@Path("/customers")
class Customers(dao: CustomerDao, customerName: String) {

  @GET
  @Path("/{id}")
  @Produces(Array(JsonCustomerV1.MEDIA_TYPE))
  @Timed
   def sayHello(@PathParam("id") customerId: CustomerId, @Context uriInfo: UriInfo) : JsonCustomerV1 = {
    val customer: Customer = dao.findCustomerById(customerId)

    JsonCustomerV1(customer.id.toString, customerName, OffsetDateTime.now())
  }
}