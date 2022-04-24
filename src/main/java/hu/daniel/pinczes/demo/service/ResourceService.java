package hu.daniel.pinczes.demo.service;

import hu.daniel.pinczes.demo.entity.Resource;
import hu.daniel.pinczes.demo.entity.ResourceType;
import hu.daniel.pinczes.demo.repository.ResourceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ResourceService {


    public static final String DELIMITER = " | ";
    public static final String LINE_BREAK = "<br/>";

    @Value("${show.author}")
    private Boolean showAuthor;

    private final ResourceRepository repository;

    public String getBooksReadableForm() {
        return repository.findAllByType(ResourceType.BOOK)
                .stream()
                .map(this::createReadable)
                .collect(Collectors.joining(LINE_BREAK));
    }

    public String getURLsReadableForm() {
        return repository.findAllByType(ResourceType.URL)
                .stream()
                .map(this::createReadable)
                .collect(Collectors.joining(LINE_BREAK));
    }

    private String createReadable(Resource resource) {
        String secondPart = "Title: " + resource.getTitle() + DELIMITER
                + "Type: " + resource.getType() + DELIMITER
                + "Date: " + resource.getDate() + DELIMITER
                + "URI: " + resource.getUri();
        String firstPart = "Author: " + resource.getAuthor() + DELIMITER;
        return showAuthor
                ? firstPart + secondPart
                : secondPart;
    }
}
