# MapStruct Doc - Maven & Gradle Plugin

[![License](https://img.shields.io/badge/License-Apache%202.0-yellowgreen.svg)](https://github.com/DamienFremont/mapstruct-doc/blob/main/LICENSE)
[![Follow](https://img.shields.io/twitter/follow/Damien_Fremont?style=social&logo=X)](https://twitter.com/intent/follow?screen_name=Damien_Fremont)
[!["Buy Me A Coffee"](./documentation/buymeacoffee-20.png)](https://www.buymeacoffee.com/damienfremont)

:warning: **WORK IN PROGRESS !!!**

- [What is MapStruct Doc?](#what-is-mapstruct-doc)
- [Requirements](#requirements)
- [Using MapStruct Doc](#using-mapstruct-doc)
    - [Maven](#maven)
- [Contributors](#contributors)
- [Licensing](#licensing)

---

## What is MapStruct Doc?

MapStruct Doc is a
Java [annotation processor](https://docs.oracle.com/javase/6/docs/technotes/guides/apt/index.html)
for the generation of documentation for mapping interface (CSV, Markdown or
AsciiDoc).

![alt text](documentation/diagrams.jpg)

At compile time MapStruct will generate a file for each interface.

### Features

|      Feature      |              State | Note |
| :---------------: | -----------------: | ---: |
|   generate-csv    |     :construction: |      |
|   generate-text   |                :x: |      |
| generate-markdown |                :x: |      |
|   generate-html   |                :x: |      |
| generate-asciidoc |                :x: |      |
|       maven       | :heavy_check_mark: |      |
|    maven-site     |                :x: |      |
|      gradle       |                :x: |      |
|   scan-javadoc    |                :x: |      |

## Requirements

MapStruct Doc requires Java 1.8 or later.

## Using MapStruct Doc

### Maven

For Maven-based projects, add the following to your POM file in order to use
MapStruct Doc:

```xml

<project>
  ...
  <properties>
    <mapstruct-doc.version>1.5.5-SNAPSHOT</mapstruct-doc.version>
  </properties>
  ...
  <build>
    <plugins>
      ...
      <plugin>
        <groupId>com.damienfremont.mapstruct</groupId>
        <artifactId>mapstruct-doc-maven-plugin</artifactId>
        <version>${mapstruct-doc.version}</version>
        <configuration>
          <include>com.damienfremont.mapstruct.example.getstarted.CarMapper</include>
        </configuration>
        <executions>
          <execution>
            <goals>
              <goal>generate</goal>
            </goals>
            <phase>install</phase>
          </execution>
        </executions>
      </plugin>
    </plugins>
  </build>
</project>
```

And execute any of the following commands:

```bash
mvn install -DskipTests
```

```bash
mvn com.damienfremont.mapstruct:mapstruct-doc-maven-plugin:1.5.5-SNAPSHOT:generate
```

## Contributors

Want to contribute? [CONTRIBUTING.md](./CONTRIBUTING.md)

![GitHub Contributors Image](https://contrib.rocks/image?repo=DamienFremont/mapstruct-doc)

## Licensing

Copyright (c) 2023 Damien FREMONT.

Licensed under the Apache License version 2.0, available
at http://www.apache.org/licenses/LICENSE-2.0
