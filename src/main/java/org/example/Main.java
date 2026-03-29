package org.example;


import org.example.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


// The whole code was coded up by hand i will admit to getting ai help for exceptions and brushing up on weak concepts i need work with
@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

//    @Bean
//    public CommandLineRunner run(UserService userService) {
//        //return args -> userService.outerMethod();
//        return null;
//    }
}