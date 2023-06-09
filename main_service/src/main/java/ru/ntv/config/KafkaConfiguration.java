package ru.ntv.config;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.ntv.dto.kafka.ArticleKafkaDTO;
import java.util.Properties;

@Configuration
public class KafkaConfiguration {

    @Bean
    public Producer<String, ArticleKafkaDTO> configureKafkaProducer() {
        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092");
        props.put("acks", "all");
        props.put("retries", 1);
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "ru.ntv.serializer.ArticleKafkaDTOSerializer");
        return new KafkaProducer<>(props);
    }

//    @Bean
//    public ProducerFactory<String, ArticleKafkaDTO> producerFactory() {
//        Map<String, Object> configProps = new HashMap<>();
//        configProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
//        configProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
//        configProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, ArticleKafkaDTOSerializer.class);
//        return new DefaultKafkaProducerFactory<>(configProps);
//    }
//
//
//    @Bean
//    public KafkaTemplate<String, ArticleKafkaDTO> kafkaTemplate() {
//        return new KafkaTemplate<>(producerFactory());
//    }
//
//    @Bean
//    public ArticleKafkaDTOSerializer articleKafkaDTOSerializer() {
//        return new ArticleKafkaDTOSerializer();
//    }
}