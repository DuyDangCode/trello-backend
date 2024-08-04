package com.duydangcode.trello_spring.controller;

import org.springframework.web.bind.annotation.RestController;

import com.duydangcode.trello_spring.core.ResEntityDetail;
import com.duydangcode.trello_spring.service.BoardService;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/v1/columns")
@RequiredArgsConstructor
public class ColumnController {

  private final BoardService boardService;

  @GetMapping("/{boadId}")
  public ResponseEntity<Object> getAllColumnInBoard(@PathVariable String boardId) {
    return ResponseEntity.ok(
        ResEntityDetail
            .builder()
            .message("Get all column successful")
            .metadata(boardService.getBoardById(boardId)));
  }

  @PostMapping("path")
  public String postMethodName(@RequestBody String entity) {
    return entity;
  }

}
