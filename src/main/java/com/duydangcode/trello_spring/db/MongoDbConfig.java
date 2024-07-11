package com.duydangcode.trello_spring.db;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MongoDbConfig {
  @Value("${spring.data.mongodb.uri}")
  private String url;

  @Bean
  public com.mongodb.client.MongoClient mongoClient() {
    return com.mongodb.client.MongoClients.create(url);
  }
}
