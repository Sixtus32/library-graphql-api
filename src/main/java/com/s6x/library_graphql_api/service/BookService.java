package com.s6x.library_graphql_api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.s6x.library_graphql_api.dto.request.CreateBookRequest;
import com.s6x.library_graphql_api.dto.request.UpdateBookRequest;
import com.s6x.library_graphql_api.exception.BookNotFoundException;
import com.s6x.library_graphql_api.persistence.model.Author;
import com.s6x.library_graphql_api.persistence.model.Book;
import com.s6x.library_graphql_api.persistence.model.Genre;
import com.s6x.library_graphql_api.repository.BookRepository;

@Service
@Transactional
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Autowired
    private AuthorService authorService;

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book getBookById(Long id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException("Book not found with id: " + id));
    }

    public List<Book> getBooksByGenre(Genre genre) {
        return bookRepository.findByGenre(genre);
    }

    public List<Book> getBooksByAuthor(Long authorId) {
        return bookRepository.findByAuthorId(authorId);
    }

    public List<Book> getAvailableBooks() {
        return bookRepository.findByAvailable(true);
    }

    public List<Book> searchBooksByTitle(String title) {
        return bookRepository.findByTitleContainingIgnoreCase(title);
    }

    public Book createBook(CreateBookRequest request) {
        if (bookRepository.existsByIsbn(request.getIsbn())) {
            throw new IllegalArgumentException("Book with ISBN " + request.getIsbn() + " already exists.");
        }

        Author author = authorService.getAuthorById(request.getAuthorId());

        Book book = new Book();
        book.setTitle(request.getTitle());
        book.setIsbn(request.getIsbn());
        book.setGenre(request.getGenre());
        book.setPublishedDate(request.getPublisheDate());
        book.setPages(request.getPages());
        book.setDescription(request.getDescription());
        book.setAvailable(request.getAvailable());
        book.setAuthor(author);

        return bookRepository.save(book);
    }

    public Book updateBook(UpdateBookRequest request) {
        Book book = getBookById(request.getId());
        if (request.getTitle() != null) {
            book.setTitle(request.getTitle());
        }
        if (request.getIsbn() != null) {
            if (!book.getIsbn().equals(request.getIsbn()) &&
                    bookRepository.existsByIsbn(request.getIsbn())) {
                throw new IllegalArgumentException("Book with ISBN " + request.getIsbn() + " already exists.");
            }
            book.setIsbn(request.getIsbn());
        }
        if (request.getGenre() != null) {
            book.setGenre(request.getGenre());
        }
        if (request.getPublishedDate() != null) {
            book.setPublishedDate(request.getPublishedDate());
        }
        if (request.getPages() != null) {
            book.setPages(request.getPages());
        }
        if (request.getDescription() != null) {
            book.setDescription(request.getDescription());
        }
        if (request.getAvailable() != null) {
            book.setAvailable(request.getAvailable());
        }
        if (request.getAuthorId() != null) {
            Author author = authorService.getAuthorById(request.getAuthorId());
            book.setAuthor(author);
        }

        return bookRepository.save(book);
    }

    public boolean deleteBook(Long id) {
        if (!bookRepository.existsById(id)) {
            throw new BookNotFoundException("Book not found with id: " + id);
        }
        bookRepository.deleteById(id);
        return true;
    }

    public Book toggleBookAvailability(Long id) {
        if (!bookRepository.existsById(id)) {
            throw new BookNotFoundException("Book not found with id: " + id);
        }
        Book book = getBookById(id);
        book.setAvailable(!book.getAvailable());
        return bookRepository.save(book);
    }
}
