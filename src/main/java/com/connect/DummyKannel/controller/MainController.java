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

    private final RestTemplate restTemplate;

    public MainController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;

    }



    @GetMapping("/cgi-bin/sendsms")
    public ResponseEntity getRequest(@RequestParam Map<String, String> allParams) throws JsonProcessingException, UnsupportedEncodingException, URISyntaxException {
        System.out.println("=== Received Kannel-style SMS ===");
        allParams.forEach((key, value) -> System.out.println(key + " = " + value));
        String DlrUrl = allParams.get("dlr-url");
        String sdate = allParams.get("sdate");
        String dn = "id:1 sub:001 dlvrd:001 submitdate:" + sdate + "donedate:" + sdate + " stat:DELIVRD err:000 Text:dlr";
         String encodedn = URLEncoder.encode(dn , "UTF-8");
        String replacefinal = DlrUrl.replace("%a", encodedn);
        restcall(replacefinal);
        return  ResponseEntity.status(HttpStatus.OK).build();
    }
   public void restcall(String url)
   {
       try {
           String response = restTemplate.getForObject(url, String.class);
           log.info(response);
       } catch (HttpClientErrorException e) {
           if (e.getStatusCode() == HttpStatus.NOT_FOUND) {
               log.error( "Resource not found");
           }
       }
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
