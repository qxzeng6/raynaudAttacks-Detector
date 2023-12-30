package com.raynaud.raynaudAttacksDetector.model;
import java.time.LocalDateTime;

public record Content(
        Integer id,
        String title,
        String body,
        Status status,
        Type contentType,
        LocalDateTime createdAt,
        LocalDateTime updatedAt,
        String url
) {

}
