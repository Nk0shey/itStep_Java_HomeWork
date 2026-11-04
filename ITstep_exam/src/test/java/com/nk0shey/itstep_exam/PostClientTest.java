package com.nk0shey.itstep_exam;
import com.nk0shey.itstep_exam.api.PostClient;
import org.junit.jupiter.api.Test;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.MediaType;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.*;
import static org.springframework.test.web.client.response.MockRestResponseCreators.*;
import static org.junit.jupiter.api.Assertions.*;
class PostClientTest {
 @Test void deserializesPosts() {
  var customizer = new org.springframework.boot.test.web.client.MockServerRestTemplateCustomizer();
  PostClient client = new PostClient(new RestTemplateBuilder(customizer),"https://posts.test/posts");
  MockRestServiceServer server = customizer.getServer();
  server.expect(requestTo("https://posts.test/posts")).andRespond(withSuccess("[{\"id\":7,\"title\":\"Example\"}]",MediaType.APPLICATION_JSON));
  assertEquals(7,client.fetchPosts()[0].getId()); server.verify();
 }
}
