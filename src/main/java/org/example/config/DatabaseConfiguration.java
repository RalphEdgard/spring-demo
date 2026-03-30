package org.example.config;

import org.postgresql.ds.PGSimpleDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

// the spring project did not need the configuartion class because there was a dependency in the pom.xml file that allowed spring to understand that i needed a database and thanks to the spring boot application annotation in the main class there were automatic set ups that allowed the jpa repository to work seamlessly and my properties file was able to be read as well which is loaded in to the environment class. The configuration class is just a reference for me to understand how i can set things up manually
@Configuration
@PropertySource("application.properties")
// @ConfigurationProperties(prefix = "spring.datasource") // with the config props annotation you wouldnt need the @value annotations but i like to include the @value annotations
public class DatabaseConfiguration {

    @Value("spring.datasource.url")
    String url;

    @Value("spring.datasource.username")
    String username;

    @Value("spring.datasource.password")
    String password;

    @Bean // practice
    public DataSource dataSource() {
        PGSimpleDataSource ds = new PGSimpleDataSource();
        ds.setURL(url);
        ds.setUser(username);
        ds.setPassword(password);
        return ds;
    }
}
