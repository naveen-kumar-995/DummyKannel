package com.connect.DummyKannel.controller;



import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {



    @GetMapping("/cgi-bin/sendsms")
    public ResponseEntity<String>  getRequest()
    {
        return   ResponseEntity.status(HttpStatus.OK).body("Dummy Route of web");
    }
}
