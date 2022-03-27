package com.muse.graphqldemo.web.controllers;

import com.muse.graphqldemo.domain.model.Tutorial;
import com.muse.graphqldemo.services.TutorialService;
import com.muse.graphqldemo.web.dtos.ErrorDto;
import com.muse.graphqldemo.web.dtos.TutorialDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = "Tutorial")
@RestController
@RequiredArgsConstructor
@RequestMapping("/tutorial")
@Slf4j
public class TutorialController {

    private final TutorialService tutorialService;

    @ApiOperation(value = "Get all tutorials")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Get all tutorials succeed"),
            @ApiResponse(code = 400, message = "Get all tutorials failed", response = ErrorDto.class),
    })
    @GetMapping("/all")
    public List<TutorialDto> findAll(){
        return tutorialService.findAll();
    }

    @ApiOperation(value = "Get all tutorials full")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Get all tutorials full succeed"),
            @ApiResponse(code = 400, message = "Get all tutorials full failed", response = ErrorDto.class),
    })
    @GetMapping("/all-full")
    public List<TutorialDto> findAllFull(){
        return tutorialService.findAllFull();
    }

    @ApiOperation(value = "Count tutorials")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Count tutorials succeed"),
            @ApiResponse(code = 400, message = "Count tutorials failed", response = ErrorDto.class),
    })
    @GetMapping("/count")
    public long count(){
        return tutorialService.count();
    }

    @ApiOperation(value = "Create Tutorial")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Create Tutorial succeed"),
            @ApiResponse(code = 400, message = "Create Tutorial failed", response = ErrorDto.class),
    })
    @PostMapping
    public TutorialDto create(@RequestParam String title, @RequestParam String description, @RequestParam String authorId){
        return tutorialService.create(title, description, authorId);
    }

    @ApiOperation(value = "Delete Tutorial")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Delete Tutorial succeed"),
            @ApiResponse(code = 400, message = "Delete Tutorial failed", response = ErrorDto.class),
    })
    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable String id){
       return tutorialService.delete(id);
    }

    @ApiOperation(value = "Update Tutorial")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Update Tutorial succeed"),
            @ApiResponse(code = 400, message = "Update Tutorial failed", response = ErrorDto.class),
    })
    @PutMapping("/{id}")
    public TutorialDto update(@PathVariable String id, @RequestParam String title, @RequestParam String description) {
        return tutorialService.update(id, title, description);
    }
}
