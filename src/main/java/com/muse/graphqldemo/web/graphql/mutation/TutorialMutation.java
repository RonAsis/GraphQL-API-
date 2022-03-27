package com.muse.graphqldemo.web.graphql.mutation;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.muse.graphqldemo.services.TutorialService;
import com.muse.graphqldemo.web.dtos.TutorialDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TutorialMutation implements GraphQLMutationResolver {

    private final TutorialService tutorialService;

    public TutorialDto createTutorial(String title, String description, String authorId){
        return tutorialService.create(title, description, authorId);
    }

    public boolean deleteTutorial(String id){
        return tutorialService.delete(id);
    }

    public TutorialDto updateTutorial(String id, String title, String description) throws RuntimeException{
        return tutorialService.update(id, title, description);
    }
}
