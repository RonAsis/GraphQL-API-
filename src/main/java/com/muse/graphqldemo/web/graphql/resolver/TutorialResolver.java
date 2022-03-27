package com.muse.graphqldemo.web.graphql.resolver;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.muse.graphqldemo.domain.model.Author;
import com.muse.graphqldemo.services.AuthorService;
import com.muse.graphqldemo.web.dtos.TutorialDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TutorialResolver implements GraphQLResolver<TutorialDto> {

    private final AuthorService authorService;

    public Author getAuthor(TutorialDto tutorial) {
        return authorService.findById(tutorial.getAuthorId()).orElse(null);
    }
}
