package org.example;


import org.example.entity.UserEntity;
import org.example.repository.RealUserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;


// The whole code was coded up by hand i will admit to getting ai help for exceptions and brushing up on weak concepts i need work with
@SpringBootApplication
@EnableCaching // first step to enabling caching
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Bean
    public CommandLineRunner initData(RealUserRepository realUserRepository) {
        return args -> {
            realUserRepository.save(new UserEntity("ralph", "Transaction 1"));
            realUserRepository.save(new UserEntity("Lil Homie", "Transaction 2"));
        };
    }
//    @Bean
//    public CommandLineRunner run(UserService userService) {
//        //return args -> userService.outerMethod();
//        return null;
//    }
}