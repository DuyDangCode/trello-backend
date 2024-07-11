package com.duydangcode.trello_spring.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "Tokens")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TokeModel {
  @Id
  @DocumentReference(collection = "Users")
  private String _id;
  private String role;
  private String accessToken;
  private String refreshToke;
}
