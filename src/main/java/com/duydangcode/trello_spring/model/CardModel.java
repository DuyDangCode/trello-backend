package com.duydangcode.trello_spring.model;

import java.util.List;

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
  private String _id;
  @DocumentReference(collection = "Boards")
  private String boardId;
  @DocumentReference(collection = "Columns")
  private String columnId;
  private String title;
  private String cover;
  private String description;
  private List<String> memberIds;
  private List<CommentModel> comments;
  private List<AttchmentModel> attchments;
  private boolean _idDelete = false;

}
