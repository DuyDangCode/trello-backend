package com.duydangcode.trello_spring.controller;

import org.springframework.web.bind.annotation.RestController;

import com.duydangcode.trello_spring.core.ResEntityDetail;
import com.duydangcode.trello_spring.model.BoardModel;
import com.duydangcode.trello_spring.repo.BoardRepo;
import com.duydangcode.trello_spring.service.BoardService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;

import javax.management.Query;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/boards")
public class BoardController {

  private BoardService boardService;

  @PostMapping()
  public ResponseEntity<ResEntityDetail<Object>> createBoard(@RequestBody @Valid BoardModel boardData) {
    return ResponseEntity.ok(
        ResEntityDetail
            .builder()
            .message("Create board successful")
            .metadata(boardService.createBoard(boardData))
            .build());
  }

  @GetMapping("{id}")
  public ResponseEntity<ResEntityDetail<Object>> getAllBoardByOwner(@PathVariable String id) {
    return ResponseEntity.ok(
        ResEntityDetail
            .builder()
            .message("Get board successful")
            .metadata(boardService.getBoardById(id))
            .build());
  }

  @PutMapping("{id}")
  public ResponseEntity<ResEntityDetail<Object>> putMethodName(@PathVariable String id,
      @RequestBody BoardModel entity) {
    return ResponseEntity.ok(
        ResEntityDetail
            .builder()
            .message("Update board successful")
            .metadata(boardService.updateBoard(entity))
            .build());
  }

  @DeleteMapping("{id}")
  public ResponseEntity<ResEntityDetail<Object>> deleteBoardById(@PathVariable String id) {
    return ResponseEntity.ok(
        ResEntityDetail
            .builder()
            .message("Delete board successful")
            .metadata(boardService.deleteBoard(id))
            .build());
  }

}
