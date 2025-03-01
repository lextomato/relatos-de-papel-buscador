package com.unir.buscador.service;

import com.unir.buscador.data.model.Book;
import org.springframework.stereotype.Service;

import com.unir.buscador.controller.model.BooksQueryResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.util.StringUtils;

import com.unir.buscador.data.DataAccessRepository;
import com.unir.buscador.controller.model.CreateBookRequest;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final DataAccessRepository repository;

    @Override
    public BooksQueryResponse getBooks(String title, String author, String category, Boolean aggregate) {
        //Ahora por defecto solo devolvera productos visibles
        return repository.findBooks(title, author, category, aggregate);
    }

    @Override
    public Book getBook(String bookId) {
        return repository.findById(bookId).orElse(null);
    }

    @Override
    public Boolean removeBook(String bookId) {

        Book book = repository.findById(bookId).orElse(null);
        if (book != null) {
            repository.delete(book);
            return Boolean.TRUE;
        } else {
            return Boolean.FALSE;
        }
    }

    @Override
    public Book createBook(CreateBookRequest request) {

        if (request != null && StringUtils.hasLength(request.getTitle().trim())
                && StringUtils.hasLength(request.getAuthor().trim())
                && StringUtils.hasLength(request.getCategory().trim()) && request.getVisible() != null) {

            Book book = Book.builder().title(request.getTitle()).author(request.getAuthor())
                    .category(request.getCategory()).visible(request.getVisible()).build();

            return repository.save(book);
        } else {
            return null;
        }
    }

}
