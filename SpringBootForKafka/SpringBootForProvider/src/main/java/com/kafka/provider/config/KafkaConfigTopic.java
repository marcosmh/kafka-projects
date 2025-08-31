package com.kafka.provider.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.common.config.TopicConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaConfigTopic {

    @Bean
    public NewTopic generateTopic() {

        Map<String, String> configurations = new HashMap<>();
        configurations.put(TopicConfig.CLEANUP_POLICY_CONFIG,TopicConfig.CLEANUP_POLICY_DELETE); // delete: (Borra mensaje ) Compact: (Mantiene el mensaje)
        configurations.put(TopicConfig.RETENTION_MS_CONFIG,"86400000"); // Tiempo de retencion de mensajes - defecto - 1
        configurations.put(TopicConfig.SEGMENT_BYTES_CONFIG,"1073741824"); // Tamaño maximo del segmento - 1GB
        configurations.put(TopicConfig.MAX_MESSAGE_BYTES_CONFIG,"1000012"); // Tamaño maximo de cada mensaje -  por defecto 1MB

        return TopicBuilder.name("unProgramadorNace-Topic")
                .partitions(2)
                .replicas(2)
                .configs(configurations)
                .build();
    }
}
