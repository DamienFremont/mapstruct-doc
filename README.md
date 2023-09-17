# MapStruct Doc Maven Plugin

:warning: **WORK IN PROGRESS !!!**

The mapstruct-doc Plugin generate mapping doc for the specified project (csv,
markdown or asciidoc).

Liked some of my work? Buy me a coffee (or more likely a beer)

<a href="https://www.buymeacoffee.com/damienfremont" target="_blank"><img src="https://bmc-cdn.nyc3.digitaloceanspaces.com/BMC-button-images/custom_images/orange_img.png" alt="Buy Me A Coffee" style="height: auto !important;width: auto !important;" ></a>

Content:

1. [Introduction](#introduction)
2. [Usage](#usage)
3. [Features](#features)
4. [External links](#external-links)
5. [License](#license)

---

## Introduction

The MapStruct Doc Plugin generate mapping doc for the specified project (CSV,
Markdown or AsciiDoc).

![alt text](./docs/diagrams.jpg)

## Usage

To use the Spring Boot Maven Plugin, include the appropriate XML in the plugins
section of your pom.xml, as shown in the following example:

### Basic Example

```xml
<!-- pom.xml -->
<project>
  <!-- ... -->
  <build>
    <plugins>
      <plugin>
        <groupId>com.damienfremont.mapstructdoc</groupId>
        <artifactId>mapstruct-doc-maven-plugin</artifactId>
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
|       Maven        |   :x: |      |
|    Scan Javadoc    |   :x: |      |
|    Generate CSV    |   :x: |      |
| Generate     Text  |   :x: |      |
| Generate  Markdown |   :x: |      |
|   Generate  HTML   |   :x: |      |
| Generate  AsciiDoc |   :x: |      |
|     maven-site     |   :x: |      |
|       Gradle       |   :x: |      |

## External links

- [mapstruct.org](https://mapstruct.org/)
- stackoverflow.com
    - ["Generate documentation from Mapstruct code ?"](https://stackoverflow.com/questions/74796733/generate-documentation-from-mapstruct-code)
- resources
    - [maven-plugin (README layout)](https://docs.spring.io/spring-boot/docs/current/maven-plugin/reference/htmlsingle/)
    - [mojo-executor (project layout)](https://github.com/mojo-executor/mojo-executor)
    - [maven-compiler (tests layout)](https://github.com/apache/maven-compiler-plugin)
    - [enunciate (gradle plugin)](https://github.com/stoicflame/enunciate-gradle)

## License

[MIT License](https://opensource.org/license/mit/)

# Contributing

Want to contribute ? Please contact the [authors](mailto:damien.fremont@gmail.com).