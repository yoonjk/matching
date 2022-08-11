package com.matching.kb40.backend.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.listener.ContainerProperties;

import com.matching.kb40.backend.util.KafkaConsumerProperties;

@Configuration
@EnableKafka
public class KafkaConsumerConfig {
    @Value("${kafka.bootstap-servers}")
    private String bootstrapServers;

    @Value("${kafka.username}")
    private String kafkaUser;

    @Value("${kafka.password}")
    private String kafkaPassword;

    @Value("${kafka.offset.reset}")
    private String kafkaOffsetResetMode;

    @Value("${kafka.ackmode}")
    private ContainerProperties.AckMode kafkaAckmode;

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, String> kafkaListenerContainerFactory(){
        ConcurrentKafkaListenerContainerFactory<String, String> kafkaFactory = new ConcurrentKafkaListenerContainerFactory<>();

        kafkaFactory.setConsumerFactory(consumerFactory());
        kafkaFactory.getContainerProperties().setAckMode(kafkaAckmode);
        kafkaFactory.setConcurrency(3);
        kafkaFactory.getContainerProperties().setMessageListener(myAcknowledgingMessageListener());
        kafkaFactory.getContainerProperties().setPollTimeout(5000);

        return kafkaFactory;
    }

    public AcknowledgingMessageListener myAcknowledgingMessageListener() {
        return MyAcknowledgingMessageListener();
    }

    public ConsumerFactory<String, String> consumerFactory() {
        return new DefaultKafkaConsumerFactory<>(KafkaConsumerProperties.getProperties(bootstrapServers, kafkaUser, kafkaPassword));
    }
}


