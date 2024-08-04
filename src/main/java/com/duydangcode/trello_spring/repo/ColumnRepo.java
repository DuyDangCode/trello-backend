package com.duydangcode.trello_spring.repo;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.duydangcode.trello_spring.model.ColumnModel;
import java.util.List;

public interface ColumnRepo extends MongoRepository<ColumnModel, String> {
  @Query("{}")
  List<ColumnModel> getAllPublishedColumnsByBoardId(String boardId);

}