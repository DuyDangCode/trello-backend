package com.duydangcode.trello_spring.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.duydangcode.trello_spring.core.ErrorEntity;
import com.duydangcode.trello_spring.core.ResEntityDetail;
import com.duydangcode.trello_spring.dto.SignInForm;
import com.duydangcode.trello_spring.dto.SignUpForm;
import com.duydangcode.trello_spring.model.CardModel;
import com.duydangcode.trello_spring.model.ColumnModel;
import com.duydangcode.trello_spring.model.UserModel;
import com.duydangcode.trello_spring.repo.UserRepo;
import com.duydangcode.trello_spring.service.AccessService;

import io.micrometer.core.instrument.cumulative.CumulativeCounter;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

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
@RequiredArgsConstructor
@RequestMapping("/api/v1/access")
public class AccessController {

  private final AccessService accessService;

  @PostMapping("/sign-in")
  public ResponseEntity<ResEntityDetail<Object>> signIn(@RequestBody @Valid SignInForm signInForm)
      throws BadRequestException {
    return ResponseEntity.ok(
        ResEntityDetail
            .builder()
            .message("Sign in successful")
            .metadata(accessService.signIn(signInForm))
            .build());
  }

  @PostMapping("/sign-up")
  public ResponseEntity<ResEntityDetail<Object>> signUp(@RequestBody @Valid SignUpForm signUpForm) {
    return ResponseEntity
        .ok(ResEntityDetail
            .builder()
            .message("Sign up successful")
            .metadata(accessService.createUser(signUpForm))
            .build());
  }

}
