package com.muse.graphqldemo.web.graphql.query;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.muse.graphqldemo.domain.model.Author;
import com.muse.graphqldemo.domain.model.Tutorial;
import com.muse.graphqldemo.services.AuthorService;
import com.muse.graphqldemo.services.TutorialService;
import com.muse.graphqldemo.web.dtos.TutorialDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class AuthorQuery implements GraphQLQueryResolver {

    private final AuthorService authorService;

    public List<Author> findAllAuthors() {
        return authorService.findAll();
    }

    public long countAuthors() {
        return authorService.count();
    }
}
