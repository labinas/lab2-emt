package com.emt.lab2.web;/*
    Created by Labina on 25-Apr-22
*/

import com.emt.lab2.dto.BookDto;
import com.emt.lab2.model.Author;
import com.emt.lab2.model.Book;
import com.emt.lab2.model.Category;
import com.emt.lab2.services.AuthorService;
import com.emt.lab2.services.BookService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;

@AllArgsConstructor
@CrossOrigin
@RestController
@RequestMapping("/book")
public class BookController {

    private final AuthorService authorService;
    private final BookService bookService;

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBook(@PathVariable Long id){
        Book book = bookService.getById(id);

        return ResponseEntity.ok().body(book);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Book>> getBooks(){
        List<Book> books = bookService.getAllBooks();

        return ResponseEntity.ok().body(books);
    }

    @PostMapping
    public ResponseEntity<Book> createBook(BookDto book){
        Author author = authorService.findById(book.getAuthorId());
        Book newBook = new Book(book.getName(), book.getCategory(), author, book.getAvailableCopies());
        bookService.createBook(newBook);

        return ResponseEntity.ok().body(newBook);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable Long id, BookDto book){
        Author author = authorService.findById(book.getAuthorId());

        return ResponseEntity.ok().body(bookService.updateBook(id, book.getCategory(), author, book.getAvailableCopies()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Book> deleteBook(@PathVariable Long id){
        return ResponseEntity.ok().body(bookService.deleteBook(id));
    }

    @RequestMapping(value = "/categories", method = RequestMethod.GET)
    public ResponseEntity<List<Category>> getCategories(){
        List<Category> categories = new LinkedList<>();
        categories.add(Category.BIOGRAPHY);
        categories.add(Category.CLASSICS);
        categories.add(Category.DRAMA);
        categories.add(Category.HISTORY);
        categories.add(Category.FANTASY);
        categories.add(Category.THRILER);
        categories.add(Category.NOVEL);

        return ResponseEntity.ok().body(categories);
    }

}
