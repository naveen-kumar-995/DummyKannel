package com.connect.DummyKannel.controller;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class MainController {

    private static final Logger log = LoggerFactory.getLogger(MainController.class);
    static long counter;
    @GetMapping("/cgi-bin/sendsms")
    public ResponseEntity getRequest(@RequestParam Map<String, String> allParams) throws Throwable {
        counter++;
        log.info("payload "+allParams + "count "+counter);

        return new  ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
