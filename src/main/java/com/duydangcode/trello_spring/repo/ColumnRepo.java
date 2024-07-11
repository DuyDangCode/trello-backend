package com.duydangcode.trello_spring.repo;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.duydangcode.trello_spring.model.ColumnModel;

public interface ColumnRepo extends MongoRepository<ColumnModel, String> {

}