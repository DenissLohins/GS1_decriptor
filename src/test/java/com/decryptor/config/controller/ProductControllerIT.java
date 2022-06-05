package com.decryptor.config.controller;


import org.json.JSONException;
import org.json.JSONObject;
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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@Sql(scripts = "/delete-test-script.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
class ProductControllerIT {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void shouldSaveProductEntity() throws Exception {
        fillProductListWithOneRecordAndTestIt();
    }

    @Test
    void shouldFindProductEntityById() throws Exception{
        fillProductListWithOneRecordAndTestIt();
        mockMvc.perform(get("/gtin/000000000000011")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.gtin").value("000000000000011"))
                .andExpect(jsonPath("$.name").value("Test Product"));
    }


    @Test
    void shouldFindAllProductEntities() throws Exception{
        mockMvc.perform(get("/gtin")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$..gtin", hasSize(71)));
        fillProductListWithOneRecordAndTestIt();
        mockMvc.perform(get("/gtin")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$..gtin", hasSize(72)));
    }

    private String createEntityJSON() throws JSONException {
        return new JSONObject()
                .put("gtin", "000000000000011")
                .put("name", "Test Product")
                .toString();
    }

    private void fillProductListWithOneRecordAndTestIt() throws Exception {
        mockMvc.perform(post("/gtin")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(createEntityJSON()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.gtin").value("000000000000011"));
    }

}