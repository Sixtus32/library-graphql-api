package com.s6x.library_graphql_api.resolver;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.s6x.library_graphql_api.persistence.model.Author;
import com.s6x.library_graphql_api.persistence.model.Book;
import com.s6x.library_graphql_api.persistence.model.Genre;
import com.s6x.library_graphql_api.service.AuthorService;
import com.s6x.library_graphql_api.service.BookService;

@Controller
public class QueryResolver {

    @Autowired
    private AuthorService authorService;

    @Autowired
    private BookService bookService;

    // Author Queries
    @QueryMapping
    public List<Author> getAllAuthors() {
        return authorService.getAllAuthors();
    }

    @QueryMapping
    public Author getAuthorById(@Argument Long id) {
        return authorService.getAuthorById(id);
    }

    @QueryMapping
    public List<Author> getAuthorsByNationality(@Argument String nationality) {
        return authorService.getAuthorsByNationality(nationality);
    }

    @QueryMapping
    public List<Author> searchAuthorsByName(@Argument String name) {
        return authorService.searchAuthorsByName(name);
    }

    // Book Queries
    @QueryMapping
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @QueryMapping
    public Book getBookById(@Argument Long id) {
        return bookService.getBookById(id);
    }

    @QueryMapping
    public List<Book> getBooksByGenre(@Argument Genre genre) {
        return bookService.getBooksByGenre(genre);
    }

    @QueryMapping
    public List<Book> getBooksByAuthor(@Argument Long authorId) {
        return bookService.getBooksByAuthor(authorId);
    }

    @QueryMapping
    public List<Book> getAvailableBooks() {
        return bookService.getAvailableBooks();
    }

    @QueryMapping
    public List<Book> searchBooksByTitle(@Argument String title) {
        return bookService.searchBooksByTitle(title);
    }
}
