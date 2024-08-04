package com.duydangcode.trello_spring.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Builder.Default;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Arrays;
import java.util.List;

@Document(collection = "Boards")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BoardModel {
    @Id
    private String _id;
    @Size(max = 500)
    @Builder.Default
    private String description = "";
    @Size(max = 200, min = 2)
    @NotBlank
    private String title;
    @Builder.Default
    private String background = "https://res.cloudinary.com/dqcsednbr/image/upload/v1721875065/hkwvellxilpx5h7jeaaw.jpg";
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
