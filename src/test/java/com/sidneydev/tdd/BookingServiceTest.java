package com.sidneydev.tdd;

import com.sidneydev.tdd.model.BookingModel;
import com.sidneydev.tdd.repository.BookingRepository;
import com.sidneydev.tdd.service.BookingService;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;

@RunWith(SpringRunner.class)
public class BookingServiceTest {

    @TestConfiguration
    static class BookingServiceTestConfiguration{

        @Bean
        public BookingService bookingService(){
            return new BookingService();
        }
    }

    @Autowired
    BookingService bookingService;

    @MockBean
    BookingRepository bookingRepository;

    @Test
    public void bookingTestServiceDaysCalculator(){
        String name = "Sidney";
        int days = bookingService.daysCalculatorWithDatabase(name);

        //Assertions.assertEquals(days, actual: 10);
    }

    @Before
    public void setup(){
        LocalDate checkIn = LocalDate.parse("2024-02-10");
        LocalDate checkOut = LocalDate.parse("2024-02-20");
        BookingModel bookingModel = new BookingModel("1", "Sidney", checkIn, checkOut, 2);

        Mockito.when(bookingRepository.findByReserveName(bookingModel.getReserveName()))
                .thenReturn(java.util.Optional.of(bookingModel));
    }
}
