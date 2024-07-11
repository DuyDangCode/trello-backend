package com.duydangcode.trello_spring.core;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Builder
@Data
public class ResEntityDetail<T> {
  private String message;
  private T metadata;
}
