package com.muse.graphqldemo.services.utils;

import com.muse.graphqldemo.domain.model.Author;
import com.muse.graphqldemo.domain.model.Tutorial;
import com.muse.graphqldemo.web.dtos.TutorialDto;
import org.springframework.util.CollectionUtils;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class TutorialConverter {

    public static TutorialDto convert(Tutorial tutorial, Author author){
        TutorialDto tutorialDto = new TutorialDto();

        tutorialDto.setId(tutorial.getId());
        tutorialDto.setTitle(tutorial.getTitle());
        tutorialDto.setDescription(tutorial.getDescription());
        tutorialDto.setAuthorId(tutorial.getAuthorId());
        tutorialDto.setAuthor(author);

        return tutorialDto;
    }

    public static TutorialDto convert(Tutorial tutorial){
        return convert(tutorial, null);
    }

    public static List<TutorialDto> convert(List<Tutorial> tutorials){
        if(CollectionUtils.isEmpty(tutorials)){
            return new LinkedList<>();
        }

        return tutorials.stream()
                .map(TutorialConverter::convert)
                .collect(Collectors.toList());
    }
}
