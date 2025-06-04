package com.s6x.library_graphql_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.s6x.library_graphql_api.persistence.model.Book;
import com.s6x.library_graphql_api.persistence.model.Genre;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findByGenre(Genre genre);

    List<Book>  findByAuthorId(Long authorId);

    List<Book> findByAvailable(Boolean available);

    @Query("SELECT b FROM Book b WHERE LOWER(b.title) LIKE LOWER(CONCAT('%', :title, '%'))")
    List<Book> findByTitleContainingIgnoreCase(String title);

    boolean existsByIsbn(String isbn);
    // Additional query methods can be defined here if needed
}
