package com.emt.lab2.services;/*
    Created by Labina on 25-Apr-22
*/

import com.emt.lab2.model.Author;

public interface AuthorService {
    void createAuthor(Author author);

    Author findById(Long id);
}

