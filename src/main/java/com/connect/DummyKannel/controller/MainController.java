package com.connect.DummyKannel.controller;



import com.fasterxml.jackson.core.JsonProcessingException;
import org.apache.http.client.utils.URIBuilder;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;


import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.*;

@RestController
public class MainController {

    private static final Logger log = LoggerFactory.getLogger(MainController.class);
    static long counter;


    @GetMapping("/cgi-bin/sendsms")
    public ResponseEntity getRequest(@RequestParam Map<String, String> allParams) {

        log.debug(allParams.toString());
        return  ResponseEntity.status(HttpStatus.OK).build();
    }




    @GetMapping("/recieve")
    public ResponseEntity getRequestInternal(@RequestParam Map<String, String> allParams)
    {

        System.out.println(allParams);
        return ResponseEntity.ok("Accepted");
    }


    @PostMapping("/cgi-bin/sendsms/")
    public ResponseEntity getRequest(@RequestBody String obj) throws Throwable {
        counter++;
        log.info("Recieved Payload" + obj);
        log.info("Counter : "+ counter);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
