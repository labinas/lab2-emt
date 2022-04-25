package com.emt.lab2.bootstrap;/*
    Created by Labina on 25-Apr-22
*/

import com.emt.lab2.model.Author;
import com.emt.lab2.model.Book;
import com.emt.lab2.model.Category;
import com.emt.lab2.model.Country;
import com.emt.lab2.services.AuthorService;
import com.emt.lab2.services.BookService;
import com.emt.lab2.services.CountryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@AllArgsConstructor
public class DataInitializer {

    private final AuthorService authorService;
    private final BookService bookService;
    private final CountryService countryService;

    @PostConstruct
    public void initData(){
        Country USA = new Country("USA", "America");
        Country Macedonia = new Country("Macedonia", "Europe");
        Country UK = new Country("UK", "Europe");

        countryService.createCountry(USA); //1
        countryService.createCountry(UK); //2
        countryService.createCountry(Macedonia); //3

        authorService.createAuthor(new Author("Charles", "Dickens", countryService.findById(2L))); //1
        authorService.createAuthor(new Author("F. Scott", "Fitzgerald", countryService.findById(1L))); //2
        authorService.createAuthor(new Author("Petre", "M. Andreevski", countryService.findById(3L))); //3

        bookService.createBook(new Book("The Great Gatsby", Category.DRAMA, authorService.findById(2L), 5));
        bookService.createBook(new Book("Tender is the Night", Category.DRAMA, authorService.findById(2L), 10));
        bookService.createBook(new Book("Oliver Twist", Category.FANTASY, authorService.findById(1L), 23));
        bookService.createBook(new Book("Great Expectations", Category.NOVEL, authorService.findById(1L), 3));
        bookService.createBook(new Book("The Pickwick Papers", Category.NOVEL, authorService.findById(1L), 4));
        bookService.createBook(new Book("Pirej", Category.HISTORY, authorService.findById(3L), 6));
        bookService.createBook(new Book("Skakulci", Category.NOVEL, authorService.findById(3L), 5));


    }
}
