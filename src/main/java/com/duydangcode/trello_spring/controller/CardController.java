package com.duydangcode.trello_spring.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.duydangcode.trello_spring.model.CardModel;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
@RequestMapping("/api/v1/cards")
public class CardController {
  // get all card in board
  @GetMapping("/{boardId}")
  public ResponseEntity<List<CardModel>> getAllCards(@PathVariable(value = "boardId", required = true) String boardId)
      throws Error {
    return new ResponseEntity<List<CardModel>>(Arrays.asList(new CardModel()), HttpStatus.OK);
  }

  // create card
  @PostMapping("/{boardId}")
  public ResponseEntity<String> createCard(@PathVariable(value = "boardId", required = true) String boardId,
      @RequestBody(required = true) String cardBody) {
    return new ResponseEntity<>(null);
  }

  // update card
  @PatchMapping("/{cardId}")
  public ResponseEntity<String> updateCard(@PathVariable(value = "cardId", required = true) String cardId,
      @RequestBody(required = true) String cardBody) {
    return new ResponseEntity<>(null);
  }

}
