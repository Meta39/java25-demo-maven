package com.fu.springbootdemo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class SpringBootDemoApplication {

    static void main() {
        SpringApplication.run(SpringBootDemoApplication.class);
        log.error("start success.");
    }

}
