package com.duydangcode.trello_spring.controller;

import com.duydangcode.trello_spring.model.CardModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/v1/cards")
public class CardController {
    // get all card in board
    @GetMapping("/{boardId}")
    public ResponseEntity<List<CardModel>> getAllCards(@PathVariable(value = "boardId", required = true) String boardId) throws Error {
        return new ResponseEntity<List<CardModel>>(
                Arrays.asList(new CardModel()), HttpStatus.OK
        );
    }

    // create card
    @PostMapping("/{columnId}")
    public ResponseEntity<String> createCard(@PathVariable(value = "columnId", required = true) String columnId, @RequestBody(required = true) String cardBody) {
        return new ResponseEntity<>(null);
    }

    // update card
    @PatchMapping("/{cardId}")
    public ResponseEntity<String> updateCard(@PathVariable(value = "cardId", required = true) String cardId, @RequestBody(required = true) String cardBody) {
        return new ResponseEntity<>(null);
    }

    @DeleteMapping("/{cardId}")
    public ResponseEntity<String> deleteCard(@PathVariable String cardId) {
        return ResponseEntity.ok("ok");
    }

}
