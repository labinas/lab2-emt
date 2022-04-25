package com.emt.lab2.services.impl;/*
    Created by Labina on 25-Apr-22
*/

import com.emt.lab2.model.Author;
import com.emt.lab2.model.Book;
import com.emt.lab2.model.Category;
import com.emt.lab2.repository.BookRepository;
import com.emt.lab2.services.BookService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    @Override
    public void createBook(Book book) {
        bookRepository.save(book);
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book getById(Long id) {
        return bookRepository.findById(id).get();
    }

    @Override
    public Book updateBook(Long id, Category category, Author author, int availableCopies) {
        Book book = this.getById(id);
        book.setCategory(category);
        book.setAuthor(author);
        book.setAvailableCopies(availableCopies);

        bookRepository.save(book);
        return book;
    }

    @Override
    public Book deleteBook(Long id) {
        Book book = this.getById(id);
        bookRepository.delete(book);

        return book;
    }
}
