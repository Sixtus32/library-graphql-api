package com.s6x.library_graphql_api.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.s6x.library_graphql_api.persistence.model.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

    Optional<Author> findByEmail(String email);
    List<Author> findByNationalityIgnoreCase(String nationality);

    @Query("SELECT a FROM Author a WHERE LOWER(a.name) LIKE LOWER(CONCAT('%', :name, '%'))")
    List<Author> findByNameContainingIgnoreCase(@Param("name") String name);
    
    boolean existsByEmail(String email);
}
