package com.duydangcode.trello_spring.model;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "Columns")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ColumnModel {
  @Id
  private ObjectId _id;
  @DocumentReference(collection = "Boards")
  private ObjectId boardId;
  private String title;
  private List<ObjectId> cardOrderIds;
  private boolean _isDelete;
}
