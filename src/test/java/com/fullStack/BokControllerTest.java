package com.fullStack;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.*;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.MOCK;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class) // JUnit
@SpringBootTest(webEnvironment = MOCK, classes = DemoApplication.class) // Spring
@AutoConfigureMockMvc // Trengs for å kunne autowire MockMvc
class BokControllerTest {
  @Autowired
  private MockMvc mockMvc;  // Krever at @AutoConfigureMockMvc er satt, brukes til å fyre av requests

  @Test
  void getBoeker() throws Exception {

    mockMvc.perform(get("/boeker").contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$", hasSize(greaterThanOrEqualTo(1))))
        .andExpect(jsonPath("$[0].navn", is("hei")));


  }
}