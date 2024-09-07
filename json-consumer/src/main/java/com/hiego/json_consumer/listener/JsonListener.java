package com.hiego.json_consumer.listener;

import com.hiego.json_consumer.custom.JsonConsumerCustomListener;
import com.hiego.json_consumer.model.Payment;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class JsonListener {

    @SneakyThrows
    @JsonConsumerCustomListener(groupId = "create-group")
    public void antiFraud(@Payload Payment payment){
        log.info("Pagamento recebido {}", payment.toString());
        Thread.sleep(2000);
        log.info("Validando fraude ...");
        Thread.sleep(2000);
        log.info("Compra aprovada!!");
        Thread.sleep(3000);
    }

    @SneakyThrows
    @JsonConsumerCustomListener(groupId = "pdf-group")
    public void pdfGenerator(){
        Thread.sleep(5000);
        log.info("Gerando pdf ...");
        Thread.sleep(2000);
    }

    @SneakyThrows
    @JsonConsumerCustomListener(groupId = "email-group")
    public void sendEmail(){
        Thread.sleep(10000);
        log.info("Enviando e-mail de confirmação ...");
        Thread.sleep(2000);
    }
}
