package com.spring.springboot.mobile_phone_springboot;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

//@ActiveProfiles(profiles = {"test"})

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@Testcontainers
public abstract class BasedTestContainersTest {
    @Container
    public static PostgreSQLContainer postgreSQLContainer = new PostgreSQLContainer("postgres:15.2")
        .withDatabaseName("test")
        .withUsername("test")
        .withPassword("test");

    /**
     * static methods for one container of all tests in test class
     * @param registry
     */
    @DynamicPropertySource
    public static void dbProperties(final DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.driver-class-name", () -> "org.postgresql.Driver");
        registry.add("spring.datasource.jdbcUrl", postgreSQLContainer::getJdbcUrl);
        registry.add("spring.datasource.url", postgreSQLContainer::getJdbcUrl);
        registry.add("spring.datasource.username", postgreSQLContainer::getUsername);
        registry.add("spring.datasource.password", postgreSQLContainer::getPassword);
        registry.add("spring.jpa.properties.hibernate.dialect", () -> "org.hibernate.dialect.PostgreSQL10Dialect");
        registry.add("spring.liquibase.changeLog", () -> "classpath:db/changelog/db.changelog-master.yaml");
        registry.add("spring.liquibase.enabled", () -> true);
    }
}
