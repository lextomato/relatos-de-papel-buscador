package com.unir.buscador.service;

import com.unir.buscador.data.model.Book;
import com.unir.buscador.controller.model.CreateBookRequest;
import com.unir.buscador.controller.model.BooksQueryResponse;

public interface BookService {

    BooksQueryResponse getBooks(String name, String description, String country, Boolean aggregate);

    Book getBook(String productId);

    Boolean removeBook(String productId);

    Book createBook(CreateBookRequest request);

}