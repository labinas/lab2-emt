package com.emt.lab2.services;/*
    Created by Labina on 25-Apr-22
*/

import com.emt.lab2.model.Author;
import com.emt.lab2.model.Book;
import com.emt.lab2.model.Category;

import java.util.List;

public interface BookService {
    void createBook(Book book);

    List<Book> getAllBooks();

    Book getById(Long id);

    Book updateBook(Long id, Category category, Author author, int availableCopies);

    Book deleteBook(Long id);
}