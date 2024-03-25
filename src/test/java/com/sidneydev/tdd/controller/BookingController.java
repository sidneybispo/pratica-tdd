package com.sidneydev.tdd.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ResponseBody;

@RestController
@RequestMapping("/bookings")
public class BookingController {

    @GetMapping
    @ResponseBody
    public String getAll(){
        return "OK";
    }

    @PostMapping
    public ResponseEntity<BookingModel> save(BookingModel bookingModel){
        return ResponseEntity.status(HttpStatus.OK).body(bookingModel);
    }

}
