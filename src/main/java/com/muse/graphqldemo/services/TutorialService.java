package com.muse.graphqldemo.services;

import com.muse.graphqldemo.domain.model.Author;
import com.muse.graphqldemo.domain.model.Tutorial;
import com.muse.graphqldemo.domain.repositories.TutorialRepository;
import com.muse.graphqldemo.services.utils.TutorialConverter;
import com.muse.graphqldemo.web.dtos.TutorialDto;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TutorialService {

    private final TutorialRepository tutorialRepository;

    private final AuthorService authorService;

    public List<TutorialDto> findAll(){
        List<Tutorial> all = tutorialRepository.findAll();
        return TutorialConverter.convert(all);
    }

    public long count(){
        return tutorialRepository.count();
    }

    public TutorialDto save(Tutorial tutorial) {
        return TutorialConverter.convert(tutorialRepository.save(tutorial));
    }

    public boolean delete(String id) {
        tutorialRepository.deleteById(id);
        return true;
    }

    public TutorialDto update(String id, String title, String description) throws RuntimeException {
        Optional<Tutorial> optTutorial = tutorialRepository.findById(id);

        if(optTutorial.isEmpty()){
            throw new RuntimeException("Not found Tutorial to update!");
        }

        Tutorial tutorial = optTutorial.get();

        if (title != null) {
            tutorial.setTitle(title);
        }

        if (description != null) {
            tutorial.setDescription(description);
        }

        tutorialRepository.save(tutorial);

        return TutorialConverter.convert(tutorial);
    }

    public List<TutorialDto> findAllFull() {
        List<Tutorial> all = tutorialRepository.findAll();
        List<String> authorIds = getAuthorIds(all);
        Map<String, Author> authorIdToAuthor = authorService.findAllByIds(authorIds);

        return all.stream()
                .map(tutorial -> TutorialConverter.convert(tutorial, authorIdToAuthor.get(tutorial.getAuthorId())))
                .collect(Collectors.toList());
    }

    @NotNull
    private List<String> getAuthorIds(List<Tutorial> tutorials) {
        return tutorials.stream().map(Tutorial::getAuthorId).collect(Collectors.toList());
    }

    public TutorialDto create(String title, String description, String authorId) {
        Tutorial tutorial = new Tutorial();

        tutorial.setAuthorId(authorId);
        tutorial.setTitle(title);
        tutorial.setDescription(description);

        return save(tutorial);
    }
}
