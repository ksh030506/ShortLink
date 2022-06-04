package kr.co.short_link;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableJpaAuditing
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
