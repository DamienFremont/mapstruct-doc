# Mapping Doc Maven Plugin

:warning: **WORK IN PROGRESS !!!**

The mapping-doc Plugin generate mapping doc for the specified project (csv,
markdown or asciidoc).

Content:

1. [Introduction](#introduction)
2. [Usage](#usage)
3. [Features](#features)
4. [External links](#external-links)
5. [License](#license)

---

## Introduction

The mapping-doc Plugin generate mapping doc for the specified project (CSV,
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
        <groupId>com.damienfremont.mapping</groupId>
        <artifactId>mapping-doc-maven-plugin</artifactId>
      </plugin>
    </plugins>
  </build>
</project>
```

And execute any of the following commands:

```bash
mvn com.damienfremont.mapping:mapping-doc-maven-plugin:mapstruct
mvn com.damienfremont.mapping:mapping-doc-maven-plugin:mapstruct-csv
mvn com.damienfremont.mapping:mapping-doc-maven-plugin:mapstruct-text
mvn com.damienfremont.mapping:mapping-doc-maven-plugin:mapstruct-markdown
mvn com.damienfremont.mapping:mapping-doc-maven-plugin:mapstruct-html
```

## Features

|      Feature       | State | Note |
|:------------------:|------:|-----:|
|   Scan MapStruct   |   :x: |      |
|    Scan Javadoc    |   :x: |      |
|  Scan SpringBatch  |   :x: |      |
|    Generate CSV    |   :x: |      |
| Generate     Text  |   :x: |      |
| Generate  Markdown |   :x: |      |
|   Generate  HTML   |   :x: |      |
| Generate  AsciiDoc |   :x: |      |
|     maven-site     |   :x: |      |

## External links

- [mapstruct.org](https://mapstruct.org/)
- stackoverflow.com
    - ["Generate documentation from Mapstruct code ?"](https://stackoverflow.com/questions/74796733/generate-documentation-from-mapstruct-code)
- spring.io
    - [maven-plugin (README layout)](https://docs.spring.io/spring-boot/docs/current/maven-plugin/reference/htmlsingle/)

## License

[MIT License](https://opensource.org/license/mit/)
