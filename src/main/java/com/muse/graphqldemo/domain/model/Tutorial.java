package com.muse.graphqldemo.domain.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "tutorials")
@Data
@NoArgsConstructor
@ToString
public class Tutorial {

    @Id
    private String id;
    private String title;
    private String description;
    private String author_id;
}
