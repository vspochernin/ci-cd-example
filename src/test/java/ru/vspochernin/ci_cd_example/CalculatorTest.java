package ru.vspochernin.ci_cd_example;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class CalculatorTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void correctlyPlus() throws Exception {
        mockMvc.perform(get("/plus?a=4&b=3"))
                .andExpect(status().isOk())
                .andExpect(content().string("7"));
    }

    @Test
    public void plusWithoutA() throws Exception {
        mockMvc.perform(get("/plus?b=3"))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void plusWithoutB() throws Exception {
        mockMvc.perform(get("/plus?a=4"))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void plusWithoutParams() throws Exception {
        mockMvc.perform(get("/plus"))
                .andExpect(status().isBadRequest());
    }
}