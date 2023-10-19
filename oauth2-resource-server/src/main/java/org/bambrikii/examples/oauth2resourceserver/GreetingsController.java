package org.bambrikii.examples.oauth2resourceserver;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@ResponseBody
public class GreetingsController {
    private final GreetingsService greetingsService;

    public GreetingsController(GreetingsService greetingsService) {
        this.greetingsService = greetingsService;
    }

    @GetMapping("/hello")
    Map<String, String> hello(@AuthenticationPrincipal Jwt jwt) {
        return Map.of("message", "Hello " + jwt.getSubject());
    }

    @GetMapping("/hello2")
    Map<String, String> hello2(@AuthenticationPrincipal Jwt jwt) {
        return greetingsService.greet();
    }
}
