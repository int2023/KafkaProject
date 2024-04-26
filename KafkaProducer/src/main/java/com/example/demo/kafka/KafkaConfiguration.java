package com.example.demo.kafka;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaConfiguration {

    public NewTopic newTopic() {
        return new NewTopic("metrics-topic",1, (short) 1);
    }

}
