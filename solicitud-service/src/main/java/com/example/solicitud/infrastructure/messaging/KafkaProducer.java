package com.example.solicitud.infrastructure.messaging;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaProducer {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void enviarEvento(String topico, String mensaje) {
        kafkaTemplate.send(topico, mensaje);
    }
}
