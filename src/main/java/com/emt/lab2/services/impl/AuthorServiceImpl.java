package com.emt.lab2.services.impl;/*
    Created by Labina on 25-Apr-22
*/

import com.emt.lab2.model.Author;
import com.emt.lab2.repository.AuthorRepository;
import com.emt.lab2.services.AuthorService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    @Override
    public void createAuthor(Author author) {
        authorRepository.save(author);
    }

    @Override
    public Author findById(Long id) {
        return authorRepository.findById(id).get();
    }
}