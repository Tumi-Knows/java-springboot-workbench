package tumiknows.demo.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class ApiExceptionDemoApp {

    public static void main(String[] args) {
        log.info("Exceptions demo started...");
        SpringApplication.run(ApiExceptionDemoApp.class, args);
    }

}