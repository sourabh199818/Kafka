package com.enduser.enduser;

import com.sun.deploy.association.utility.AppConstants;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;

@Configuration
public class KafkaConfig {

    @KafkaListener(topics = AppConstant.Location_Update_Topic, groupId= AppConstant.GROUP_ID)
    public void updatedLocation(String value)
    {

        System.out.print(value);
    }

}
