package com.muse.graphqldemo.web.graphql.query;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.muse.graphqldemo.domain.model.Tutorial;
import com.muse.graphqldemo.services.TutorialService;
import com.muse.graphqldemo.web.dtos.TutorialDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class TutorialQuery implements GraphQLQueryResolver {

    private final TutorialService tutorialService;

    public List<TutorialDto> findAllTutorials() {
        return tutorialService.findAll();
    }

    public long countTutorials() {
        return tutorialService.count();
    }
}
