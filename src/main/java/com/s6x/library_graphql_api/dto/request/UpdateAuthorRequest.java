package com.s6x.library_graphql_api.dto.request;

import java.time.LocalDateTime;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class UpdateAuthorRequest {

    @NotNull(message = "ID is required")
    private Long id;

    @Size(min = 2, max = 100, message = "Name must be between 2 and 100 characters")
    private String name;

    @Email(message = "Email should be valid")
    private String email;

    private LocalDateTime birthDate;

    @Size(max = 50, message = "Nationality must not exceed 50 characters")
    private String nationality;

    @Size(max = 1000, message = "Biography must not exceed 1000 characters")
    private String biography;
}
