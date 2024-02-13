$Env:JAVA_HOME='C:\Program Files\Java\jdk-17.0.9+9\'
$env:Path = [System.Environment]::GetEnvironmentVariable("Path","Machine") + ";" + [System.Environment]::GetEnvironmentVariable("Path","User")
mvn clean verify sonar:sonar -Pcoverage -Dsonar.projectKey=mapstruct-doc -Dsonar.projectName='mapstruct-doc' -Dsonar.host.url=http://localhost:9000 -Dsonar.token=sqa_1bcd68469bd8991cdfc3c0ea26c192e4bb1f61e7
