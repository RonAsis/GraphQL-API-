package com.muse.graphqldemo.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "authors")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Author {

    @Id
    private String id;
    private String name;
    private Integer age;
}
