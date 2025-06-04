package com.s6x.library_graphql_api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.s6x.library_graphql_api.dto.request.CreateAuthorRequest;
import com.s6x.library_graphql_api.dto.request.UpdateAuthorRequest;
import com.s6x.library_graphql_api.exception.AuthorNotFoundException;
import com.s6x.library_graphql_api.persistence.model.Author;
import com.s6x.library_graphql_api.repository.AuthorRepository;

@Service
@Transactional
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    public Author getAuthorById(Long id) {
        return authorRepository.findById(id)
                .orElseThrow(() -> new AuthorNotFoundException("Author not found with id: " + id));
    }

    public List<Author> getAuthorsByNationality(String nationality) {
        return authorRepository.findByNationalityIgnoreCase(nationality);
    }

    public List<Author> searchAuthorsByName(String name) {
        return authorRepository.findByNameContainingIgnoreCase(name);
    }

    public Author createAuthor(CreateAuthorRequest request) {
        if (authorRepository.existsByEmail(request.getEmail())) {
            throw new IllegalArgumentException("Author with email " + request.getEmail() + " already exists.");
        }
        Author author = new Author();
        author.setName(request.getName());
        author.setEmail(request.getEmail());
        author.setBirthDate(request.getBirthDate());
        author.setNationality(request.getNationality());
        author.setBiography(request.getBiography());
        return authorRepository.save(author);
    }

    public Author updateAuthor(UpdateAuthorRequest request) {
        Author author = authorRepository.findById(request.getId())
                .orElseThrow(() -> new AuthorNotFoundException("Author not found with id: " + request.getId()));
        if(request.getName() != null) {
            author.setName(request.getName());
        }
        if(request.getEmail() != null) {
            if (authorRepository.existsByEmail(request.getEmail())) {
                throw new IllegalArgumentException("Author with email " + request.getEmail() + " already exists.");
            }
            author.setEmail(request.getEmail());
        }
        if(request.getBirthDate() != null) {
            author.setBirthDate(request.getBirthDate());
        }
        if(request.getNationality() != null) {
            author.setNationality(request.getNationality());
        }
        if(request.getBiography() != null) {
            author.setBiography(request.getBiography());
        }
        return authorRepository.save(author);
    }

    public boolean deleteAuthor(Long id) {
        if (!authorRepository.existsById(id)) {
            throw new AuthorNotFoundException("Author not found with id: " + id);
        }
        authorRepository.deleteById(id);
        return true;
    }
}
