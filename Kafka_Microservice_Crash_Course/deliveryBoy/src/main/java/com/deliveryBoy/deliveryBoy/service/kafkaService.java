package com.deliveryBoy.deliveryBoy.service;

import com.deliveryBoy.deliveryBoy.config.AppConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class kafkaService {
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    private Logger logger =  LoggerFactory.getLogger(kafkaService.class);


    public boolean updateLocation(String location)
    {
        for (int i=0;i<=100000; i++) {
            this.kafkaTemplate.send(AppConstant.LOCATION_TOPIC_NAME, location);
            this.logger.info("message produce");
            System.out.println("..........................**.................");
        }
        return true;

    }
}
