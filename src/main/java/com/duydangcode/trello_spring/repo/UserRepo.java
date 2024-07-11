package com.duydangcode.trello_spring.repo;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.duydangcode.trello_spring.model.UserModel;
import java.util.List;
import java.util.Optional;

public interface UserRepo extends MongoRepository<UserModel, String> {
  Optional<UserModel> findOneByUsername(String username);

  Optional<UserModel> findOneByEmail(String email);

  Optional<UserModel> findOneByUsernameOrEmail(String username, String email);
}
