package com.brunojose.workshopmongo.config;

import org.bson.types.ObjectId;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.mongodb.core.convert.MongoCustomConversions;

import java.util.Arrays;

@Configuration
public class MongoConfig {

    @Bean
    public MongoCustomConversions customConversions() {
        return new MongoCustomConversions(Arrays.asList(
            new Converter<ObjectId, String>() {
                @Override public String convert(ObjectId source) {
                    return source != null ? source.toHexString() : null;
                }
            },
            new Converter<String, ObjectId>() {
                @Override public ObjectId convert(String source) {
                    return source != null && !source.isEmpty() ? new ObjectId(source) : null;
                }
            }
        ));
    }
}