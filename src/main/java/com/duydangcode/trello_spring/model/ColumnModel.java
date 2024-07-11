package com.duydangcode.trello_spring.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "Columns")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ColumnModel {
  @Id
  private String _id;
  @DocumentReference(collection = "Boards")
  private String boardId;
  private String title;
  private List<String> cardOrderIds;
  @Builder.Default
  private boolean _isDelete = false;
}
