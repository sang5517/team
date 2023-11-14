package com.TeamProject.TeamProject.Naver;

import ch.qos.logback.classic.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.nio.charset.Charset;


@Controller
public class NaverController {
    // Declare a logger
    private static final Logger log = (Logger) LoggerFactory.getLogger(NaverController.class);

    @GetMapping("/naver")
    public String naver(){
        URI uri = UriComponentsBuilder
                .fromUriString("https://openapi.naver.com")
                .path("/v1/search/local.json")
                .queryParam("query","대전 서구 국밥")
                .queryParam("display", 100)
                .queryParam("start", 1)
                .queryParam("sort", "random")
                .encode(Charset.forName("UTF-8"))
                .build()
                .toUri();

        log.info("uri : {}", uri);

        RestTemplate restTemplate = new RestTemplate();

        // 헤더 추가 위해
        RequestEntity<Void> req = RequestEntity
                .get(uri)
                .header("X-Naver-Client-Id", "P5UyFtfOmhKKp9jOUfcg")
                .header("X-Naver-Client-Secret", "lGZXd7sXhR")
                .build();

        ResponseEntity<String> result = restTemplate.exchange(req, String.class);

        return result.getBody();
    }
}
