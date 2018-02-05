Gradle Hands-on
===

# ![](img/gradle-logo-horizontal.svg)

---

# Plan

- Concepts
- Common plugins
- **Let's code** :metal:
- Advanced concepts
- Tips and tricks

---

# Concepts

A gradle project have:
* a `build.gradle` file
```groovy
apply plugin: 'java'

group = 'com.acme.myproject' // project group
version = '1.0.0-SNAPSHOT' // project version
//name is by default the name of the folder

repositories {
    mavenCentral()
}

dependencies {
    compile 'com.acme:mylib:1.0.0'
    testCompile 'junit:junit:4.12'
}
```

---

# Concepts

A gradle project have:
* a `settings.gradle` file
```groovy
// fix project name
rootProject.name = 'my-project'

//define subprojects for multimodule builds
include 'my-lib'
include 'my-webapp'
```
---

# Concepts

2 phases to a build execution
* Configuration
* Execution

---

# Concepts

Both files are **evaludated** during the ___Configuration___ phase
to define:
* Projects: ~= maven module
* Tasks: units of works
* Dependencies between tasks
* Configuration properties

---
# Concepts
## Basic example (`basic_example/`)
```groovy
//evaluated during configuration
def hello = task 'hello' {
    doFirst { //evaluated at task execution
        print "hello "
    }
}

def world = task 'world' {
    doFirst {
        println "world"
    }
}
world.dependsOn hello
```
---
# Concepts
Once ___Configuration___ phase is done, gradle **execute** task given in arguments
```sh
./gradlew world

> Task :hello
hello
> Task :world
world

BUILD SUCCESSFUL in 0s
2 actionable tasks: 2 executed
```

---
# Concepts
## Plugins
Plugins add **tasks** and **extensions** (configuration properties)

---
# Common plugins
## Java
```
apply plugin: 'java'
```
Add tasks to build java projects, see `java_example/`

e.g. `./gradlew build` will produce
`build/libs/java_example-1.0.0-SNAPSHOT.jar`

---
# Common plugins 
https://docs.gradle.org/current/userguide/standard_plugins.html
* Language: java, groovy, scala
* Integration: application, war, distribution, maven-publish
* Dev: findbugs, checkstyle, jacoco

and many more
https://plugins.gradle.org/
Spotless, axion-release, docker, node, ...

---
# **Let's code** :metal:

## Simple java application

follow the [README.md](exercise_1/README.md) in `exercise_1/`

###### solution on the branch solution

---
# **Let's code** :metal:

## Bonita REST API extension and page

follow the [README.md](exercise_2/README.md) in `exercise_2/`

###### solution on the branch solution
---
# Advanced concepts
## Task inputs/outputs

Task declare inputs and output to let gradle know if a task must be reexecuted

---
### First run
```
:compileJava
:classes
:jar
:assemble
:build

BUILD SUCCESSFUL in 1s
2 actionable tasks: 2 executed
```
### Second run
```
:compileJava UP-TO-DATE
:classes UP-TO-DATE
:jar UP-TO-DATE
:assemble UP-TO-DATE
:build UP-TO-DATE

BUILD SUCCESSFUL in 1s
2 actionable tasks: 2 up-to-date
```

---

This work because `Jar` task define:
* Input: the set of  resources/classes to put in the jar
* Output: the jar constructed

If resources/classes did not change AND output jar is present and did not change: The task is considered as`UP-TO-DATE`


---
# Advanced concepts
## Gradle deamon

gradle starts JVM that stays up in order to be read to run new builds

```
gw --status
   PID STATUS   INFO
 62212 IDLE     4.4.1
```

---
# Advanced concepts
## Gradle wrapper

```
gradle init -->

build.gradle
gradle
  wrapper
    gradle-wrapper.jar
    gradle-wrapper.properties
gradlew
gradlew.bat
settings.gradle
```

---
# Advanced concepts
## Build cache

Work just like `UP-TO-DATE` checking but can get directly a compiled jar from the network if someone compiled it already using the same set of classes in input.


