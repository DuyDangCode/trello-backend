package com.duydangcode.trello_spring.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SignUpForm {
  @Size(min = 5, max = 20)
  @NotNull
  private String username;

  @Size(min = 8, max = 20)
  @NotNull
  private String password;

  @Email
  @NotNull
  private String email;

}
