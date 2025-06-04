package com.s6x.library_graphql_api.dto.request;

import java.time.LocalDateTime;

import com.s6x.library_graphql_api.persistence.model.Genre;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateBookRequest {

    @NotNull(message = "ID is required")
    private Long id;

    @Size(min = 1, max = 200, message = "Title must be between 1 and 200 characters")
    private String title;

    private String isbn;

    private Genre genre;

    private LocalDateTime publishedDate;

    @Min(value = 1, message = "Pages must be at least 1")
    private Integer pages;

    @Size(max = 1000, message = "Description must not exceed 1000 characters")
    private String description;

    private Long authorId;

    private Boolean available;
}
