package com.duydangcode.trello_spring.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AttchmentModel {
  private String filename;
  private String filetype;

}
