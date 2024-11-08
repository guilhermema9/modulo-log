
# modulo-log

Projeto desenvolvido para a disciplina de Novas Tecnologias em Desenvolvimento para Web para o curso de Sistemas para Internet no IFTO campus Palmas



## Stack utilizada

**Back-end:** Java 17 ou superior

**Framework:** Spring Boot

**Framework de Persistência:** Spring Data JPA

**Banco de Dados:** H2  

**Documentação:** Spring REST Docs

**IDE:** JetBrains Intellij Idea


## Instalação

Certifique-se de estar com o JDK 17 (LTS), ou superior instalado. Se necessário, para instalar utilize o seguinte comando (distribuições Ubuntu/Debian):

```bash
sudo apt-get update && apt-get -y install openjdk-17-jdk 
```

Para instalar e configurar o SpringBoot utilize o Spring Initializr para criar o projeto e suas dependências em: https://start.spring.io/

**Gerenciador de Dependências:** Maven

**Spring Boot:** versão 3.3.5

**Packaging:** Jar

**Dependências: (obrigatórias)** Spring Web, Spring Data JPA, Spring Security, H2 Database.

**Dependências: (opcionais)** Spring Boot Dev Tools, Spring REST Docs, Lombok, dentre outras (conforme necessidade).

```xml
 <dependencies>
    <dependency>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-starter-security</artifactId>
    </dependency>
    <dependency>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-starter-web</artifactId>
    </dependency>

    <dependency>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-devtools</artifactId>
      <scope>runtime</scope>
      <optional>true</optional>
    </dependency>
    <dependency>
      <groupId>org.projectlombok</groupId>
      <artifactId>lombok</artifactId>
      <optional>true</optional>
    </dependency>
    <dependency>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-starter-test</artifactId>
      <scope>test</scope>
    </dependency>
    <dependency>
      <groupId>org.springframework.restdocs</groupId>
      <artifactId>spring-restdocs-mockmvc</artifactId>
      <scope>test</scope>
    </dependency>
    <dependency>
      <groupId>org.springframework.security</groupId>
      <artifactId>spring-security-test</artifactId>
      <scope>test</scope>
    </dependency>
  </dependencies>

```
## Arquitetura

Neste projeto será utilizado a arquitetura MVC

```css
modulo-log
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com
│   │   │       └── modulolog
│   │   │           ├── controller
│   │   │           ├── model
│   │   │           ├── repository
│   │   │           └── security
│   │   └── resources
│   │       └── application.properties
│   └── test
├── pom.xml
```
## Configuração

Após a instalação do ambiente de desenvolvimento, deverá ser realizado a seguinte configuração no `application.properties`:

```properties
# Configuração do banco de dados H2
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=

# Configuração do console H2 (interface web)
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console

# Configuração JPA
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```
## Autores

- [Guilherme Mendes Araujo - @guilhermema9](https://github.com/guilhermema9/)
- [Yago de Lima França - @Yago-Lima](https://github.com/Yago-Lima/)
