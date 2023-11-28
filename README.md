# MapStruct Doc Maven Plugin

<p align="center">
    <a href="https://circleci.com/gh/badges/shields/tree/master">
        <img src="https://img.shields.io/circleci/project/github/badges/shields/master" alt="build status"></a>
    <a href="https://coveralls.io/github/badges/shields">
        <img src="https://img.shields.io/coveralls/github/badges/shields"
            alt="coverage"></a>
    <a href="https://twitter.com/intent/follow?screen_name=Damien_Fremont">
        <img src="https://img.shields.io/twitter/follow/Damien_Fremont?style=social&logo=X"
            alt="follow on Twitter"></a>
</p>

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
        <groupId>com.damienfremont.mapstructdoc</groupId>
        <artifactId>mapstruct-doc-maven-plugin</artifactId>
        <version>1.0.0-SNAPSHOT</version>
      </plugin>
    </plugins>
  </build>
</project>
```

And execute any of the following commands:

```bash
mvn com.damienfremont.mapstructdoc:mapstruct-doc-maven-plugin:mapstruct-doc
```

## Features

|      Feature       | State | Note |
|:------------------:|------:|-----:|
| maven              |   :x: |      |
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

## License

[MIT License](https://opensource.org/license/mit/)

## Contributing

Want to contribute ? Please contact
the [authors](mailto:damien.fremont@gmail.com).

![GitHub Contributors Image](https://contrib.rocks/image?repo=DamienFremont/mapstruct-doc-plugin)
