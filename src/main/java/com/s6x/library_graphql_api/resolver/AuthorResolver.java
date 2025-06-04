package com.s6x.library_graphql_api.resolver;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import com.s6x.library_graphql_api.persistence.model.Author;
import com.s6x.library_graphql_api.persistence.model.Book;
import com.s6x.library_graphql_api.service.BookService;

@Controller
public class AuthorResolver {

    @Autowired
    private BookService bookService;

    @SchemaMapping
    public List<Book> books(Author author){
        if (author == null || author.getId() == null) {
            return List.of();
        }
        return bookService.getBooksByAuthor(author.getId());
    }

    @SchemaMapping
    public Integer bookCount(Author author) {
        if (author == null || author.getId() == null) {
            return 0;
        }
        return bookService.getBooksByAuthor(author.getId()).size();
    }
}
