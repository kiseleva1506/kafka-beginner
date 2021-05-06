package com.github.marus15.kafka.tutorial1;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

public class ProducerDemo {
    public static void main(String[] args) {
        String bootstrapServer = "127.0.0.1:9092";

//        create Producer properties
        Properties properties = new Properties();
        properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServer);
        properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());

//        create the Producer
        KafkaProducer<String, String> producer = new KafkaProducer<>(properties);

//        create a producer record
        ProducerRecord<String, String> record =
                new ProducerRecord<>("first_topic", "hello world");

//        send data - asynchronous
        producer.send(record);

//        flush data
        producer.flush();
//        flush data and close producer
        producer.close();

    }
}
