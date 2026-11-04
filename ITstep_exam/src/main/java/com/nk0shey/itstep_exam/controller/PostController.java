package com.nk0shey.itstep_exam.controller;

import com.nk0shey.itstep_exam.api.Post;
import com.nk0shey.itstep_exam.api.PostClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostController {

    private final PostClient postClient;

    public PostController(PostClient postClient) {
        this.postClient = postClient;
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(org.springframework.web.client.RestClientException.class)
    public org.springframework.http.ResponseEntity<String> upstreamError() {
        return org.springframework.http.ResponseEntity.status(502).body("Posts service is unavailable");
    }

    @GetMapping("/posts")
    public Post[] getPosts() {
        return postClient.fetchPosts();
    }
}
