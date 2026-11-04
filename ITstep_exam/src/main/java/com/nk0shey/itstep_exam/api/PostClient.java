package com.nk0shey.itstep_exam.api;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import java.time.Duration;

@Component
public class PostClient {
    private final RestTemplate client;
    private final String url;
    public PostClient(RestTemplateBuilder builder,
                      @Value("${posts.url:https://jsonplaceholder.typicode.com/posts}") String url) {
        this.client = builder.connectTimeout(Duration.ofSeconds(5)).readTimeout(Duration.ofSeconds(10)).build();
        this.url = url;
    }
    public Post[] fetchPosts() {
        Post[] posts = client.getForObject(url, Post[].class);
        return posts == null ? new Post[0] : posts;
    }
}
