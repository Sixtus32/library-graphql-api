package com.s6x.library_graphql_api.resolver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

import com.s6x.library_graphql_api.dto.request.CreateAuthorRequest;
import com.s6x.library_graphql_api.dto.request.CreateBookRequest;
import com.s6x.library_graphql_api.dto.request.UpdateAuthorRequest;
import com.s6x.library_graphql_api.dto.request.UpdateBookRequest;
import com.s6x.library_graphql_api.persistence.model.Author;
import com.s6x.library_graphql_api.persistence.model.Book;
import com.s6x.library_graphql_api.service.AuthorService;
import com.s6x.library_graphql_api.service.BookService;

@Controller
public class MutationResolver {

    @Autowired
    private AuthorService authorService;

    @Autowired
    private BookService bookService;

    // Author Mutations
    @MutationMapping
    public Author createAuthor(@Argument CreateAuthorRequest request) {
        return authorService.createAuthor(request);
    }

    @MutationMapping
    public Author updateAuthor(@Argument UpdateAuthorRequest request) {
        return authorService.updateAuthor(request);
    }
    @MutationMapping
    public Boolean deleteAuthor(@Argument Long id) {
        return authorService.deleteAuthor(id);
    }

    // Book Mutations
    @MutationMapping
    public Book createBook(@Argument CreateBookRequest request) {
        return bookService.createBook(request);
    }

    @MutationMapping
    public Book updateBook(@Argument UpdateBookRequest request) {
        return bookService.updateBook(request);
    }

    @MutationMapping
    public Boolean deleteBook(@Argument Long id) {
        return bookService.deleteBook(id);
    }
}
