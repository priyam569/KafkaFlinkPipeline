package com.ezlearner.services.configurations;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import com.fasterxml.jackson.databind.ser.std.NumberSerializers.IntegerSerializer;

import TO.Person;
import TO.PersonSerializer;

@EnableKafka
@Configuration
public class KafkaConfig {
	
	@Value("${spring.kafka.bootstrap-servers}")
	private String bootstrapAddress;
	
	@Bean
	public ProducerFactory<String, Person> producerFactory(){
		Map<String, Object> configProps = new HashMap<String, Object>();
		configProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
		configProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,StringSerializer.class);
		configProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, PersonSerializer.class);
		return new DefaultKafkaProducerFactory<String, Person>(configProps);
		
	}
	
	@Bean
	public KafkaTemplate<String, Person> kafkaTemplate(){
		return new KafkaTemplate<String, Person>(producerFactory());
		
	}

}
