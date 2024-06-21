package com.duydangcode.trello_spring.model;

import org.bson.types.ObjectId;
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
  private ObjectId _id;
  @DocumentReference(collection = "Users")
  private ObjectId inviterId;
  @DocumentReference(collection = "Users")
  private ObjectId inviteeId;
  private String type;
  @DocumentReference(collection = "Boards")
  private ObjectId boardId;
  private boolean _isDelete;
}
