package com.s6x.library_graphql_api.dto.response;

import java.time.LocalDateTime;

import com.s6x.library_graphql_api.persistence.model.Genre;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookResponse {
    private Long id;
    private String title;
    private String isbn;
    private Genre genre;
    private LocalDateTime publishedDate;
    private Integer pages;
    private String description;
    private Long authorId;
    private Boolean available;

    public BookResponse mapToResponse(com.s6x.library_graphql_api.persistence.model.Book book) {
        return BookResponse.builder()
                .id(book.getId())
                .title(book.getTitle())
                .isbn(book.getIsbn())
                .genre(book.getGenre())
                .publishedDate(book.getPublishedDate())
                .pages(book.getPages())
                .description(book.getDescription())
                .authorId(book.getAuthor().getId())
                .available(book.getAvailable())
                .build();
    }
}
