package com.duydangcode.trello_spring.model;

import java.util.Arrays;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Builder.Default;

@Document(collection = "Boards")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BoardModel {
  @Id
  private String _id;
  @Size(max = 500)
  private String description;
  @Size(max = 200, min = 2)
  private String title;
  private String type;
  @NotNull
  @Builder.Default
  private List<String> ownerIds = Arrays.asList();
  @Builder.Default
  private List<String> memberIds = Arrays.asList();
  @Builder.Default
  private List<String> columnOrderIds = Arrays.asList();
  @Builder.Default
  private boolean _isDelete = false;
}
