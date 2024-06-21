package com.duydangcode.trello_spring.model;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Reference;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "Cards")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CardModel {
  @Id
  private ObjectId _id;
  @DocumentReference(collection = "Boards")
  private ObjectId boardId;
  @DocumentReference(collection = "Columns")
  private ObjectId columnId;
  private String title;
  private String cover;
  private String description;
  private List<ObjectId> memberIds;
  private List<Comment> comments;
  private List<Attchment> attchments;
  private boolean _idDelete;

  @Data
  @AllArgsConstructor
  @NoArgsConstructor
  private class Comment {
    private ObjectId userId;
    private String username;
    private String avater;
    private String userDescription;
    private String content;
  }

  @Data
  @AllArgsConstructor
  @NoArgsConstructor
  private class Attchment {
    private String filename;
    private String filetype;
  }
}
