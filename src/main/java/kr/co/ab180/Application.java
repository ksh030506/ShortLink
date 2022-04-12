package kr.co.ab180;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class Application {

    @RestController
    public static class HealthCheckController {

        @GetMapping(value = {"/health", "/"})
        public String healthCheck() {
            return "ok";
        }
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}