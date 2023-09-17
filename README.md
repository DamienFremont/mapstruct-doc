# MapStruct Doc Maven Plugin

:warning: **WORK IN PROGRESS !!!**

The mapstruct-doc Plugin generate mapping doc for the specified project (csv,
markdown or asciidoc).

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

(TODO: Java to CSV image)

TODO: buy me a beer

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
- base
    - [maven-plugin (README layout)](https://docs.spring.io/spring-boot/docs/current/maven-plugin/reference/htmlsingle/)
    - [mojo-executor (project layout)](https://github.com/mojo-executor/mojo-executor)
    - [maven-compiler (tests layout)](https://github.com/apache/maven-compiler-plugin)
    - [enunciate (gradle plugin)](https://github.com/stoicflame/enunciate-gradle)

## License

[MIT License](https://opensource.org/license/mit/)
