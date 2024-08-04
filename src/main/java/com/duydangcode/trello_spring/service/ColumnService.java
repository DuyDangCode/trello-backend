package com.duydangcode.trello_spring.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.duydangcode.trello_spring.model.ColumnModel;
import com.duydangcode.trello_spring.repo.ColumnRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ColumnService {
  private final ColumnRepo columnRepo;

  public List<ColumnModel> getAllColumnInBoard(String boardId) {
    return columnRepo.getAllPublishedColumnsByBoardId(boardId);
  }
}
