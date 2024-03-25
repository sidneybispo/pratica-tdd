package com.sidneydev.tdd.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sidneydev.tdd.model.BookingModel;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class BookingControllerTest {

    @Autowired
    MockMvc mockMvc;
    
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void bookingTestGetAll() throws Exception {
        mockMvc.perform(get("/bookings"))
                .andExpect(status().isOk());
    }
    
    @Test
    public void bookingTestSave() throws Exception {
        LocalDate checkIn = LocalDate.parse("2024-02-10");
        LocalDate checkOut = LocalDate.parse("2024-02-20");
        BookingModel bookingModel = new BookingModel("1", "Sidney", checkIn, checkOut, 2);
        
        mockMvc.perform(post("/bookings"))
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(bookingModel))
                .andExpected(status().isOk()); 
    }
}
