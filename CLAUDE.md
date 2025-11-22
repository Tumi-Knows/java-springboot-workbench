# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Project Overview

This is a multi-module Maven workbench for experimenting with Java and Spring Boot. The parent POM (`pom.xml`) manages shared dependencies and build configuration for all sub-modules.

**Technology Stack:**
- Java 21
- Spring Boot 3.5.7
- Maven (with wrapper scripts `mvnw` and `mvnw.cmd`)
- Lombok for boilerplate reduction

## Project Structure

```
java-springboot-workbench/          # Parent POM (packaging: pom)
├── api-exception-demo/             # Sub-module for API exception handling demos
│   └── src/main/java/tumiknows/demo/exceptions/
│       ├── ApiExceptionDemoApp.java              # Main application class
│       └── controller/
│           └── ExceptionsDemoApiController.java  # REST controller
└── pom.xml                         # Parent POM with dependency management
```

**Key Architectural Points:**
- Parent POM uses `<packaging>pom</packaging>` and declares modules via `<modules>` section
- Sub-modules inherit from parent but declare their own specific dependencies
- All modules use the base package pattern: `tumiknows.demo.*`
- Lombok is configured at the parent level with annotation processing in the Maven compiler plugin

## Common Commands

### Build Commands
```bash
# Build entire project (all modules)
./mvnw clean install

# Build specific module
./mvnw clean install -pl api-exception-demo

# Build without running tests
./mvnw clean install -DskipTests

# Compile only
./mvnw clean compile
```

### Running Applications
```bash
# Run a specific Spring Boot module
./mvnw spring-boot:run -pl api-exception-demo

# Run from module directory
cd api-exception-demo
../mvnw spring-boot:run
```

### Testing
```bash
# Run all tests
./mvnw test

# Run tests for specific module
./mvnw test -pl api-exception-demo
```

### Adding New Modules
When creating a new module:
1. Add module directory to root
2. Create module's `pom.xml` with parent reference:
   ```xml
   <parent>
       <groupId>co.za.tumiknows</groupId>
       <artifactId>java-workbench</artifactId>
       <version>0.0.1-SNAPSHOT</version>
   </parent>
   ```
3. Add module to parent POM's `<modules>` section
4. Dependencies declared in parent's `<dependencyManagement>` can be used without version tags

## Module-Specific Information

### api-exception-demo
- **Purpose:** Demonstrates exception handling in Spring Boot REST APIs
- **Port:** 9000 (configured in `application.yml`)
- **Main Class:** `tumiknows.demo.exceptions.ApiExceptionDemoApp`
- **Base URL:** `http://localhost:9000/demo`
- **Available Endpoints:**
  - `GET /demo/ping` - Basic health check endpoint