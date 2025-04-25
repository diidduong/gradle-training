# Gradle
Gradle training using Java, JUnit, and IntelliJ

## Basics
 - Relative path starts from `src`
 - Use tag `subprojects` to apply config to subprojects
 - Use tag `allprojects` to apply to root and subprojects, usually use for group and version
 - Use tag `api` in dependencies instead of `implementation`

When we want to use a dependency from module A in module B. Import plugins `java-library`

Predefined variables $:

- `rootProject`
  - `projectDir`
- `project`
  - `name`

## Dependencies

Each dependency is formatted as `commons-cli:commons-cli:1.4` (Group : Artifact : Version)

### Dependency Tree

`./gradlew dependencies` shows dependency tree and its transitive dependencies.

`./gradlew dependencyInsight` shows where dependencies are from.

Check out [Maven Central](maven.org) for all available dependencies.

Checkout [Gradle Scan](https://scan.gradle.com/#gradle) to learn how to generate a detailed UI report including dependency tree.

### Import a dependency
We can either import dependency by downloading from maven repository or manually read from `.jar` files.

To download directly from maven repo, in `build.gradle`

```groovy
dependencies {
    implementation 'org.springframework.boot.spring-boot-starter:3.2.0-M3'
    testImplementation 'org.junit.jupiter:junit-jupiter:5.9.3'
}
```

To import local `.jar` files

1. Create a `libs` folder under root
2. Download `.jar` file and put inside `libs`
3. In `build.gradle`
```groovy
repositories {
    flatDir 'libs'
}
```

### Settings
`settings.gradle` is used to specify project depedency.
```groovy
rootProject.name = 'example'

include ':subA', ':subB'
```

Run `./gradlew projects` to view project dependency.

> Need to also specify `implementation project(:subA)` into the depedencies section of the `build.gradle`

## Java Structure
```shell
src
├── main
├── ├── java
├── ├── resources
├── test
├── ├── java
├── ├── resources                  
├── build
├── ├── classes    # compiled class files
├── ├── libs       # generated JAR files
```

### Apply Java plugin
In the `build.gradle`

```groovy
plugins {
    id 'java'
    id 'application' // use to run app
}

// this will be appended to the .jar file name. eg. file_name-1.0.0.jar
version = '1.0.0'

java {
    sourceCompatibility = JavaVersion.VERSION_11
}

application {
    mainClass = 'org.example.Main'
}

compileJava {
    options.compilerArgs << '-Werror'
}

jar {
    archiveBaseName = 'file_name'
}
```

### JUnit
`testImplementation` for compilation and test execution.

`testRuntime` only for test execution.

In the `build.gradle` add this to execute tests and generate report, located in `build/reports/test/test/index.html`

```groovy
test {
    useJUnitPlatform()
}
```

### Gradle wrapper
To make every developer's life easy, use Gradle Wrapper.

`gradle wrapper` to generate gradle wrapper files. Then you can use,

`./gradlew` to run your Gradle commands.

`./gradlew tasks` to list all available tasks by the plugin

`./gradlew classes` will run both `compileJava` to produce class files and `processResources` to mix resource files with class files for the run time.

`./gradlew jar` to package the project in a `.jar` file, located in `build/libs`.