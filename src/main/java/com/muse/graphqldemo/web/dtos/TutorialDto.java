package com.muse.graphqldemo.web.dtos;

import com.muse.graphqldemo.domain.model.Author;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TutorialDto {

    private String id;
    private String title;
    private String description;
    private Author author;
    private String authorId;
}
