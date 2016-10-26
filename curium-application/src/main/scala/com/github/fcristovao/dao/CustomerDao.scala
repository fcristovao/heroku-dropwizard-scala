package com.github.fcristovao.dao

import java.sql.ResultSet
import java.util.UUID

import org.skife.jdbi.v2.StatementContext
import org.skife.jdbi.v2.sqlobject.customizers.Mapper
import org.skife.jdbi.v2.sqlobject.{Bind, SqlQuery}
import org.skife.jdbi.v2.tweak.ResultSetMapper
import com.github.fcristovao.domain.{Customer, CustomerId}


trait CustomerDao {
  @SqlQuery("select * from customers where customer_id = :id limit 1")
  @Mapper(classOf[CustomerMapper])
  def findCustomerById(@Bind("id") id: CustomerId) : Customer
}


class CustomerMapper extends ResultSetMapper[Customer] {
  override def map(index: Int, r: ResultSet, ctx: StatementContext): Customer = {
    Customer(UUID.fromString(r.getString("customer_id")))
  }
}
