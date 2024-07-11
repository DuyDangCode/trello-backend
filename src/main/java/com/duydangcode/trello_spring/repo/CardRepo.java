package com.duydangcode.trello_spring.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.duydangcode.trello_spring.model.CardModel;

public interface CardRepo extends MongoRepository<CardModel, String> {

}
