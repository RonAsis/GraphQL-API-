package com.muse.graphqldemo.web.controllers;

import com.muse.graphqldemo.domain.model.Author;
import com.muse.graphqldemo.domain.model.Tutorial;
import com.muse.graphqldemo.services.AuthorService;
import com.muse.graphqldemo.web.dtos.ErrorDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = "Author")
@RestController
@RequiredArgsConstructor
@RequestMapping("/author")
@Slf4j
public class AuthorController {

    private final AuthorService authorService;

    @ApiOperation(value = "Get all authors")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Get all authors succeed"),
            @ApiResponse(code = 400, message = "Get all authors failed", response = ErrorDto.class),
    })
    @GetMapping("/all")
    public List<Author> findAll(){
        return authorService.findAll();
    }

    @ApiOperation(value = "Count authors")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Count authors succeed"),
            @ApiResponse(code = 400, message = "Count authors failed", response = ErrorDto.class),
    })
    @GetMapping("/count")
    public long count(){
        return authorService.count();
    }

    @ApiOperation(value = "Create author")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Create author succeed"),
            @ApiResponse(code = 400, message = "Create author failed", response = ErrorDto.class),
    })
    @PostMapping()
    public Author create(@RequestParam String name, @RequestParam Integer age){
        return authorService.create(name, age);
    }
}
