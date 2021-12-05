# Gradle JDK 11 Encoding Issue

## Prerequisites
- Java JDK 11

## How To

### Gradle

Run `gradlew clean run` on your machine.

### Java

- Run `gradlew clean compileJava`
- `cd app/build/classes/java/main`
- Run `java jdk11.encoding.issue.App`

## Results

|  | macOS 11 Gradle | Windows 10 Gradle | macOS 11 Java | Windows 10 Java |
|---|---|---|---|---|
| defaultCharacterEncoding | UTF-8 | UTF-8  | UTF-8 | windows-1252 |
| file.encoding | UTF-8  | UTF-8 | UTF-8 | Cp1252 |
| sun.jnu.encoding | null | Cp1252 | UTF-8 | Cp1252 |
| sun.stdout.encoding | null | null  | null | cp437 |
| sun.stderr.encoding | null | null | null | cp437 |
| Printing Hähö | Hähö :white_check_mark: | HΣH÷ :x: | Hähö :white_check_mark: | Hähö :white_check_mark: |

## Workaround to Make it Work With Gradle on Windows

- Find your windows code page using `chcp` (`chcp.com` on gitbash). E.g. on my machine, the result was `Active code page: 437`.

- Add the following to the [build.gradle](app/build.gradle):
```groovy
run.configure {
    allJvmArgs = ['-Dsun.stdout.encoding=cp437']
}
```

- Remove the `org.gradle.jvmargs=-Dfile.encoding=UTF-8` in the gradle.properties file against gradle's [best practice advice](https://docs.gradle.org/current/userguide/common_caching_problems.html#system_file_encoding). According to the [JEP 400 - UTF8 by default](https://openjdk.java.net/jeps/400): *Developers sometimes attempt to configure the default charset by setting the system property file.encoding on the command line (i.e., java -Dfile.encoding=...), but this has never been supported.*

Then it works and prints:

```console
defaultCharacterEncoding=windows-1252
file.encoding=windows-1252
sun.jnu.encoding=Cp1252
sun.stdout.encoding=cp437
sund.sterr.encoding=null
Hähö
```