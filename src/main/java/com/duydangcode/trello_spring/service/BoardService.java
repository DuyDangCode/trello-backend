package com.duydangcode.trello_spring.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.duydangcode.trello_spring.model.BoardModel;
import com.duydangcode.trello_spring.repo.BoardRepo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Service
@AllArgsConstructor
public class BoardService {
  private BoardRepo boardRepo;

  public BoardModel createBoard(BoardModel newBoard) {
    return boardRepo.save(newBoard);
  }

  public List<BoardModel> getBoardById(String id) {
    return boardRepo.findByOwnerIdOrNemberId(id);
  }

  public Boolean deleteBoard(String boardId) {
    boardRepo.deleteByBoardId(boardId);
    return true;
  }

  public BoardModel updateBoard(BoardModel newBoard) {
    return boardRepo.save(newBoard);
  }
}
