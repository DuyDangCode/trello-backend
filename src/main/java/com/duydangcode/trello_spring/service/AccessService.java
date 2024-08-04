package com.duydangcode.trello_spring.service;

import java.util.Optional;

import org.apache.coyote.BadRequestException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.duydangcode.trello_spring.dto.SignInForm;
import com.duydangcode.trello_spring.dto.SignUpForm;
import com.duydangcode.trello_spring.model.UserModel;
import com.duydangcode.trello_spring.repo.UserRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AccessService {

  private final UserRepo userRepo;
  private final PasswordEncoder passwordEncoder;
  private final KeyTokenService keyTokenService;

  public UserModel signIn(SignInForm signInForm) throws BadRequestException {
    UserModel holderUser = userRepo.findOneByUsername(signInForm.getUsername())
        .orElseThrow(() -> new BadRequestException("User not found"));

    return holderUser;
  }

  public UserModel createUser(SignUpForm signUpForm) {
    signUpForm.setPassword(passwordEncoder.encode(signUpForm.getPassword()));

    var newUser = UserModel
        .builder()
        .username(signUpForm.getUsername())
        .password(signUpForm.getPassword())
        .email(signUpForm.getEmail())
        .build();

    newUser.setTokens(keyTokenService.generateTokens(newUser));

    return newUser;
  }
}
