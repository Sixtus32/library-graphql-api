package com.s6x.library_graphql_api.dto.request;

import java.time.LocalDateTime;

import com.s6x.library_graphql_api.persistence.model.Genre;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateBookRequest {

    @NotBlank(message = "Title is required")
    @Size(min = 1, max = 200, message = "Title must be between 1 and 200 characters")
    private String title;

    @NotBlank(message = "ISBN is required")
    private String isbn;

    @NotBlank(message = "Genre is required")
    private Genre genre;

    @NotBlank(message = "Publication date is required")
    private LocalDateTime publisheDate;

    @Min(value = 1, message = "Pages must be at least 1")
    @NotNull(message = "Pages is required")
    private Integer pages;

    @Size(max = 1000, message = "Description must not exceed 1000 characters")
    private String description;

    @NotNull(message = "Author ID is required")
    private Long authorId;

    private Boolean available = true;
}
