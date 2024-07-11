package com.duydangcode.trello_spring.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "Invitations")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class InvitationModel {
  @Id
  private String _id;
  @DocumentReference(collection = "Users")
  private String inviterId;
  @DocumentReference(collection = "Users")
  private String inviteeId;
  private String type;
  @DocumentReference(collection = "Boards")
  private String boardId;
  private boolean _isDelete = false;
}
