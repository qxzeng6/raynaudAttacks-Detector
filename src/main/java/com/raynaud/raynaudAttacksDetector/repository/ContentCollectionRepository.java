package com.raynaud.raynaudAttacksDetector.repository;


import com.raynaud.raynaudAttacksDetector.model.Content;
import com.raynaud.raynaudAttacksDetector.model.Status;
import com.raynaud.raynaudAttacksDetector.model.Type;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Repository
public class ContentCollectionRepository {
    private final List<Content> contentList = new ArrayList<>();

    public ContentCollectionRepository() {

    }

    public List<Content> getContentCollection() {
        return contentList;
    }

    public Optional<Content> getContentById(Integer id) {
        return contentList.stream().filter(c -> c.id().equals(id)).findFirst();
    }

    @PostConstruct
    private void init() {
        contentList.add(new Content(1, "title1", "body1", Status.IDEA, Type.ARTICLE, LocalDateTime.now(), null, "url1"));

    }

    public void save(Content content) {
        contentList.add(content);
    }
}
