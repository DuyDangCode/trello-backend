package com.duydangcode.trello_spring.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.Update;

import com.duydangcode.trello_spring.model.BoardModel;
import java.util.List;

public interface BoardRepo extends MongoRepository<BoardModel, String> {
  @Query("{_isDelete: false , $or: [{'ownerIds': {$in: ['?0']}}, {'memberIds': {$in: ['?0']}}]}")
  List<BoardModel> findByOwnerIdOrNemberId(String id);

  @Query("{_id: '?0'}")
  @Update("{$set: {_isDelete: true}}")
  void deleteByBoardId(String id);
}
