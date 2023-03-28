package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HttpRequestTests {

    @Value(value = "${local.server.port}")
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void homePageShouldReturnStaticPageContent() throws Exception {
        assertThat(httpGetString("/")).contains("Welcome JSP");
    }

    @Test
    public void staticHtmlPageShouldBeVisisble() throws Exception {
        assertThat(httpGetString("/static.html")).contains("static HTML file");
    }

    private String httpGetString(String url) {
        return this.restTemplate.getForObject(absoluteUrl(url), String.class);
    }

    private String absoluteUrl(String url) {
        StringBuilder absoluteUrl = new StringBuilder();
        if(url.startsWith("http")) {
            //absolute url
            absoluteUrl.append(url);
        }else{
            //relative url
            absoluteUrl.append("http://localhost:").append(port);
            if(url.startsWith("/")){
                absoluteUrl.append(url);
            }else{
                absoluteUrl.append('/').append(url);
            }
        }
        return absoluteUrl.toString();
    }

}
