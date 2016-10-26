# heroku-dropwizard-scala
A skeleton sbt dropwizard scala application ready to be deployed to Heroku

##
This repo contains a skeleton [Scala](http://www.scala-lang.org/) 
[Dropwizard](http://www.dropwizard.io/) (v1.0.2) application
and follows its [suggested](http://www.dropwizard.io/1.0.2/docs/manual/core.html) project
layout (multiple modules - or projects, in sbt nomenclature). 

As a Scala application, it uses [sbt](http://www.scala-sbt.org/) for building, 
and uses [sbt-native-packager](https://github.com/sbt/sbt-native-packager)
to allow for easy deploy of it in [Heroku](https://www.heroku.com/).
It also uses [dropwizard-scala](https://github.com/datasift/dropwizard-scala) 
to make the marriage between Dropwizard and Scala even smoother.

Since Heroku encourages the usage of environment variables for the configuration
of the application, the app uses [dropwizard-template-config](https://github.com/tkrille/dropwizard-template-config) 
to marry the 2.
Please check [the application configuration file](curium-application/curium.yml).

Finally, if you're using [postgres add-on](https://www.heroku.com/postgres) database in Heroku, you'll 
notice that the `DATABASE_URL` format differs from the one expected with
[Dropwizard's JDBI's Data Source](http://www.dropwizard.io/1.0.2/docs/manual/jdbi.html),
so this application has a [HerokuDataSourceFactory](curium-application/src/main/scala/com/github/fcristovao/config/HerokuDataSourceFactory.scala) 
that takes care of the conversion between the two. It currently only supports
[PostgreSQL](https://www.postgresql.org/), but provides an easy way to add
more. Just check the class.

## Testing
There's *NO* tests because this is just a mock application.
You should always be [testing](http://www.dropwizard.io/1.0.2/docs/manual/testing.html) your application!