# Contributing

Want to contribute?

Please contact the [authors](mailto:damien.fremont@gmail.com).

## CI

### Sonar

```bash
# install
docker pull library/sonarqube:10.4.0-community
docker pull sonarsource/sonar-scanner-cli:5.0.1
docker run -d --name sonarqube -p 9000:9000 sonarqube
# security
# (http://localhost:9000 > sonar menu > 'Administration' > 'Configuration' > 'Security' > 'Force user authentication':off)

# usage: scan with docker
docker run -it --rm --net=host -e SONAR_SCANNER_OPTS="-Dsonar.projectKey=mapstruct-doc" -v ".:/usr/src" sonarsource/sonar-scanner-cli

# result
# http://localhost:9000/dashboard?id=mapstruct-doc
```

#### Debug

```powershell
# security
# (http://localhost:9000 > sonar menu > 'my account' > 'security' > 'type:globa'l > 'generate' > copy token value)

# usage:scan with maven
$Env:JAVA_HOME='C:\Program Files\Java\jdk-17.0.9+9\'
$env:Path = [System.Environment]::GetEnvironmentVariable("Path","Machine") + ";" + [System.Environment]::GetEnvironmentVariable("Path","User")
mvn clean verify sonar:sonar -Pcoverage -Dsonar.projectKey=mapstruct-doc -Dsonar.projectName='mapstruct-doc' -Dsonar.host.url=http://localhost:9000 -Dsonar.token=...
```

## Resources

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

