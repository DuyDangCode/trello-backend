package com.duydangcode.trello_spring.model;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "Boards")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BoardModel {
  @Id
  private ObjectId _id;
  private String description;
  private String title;
  private String type;
  private List<ObjectId> ownerIds;
  private List<ObjectId> memberIds;
  private List<ObjectId> columnOrderIds;
  private boolean _isDelete;
}
