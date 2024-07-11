package com.duydangcode.trello_spring.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.duydangcode.trello_spring.core.ErrorEntity;
import com.duydangcode.trello_spring.core.ResEntityDetail;
import com.duydangcode.trello_spring.dto.SignInForm;
import com.duydangcode.trello_spring.model.CardModel;
import com.duydangcode.trello_spring.model.ColumnModel;
import com.duydangcode.trello_spring.model.UserModel;
import com.duydangcode.trello_spring.repo.UserRepo;

import io.micrometer.core.instrument.cumulative.CumulativeCounter;
import lombok.AllArgsConstructor;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.apache.coyote.BadRequestException;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/access")
public class AccessController {
  private UserRepo userRepo;
  private PasswordEncoder passwordEncoder;

  @PostMapping("/sign-in")
  public ResponseEntity<ResEntityDetail<Object>> signIn(@RequestBody SignInForm signInForm) throws BadRequestException {
    Optional<UserModel> holderUser = userRepo.findOneByUsername(signInForm.getUsername());
    if (holderUser.isEmpty()) {
      throw new BadRequestException("User not found");
    }

    return ResponseEntity.ok(
        ResEntityDetail
            .builder()
            .message("Sign in successful")
            .metadata(signInForm)
            .build());
  }

  @PostMapping("/sign-up")
  public ResponseEntity<ResEntityDetail<Object>> signUp(@RequestBody SignInForm signUpForm) {

    return ResponseEntity
        .ok(ResEntityDetail
            .builder()
            .message("Sign up successful")
            .metadata(signUpForm)
            .build());
  }

}
