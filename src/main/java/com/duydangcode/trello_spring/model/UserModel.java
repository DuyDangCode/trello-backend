package com.duydangcode.trello_spring.model;

import org.bson.types.ObjectId;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Builder.Default;

@Document(collection = "Users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserModel {
  @Id
  private String _id;
  private String email;
  private String password;
  private String username;
  private String displayName;
  private String avatar;
  private boolean _isActivate;
  private boolean _isDelete;

  public UserModel(String username, String password, String email) {
    this.username = username;
    this.password = password;
    this.email = email;
  }
}
