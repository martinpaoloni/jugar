# Getting Started
## Create a Maven Project
1. mkdir jugar
2. cd jugar
3. create: pom.xml and put this content inside:
```
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/maven-v4_0_0.xsd">
  <parent>
    <groupId>org.knowhow</groupId>
    <artifactId>modern-web-app</artifactId>
    <version>0.1.0-SNAPSHOT</version>
  </parent>

  <modelVersion>4.0.0</modelVersion>
  <groupId>org.knowhow.mwa.tutorial</groupId>
  <artifactId>jugar</artifactId>
  <version>1.0</version>
  <packaging>war</packaging>
  <name>A MWA Demo for the Java User Group Argentina</name>
</project>
```
4. Creates maven folders
 * mkdir -p src/main/java
 * mkdir -p src/main/resources
 * mkdir -p src/test/resources
 * mkdir -p src/test/java
 * mkdir -p src/main/webapp

## Generate Eclipse metadata
 * mvn eclipse:clean eclipse:eclipse
 * Refresh Eclipse workspaces (F5)