Exercise 1
====

Java plugin
---
in the build.gradle file add the java plugin to make the project compile the library

you can use `./gradlew tasks` to see what task added the java plugin

Groovy plugin
---
apply the groovy plugin to run tests written in groovy

tests can be run using `./gradlew test`, it give a link to the report

fix the test.

Application plugin
---
add the application plugin and construct the application using
`./gradlew build`

Maven-publish plugin
---
add the maven publish plugin (https://docs.gradle.org/current/userguide/publishing_maven.html)

and publish the artifact on http://repositories.rd.lan/maven/snapshots/