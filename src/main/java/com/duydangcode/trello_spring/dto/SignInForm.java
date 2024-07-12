package com.duydangcode.trello_spring.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class SignInForm {
  @Size(min = 5, max = 20)
  private String username;
  @Size(min = 8, max = 20)
  private String password;
}
