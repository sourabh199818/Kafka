package com.deliveryBoy.deliveryBoy.controller;

import com.sun.javafx.collections.MappingChange;
import org.apache.logging.log4j.spi.LoggerRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deliveryBoy.deliveryBoy.service.kafkaService;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/location")
public class LocationController {

    @Autowired
    private kafkaService KafkaService;

    @PostMapping("/update")
    public ResponseEntity<?> updateLocation(){

        this.KafkaService.updateLocation("("+Math.round(Math.random()*100)+", "+Math.round(Math.random()*100)+")");
        Map<String, String> responseMap = new HashMap<>();
        responseMap.put("Message", "Location Updated");
      ResponseEntity<Map<String, String>> responseEntity = new ResponseEntity<>(responseMap, HttpStatus.OK);
         return responseEntity;
    }
}
