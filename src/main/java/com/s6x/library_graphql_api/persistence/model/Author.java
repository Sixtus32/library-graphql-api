package com.s6x.library_graphql_api.persistence.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import jakarta.validation.constraints.Email;

@Entity
@Table(name = "authors")
@Getter
@Setter
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NotBlank(message = "Author name is required")
    @Size(min = 2, max = 100, message = "Author name must be between 2 and 100 characters")
    private String name;

    @Column(nullable = false, unique = true)
    @NotBlank(message = "Author email is required")
    @Email(message = "Author email must be valid")
    private String email;

    @Column(name = "birth_date")
    private LocalDateTime birthDate;

    @Size(max = 50, message = "Author nationality must be less than or equal to 50 characters")
    private String nationality;

    @Size(max = 1000, message = "Author biography must be less than or equal to 1000 characters")
    @Column(length = 1000)
    private String biography;

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Book> books = new ArrayList<>();

    public int getBookCount() {
        return books != null ? books.size() : 0;
    }
}
