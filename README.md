# MapStruct Doc Maven Plugin

[![Latest Version](https://img.shields.io/badge/Latest%20Version-1.5.5-orange.svg)](https://search.maven.org/search?q=g:org.mapstruct%20AND%20v:1.*.Final)
[![License](https://img.shields.io/badge/License-MIT-yellowgreen.svg)](https://github.com/mapstruct/mapstruct/blob/main/LICENSE.txt)
[![Follow](https://img.shields.io/twitter/follow/Damien_Fremont?style=social&logo=X)](https://twitter.com/intent/follow?screen_name=Damien_Fremont)

:warning: **WORK IN PROGRESS !!!**

Mapstruct-doc plugin generate mapping documentation for your project (csv,
markdown or asciidoc).

Liked some of my work? Buy me a coffee (or more likely a beer)

<a href="https://www.buymeacoffee.com/damienfremont" target="_blank"><img src="https://bmc-cdn.nyc3.digitaloceanspaces.com/BMC-button-images/custom_images/orange_img.png" alt="Buy Me A Coffee" style="height: auto !important;width: auto !important;" ></a>

Content:

1. [Introduction](#introduction)
2. [Get Started](#get-started)
    1. [Maven](#maven)
3. [Features](#features)
4. [External links](#external-links)
5. [License](#license)

---

## Introduction

The MapStruct Doc Plugin generate mapping doc for the specified project (CSV,
Markdown or AsciiDoc).

![alt text](./docs/diagrams.jpg)

## Get Started

### Maven

To use the Maven Plugin, include the appropriate XML in the plugins section of
your pom.xml, as shown in the following example:

```xml
<!-- pom.xml -->
<project>
  <!-- ... -->
  <build>
    <plugins>
      <plugin>
        <groupId>org.apache.maven.plugins</groupId>
        <artifactId>maven-compiler-plugin</artifactId>
        <version>3.8.1</version>
        <configuration>
          <source>1.8</source> <!-- depending on your project -->
          <target>1.8</target> <!-- depending on your project -->
          <annotationProcessorPaths>
            <path>
              <groupId>org.mapstruct</groupId>
              <artifactId>mapstruct-processor</artifactId>
              <version>${org.mapstruct.version}</version>
            </path>
            <path>
              <groupId>com.damienfremont.mapstruct</groupId>
              <artifactId>mapstruct-doc-processor</artifactId>
              <version>1.5.5-SNAPSHOT</version>
            </path>
          </annotationProcessorPaths>
        </configuration>
      </plugin>
    </plugins>
  </build>
</project>
```

And execute any of the following commands:

```bash
mvn clean compile
```

## Features

|      Feature       | State | Note |
|:------------------:|------:|-----:|
| maven              |   :heavy_check_mark: |      |
| scan-javadoc       |   :x: |      |
| generate-csv       |   :x: |      |
| generate-text      |   :x: |      |
| generate-markdown  |   :x: |      |
| generate-html      |   :x: |      |
| generate-asciidoc  |   :x: |      |
| maven-site         |   :x: |      |
| gradle             |   :x: |      |

## External links

- mapstruct.org
    - [ide-support](https://mapstruct.org/documentation/ide-support/)
- stackoverflow.com
    - ["Generate documentation from Mapstruct code ?"](https://stackoverflow.com/questions/74796733/generate-documentation-from-mapstruct-code)
- other
    - [maven-plugin (README layout)](https://docs.spring.io/spring-boot/docs/current/maven-plugin/reference/htmlsingle/)
    - [mojo-executor (project layout)](https://github.com/mojo-executor/mojo-executor)
    - [maven-compiler (tests layout)](https://github.com/apache/maven-compiler-plugin)
    - [enunciate (gradle plugin)](https://github.com/stoicflame/enunciate-gradle)
- hannesdorfmann.com
    - [Annotation Processing 101: post](http://hannesdorfmann.com/annotation-processing/annotationprocessing101/)
    - [Annotation Processing 101: github](https://github.com/sockeqwe/annotationprocessing101)
- baeldung.com
    - [Java Annotation Processing and Creating a Builder](https://www.baeldung.com/java-annotation-processing-builder)

## License

[MIT License](https://opensource.org/license/mit/)

## Contributing

Want to contribute ? Please contact
the [authors](mailto:damien.fremont@gmail.com).

![GitHub Contributors Image](https://contrib.rocks/image?repo=DamienFremont/mapstruct-doc-plugin)
