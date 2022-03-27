package com.muse.graphqldemo.web.graphql.mutation;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.muse.graphqldemo.domain.model.Author;
import com.muse.graphqldemo.services.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AuthorMutation implements GraphQLMutationResolver {

    private final AuthorService authorService;

    public Author create(String name, Integer age){
        return authorService.create(name, age);
    }
}
