package com.decryptor.config.controller;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class DecryptControllerIT {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    @Order(1)
    void shouldSaveEntity() throws Exception {
        mockMvc.perform(post("/decrypt")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(createEntityJSON()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value("1"));

    }

    @Test
    @Order (2)
    void shouldGetById() throws Exception {
        mockMvc.perform(post("/decrypt")
                .contentType(MediaType.APPLICATION_JSON)
                .content(createEntityJSON()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value("2"));

        mockMvc.perform(get("/decrypt/2")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(createEntityJSON()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.responseEntity.id").value("2"))
                .andExpect(jsonPath("$.responseEntity.request").value("]20104751022900835211312628744741060042117231231"));
    }


    private String createEntityJSON() throws JSONException {
        return new JSONObject()
                .put("requestString", "]20104751022900835211312628744741060042117231231")
                .toString();
    }
}