package com.duydangcode.trello_spring.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
@RequestMapping("/api/v1/cards")
public class CardController {
  @GetMapping("/{boardId}")
  public String getMethodName(@PathVariable String boardId) {
    return boardId;
  }

}
