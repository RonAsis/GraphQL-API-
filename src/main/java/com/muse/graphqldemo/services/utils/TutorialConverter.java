package com.muse.graphqldemo.services.utils;

import com.muse.graphqldemo.domain.model.Author;
import com.muse.graphqldemo.domain.model.Tutorial;
import com.muse.graphqldemo.web.dtos.TutorialFullDto;

public class TutorialConverter {

    public static TutorialFullDto convert(Tutorial tutorial, Author author){
        TutorialFullDto tutorialFullDto = new TutorialFullDto();

        tutorialFullDto.setId(tutorial.getId());
        tutorialFullDto.setTitle(tutorial.getTitle());
        tutorialFullDto.setDescription(tutorial.getDescription());
        tutorialFullDto.setAuthor(author);

        return tutorialFullDto;
    }
}
