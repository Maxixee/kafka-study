package com.hiego.str_producer.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class StringProducerService {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String message) {
        kafkaTemplate.send("str-topic", message)
                .whenComplete((result, ex) -> { // aqui eu mando um callback do envio para saber se foi enviado ou não
                    if (ex != null) {
                        log.error("error sending message: {}", ex.getMessage());
                    }else{
                        log.info("message sent successfully: {}", result.getProducerRecord().value());
                        log.info("Patition: {}, Offset: {}",
                                result.getRecordMetadata().partition(),
                                result.getRecordMetadata().offset());
                    }
                });
    }
}
