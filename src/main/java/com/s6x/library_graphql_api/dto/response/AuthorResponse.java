package com.s6x.library_graphql_api.dto.response;

import java.time.LocalDateTime;

import com.s6x.library_graphql_api.persistence.model.Author;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class AuthorResponse {
    private Long id;
    private String name;
    private String email;
    private LocalDateTime birthDate;
    private String nationality;
    private String biography;

    public AuthorResponse mapToResponse(Author author) {
        return AuthorResponse.builder()
                .id(author.getId())
                .name(author.getName())
                .email(author.getEmail())
                .birthDate(author.getBirthDate())
                .nationality(author.getNationality())
                .biography(author.getBiography())
                .build();
    }
}
