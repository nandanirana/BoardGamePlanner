# Getting Started

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/4.1.1/maven-plugin)
* [Create an OCI image](https://docs.spring.io/spring-boot/4.1.1/maven-plugin/build-image.html)
* [Spring Web](https://docs.spring.io/spring-boot/4.1.1/reference/web/servlet.html)
* [Spring Data JPA](https://docs.spring.io/spring-boot/4.1.1/reference/data/sql.html#data.sql.jpa-and-spring-data)

### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)
* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)
* [Accessing data with MySQL](https://spring.io/guides/gs/accessing-data-mysql/)

### Public demo deployment (Render)

The repository includes a Dockerfile and Render Blueprint for a free public demo.
The `demo` profile uses an in-memory database seeded with fictional sample records.
All visitors share that data and can add or delete entries. The sample data resets
when the service restarts or redeploys, so do not enter real personal information.

1. Push this project to a GitHub repository. Do not upload `boardgameplanner-data.mv.db`;
   it contains your local data and is excluded by `.gitignore`.
2. In Render, create a new **Blueprint** and connect the GitHub repository.
3. Review the `boardgameplanner-demo` web service and deploy it.
4. Open the `onrender.com` URL Render assigns to the service.

The free service may sleep while idle and take a short time to wake. No custom domain
is needed. This public demo is not a private or production service for real contact data.

### Maven Parent overrides

Due to Maven's design, elements are inherited from the parent POM to the project POM.
While most of the inheritance is fine, it also inherits unwanted elements like `<license>` and `<developers>` from the parent.
To prevent this, the project POM contains empty overrides for these elements.
If you manually switch to a different parent and actually want the inheritance, you need to remove those overrides.
