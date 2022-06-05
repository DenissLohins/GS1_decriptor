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
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@Sql(scripts = "/truncate-script.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
class DecryptControllerIT {

    @Autowired
    private MockMvc mockMvc;


    @Test
    @Order(1)
    void shouldSaveEntity() throws Exception {
        fillWithOneRecordAndTestThisRecord();
    }

    @Test
    @Order(2)
    void shouldGetById() throws Exception {
        fillWithOneRecordAndTestThisRecord();
        mockMvc.perform(get("/decrypt/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.responseEntity.id").value("1"))
                .andExpect(jsonPath("$.responseEntity.request").value("]20104751022900835211312628744741060042117231231"));
    }


    @Test
    @Order(3)
    void shouldGetAllrequests() throws Exception {
        mockMvc.perform(get("/decrypt")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$..id", hasSize(0)));
        fillWithOneRecordAndTestThisRecord();
        mockMvc.perform(get("/decrypt")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$..id", hasSize(1)));
    }

    private String createEntityJSON() throws JSONException {
        return new JSONObject()
                .put("requestString", "]20104751022900835211312628744741060042117231231")
                .toString();
    }

    private void fillWithOneRecordAndTestThisRecord() throws Exception {
        mockMvc.perform(post("/decrypt")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(createEntityJSON()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value("1"));
    }
}