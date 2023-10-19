package org.bambrikii.examples.oauth2authorizationserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@SpringBootApplication
public class Oauth2AuthorizationServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(Oauth2AuthorizationServerApplication.class, args);
    }

    @Bean
    InMemoryUserDetailsManager inMemoryUserDetailsManager() {
        var one = User.withDefaultPasswordEncoder().roles("admin").username("user1").password("pw").build();
        var two = User.withDefaultPasswordEncoder().roles("user.read").username("user2").password("pw").build();
        return new InMemoryUserDetailsManager(one, two);
    }
}
