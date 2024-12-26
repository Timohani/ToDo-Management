package org.timowa.dto;

public record TaskDto(Long id,
                      String description,
                      Boolean completed) {
}
