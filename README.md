# Gradle JDK 11 Encoding Issue

# Prerequisites
- Java JDK 11

# How To

## Gradle

Run `gradlew clean run` on your machine.

## Java

- Run `gradlew clean compileJava`
- `cd app/build/classes/java/main`
- Run `java jdk11.encoding.issue.App`

# Results

|  | macOS 11 Gradle | Windows 10 Gradle | macOS 11 Java | Windows 10 Java |
|---|---|---|---|---|
| defaultCharacterEncoding | UTF-8 | UTF-8  | UTF-8 | windows-1252 |
| file.encoding | UTF-8  | UTF-8 | UTF-8 | Cp1252 |
| sun.jnu.encoding | null | Cp1252 | UTF-8 | Cp1252 |
| sun.stdout.encoding | null | null  | null | cp437 |
| sun.stderr.encoding | null | null | null | cp437 |
| Printing Hähö | Hähö :white_check_mark: | HΣH÷ :x: | Hähö :white_check_mark: | Hähö :white_check_mark: |