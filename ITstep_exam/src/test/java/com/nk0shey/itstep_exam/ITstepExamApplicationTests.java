package com.nk0shey.itstep_exam;

import com.nk0shey.itstep_exam.api.Post;
import com.nk0shey.itstep_exam.api.PostClient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.http.MediaType;
import org.springframework.web.client.ResourceAccessException;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class ITstepExamApplicationTests {
    @Autowired MockMvc mvc;
    @MockitoBean PostClient client;
    @Test void validUser() throws Exception {
        mvc.perform(post("/users").contentType(MediaType.APPLICATION_JSON)
            .content("{\"name\":\"Ivan\",\"email\":\"ivan@example.org\"}"))
            .andExpect(status().isOk());
    }
    @Test void invalidUsers() throws Exception {
        for (String body : new String[]{"{}", "{\"name\":\"Ivan\"}", "{\"name\":\"Ivan\",\"email\":\"bad\"}", "{\"name\":\" \",\"email\":\"a@b.org\"}"})
            mvc.perform(post("/users").contentType(MediaType.APPLICATION_JSON).content(body)).andExpect(status().isBadRequest());
    }
    @Test void posts() throws Exception {
        Post p = new Post(); p.setId(1); p.setTitle("Test");
        when(client.fetchPosts()).thenReturn(new Post[]{p});
        mvc.perform(get("/posts")).andExpect(status().isOk()).andExpect(jsonPath("$[0].title").value("Test"));
    }
    @Test void upstreamFailure() throws Exception {
        when(client.fetchPosts()).thenThrow(new ResourceAccessException("offline"));
        mvc.perform(get("/posts")).andExpect(status().isBadGateway());
    }
    @Test void emailDisabled() throws Exception {
        mvc.perform(post("/email").param("to", "test@example.org")).andExpect(status().isOk());
        mvc.perform(post("/email")).andExpect(status().isBadRequest());
    }
}
