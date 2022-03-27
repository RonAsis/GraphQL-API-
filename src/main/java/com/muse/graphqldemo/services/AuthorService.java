package com.muse.graphqldemo.services;

import com.muse.graphqldemo.domain.model.Author;
import com.muse.graphqldemo.domain.repositories.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class AuthorService {

    private final AuthorRepository authorRepository;

    public List<Author> findAll(){
        return authorRepository.findAll();
    }

    public long count(){
        return authorRepository.count();
    }

    public Author save(Author author) {
        return authorRepository.save(author);
    }

    public Map<String, Author> findAllByIds(List<String> authorIds) {
        Iterable<Author> allById = authorRepository.findAllById(authorIds);

        return StreamSupport.stream(allById.spliterator(), false)
                .collect(Collectors.toMap(Author::getId, e -> e));
    }

    public Author create(String name, Integer age) {
        Author author = new Author();

        author.setName(name);
        author.setAge(age);

        return save(author);
    }
}
