package com.github.kleinsamuel.springbootplayground;

import org.springframework.boot.autoconfigure.cassandra.CassandraProperties;
import org.springframework.boot.autoconfigure.cassandra.CqlSessionBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CassandraConfig {

	private final CassandraProperties properties;

	public CassandraConfig(CassandraProperties properties) {
		this.properties = properties;
	}
	@Bean
	public CqlSessionBuilderCustomizer sessionBuilderCustomizer() {
		return builder -> builder.withLocalDatacenter(this.properties.getLocalDatacenter());
	}

}

