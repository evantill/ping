package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class SmokeTests {

    @Autowired
    private HomeController homeController;

    @Autowired
    private PingController pingController;

    @Test
    void homeControllerHelloReturnStaticContent() {
        assertThat(homeController).isNotNull();
        assertThat(homeController.hello()).contains("Welcome JSP");
    }

    @Test
    void pingControllerShouldRespondPong() {
        assertThat(pingController).isNotNull();
        assertThat(pingController.ping()).contains("pong");
    }
}
