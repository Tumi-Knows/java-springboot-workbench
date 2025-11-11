package tumiknows.demo.exceptions.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("demo")
public class ExceptionsDemoApiController {

    @GetMapping(value = "/ping", produces = "text/json")
    public String ping() {
        log.info("Pinging... inside /demo/ping endpoint...");
        return "success";
    }
}
