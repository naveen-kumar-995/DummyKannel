package com.connect.DummyKannel.controller;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.Map;

@RestController
public class MainController {

    private static final Logger log = LoggerFactory.getLogger(MainController.class);
    static long counter;


    @GetMapping("/cgi-bin/sendsms")
    public ResponseEntity getRequest(@RequestParam Map<String, String> allParams)  {
        counter++;
        log.info("payload "+allParams + "count "+counter);
        return  ResponseEntity.status(HttpStatus.OK).build() ;
    }

    @PostMapping("/cgi-bin/sendsms/")
    public ResponseEntity getRequest(@RequestBody String obj) throws Throwable {
        counter++;
        log.info("Recieved Payload" + obj);
        log.info("Counter : "+ counter);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
