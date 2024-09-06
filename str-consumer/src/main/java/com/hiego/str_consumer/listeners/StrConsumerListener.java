package com.hiego.str_consumer.listeners;

import com.hiego.str_consumer.custom.StrConsumerCustomListener;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class StrConsumerListener {

    @StrConsumerCustomListener(groupId = "group-1")
    public void create(String message) {
        log.info("CREATE ::: Message received: {}", message);
        throw new IllegalArgumentException("Exception...");
    }

    @StrConsumerCustomListener(groupId = "group-1")
    public void log(String message) {
        log.info("LOG ::: Message received: {}", message);
    }

    @KafkaListener(groupId = "group-2", topics = "str-topic",containerFactory = "validMessageContainerFactory")
    public void history(String message) {
        log.info("HISTORY ::: Message received: {}", message);
    }
}
