package com.s6x.library_graphql_api.resolver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import com.s6x.library_graphql_api.persistence.model.Author;
import com.s6x.library_graphql_api.persistence.model.Book;
import com.s6x.library_graphql_api.service.AuthorService;

@Controller
public class BookResolver {

    @Autowired
    private AuthorService authorService;

    @SchemaMapping
    public Author author(Book book) {
        if (book == null || book.getAuthor() == null) {
            return null;
        }
        return authorService.getAuthorById(book.getAuthor().getId());
    }
}
