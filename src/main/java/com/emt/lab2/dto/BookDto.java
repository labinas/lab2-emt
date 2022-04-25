package com.emt.lab2.dto;/*
    Created by Labina on 25-Apr-22
*/

import com.emt.lab2.model.Category;
import lombok.Data;

@Data
public class BookDto {

    String name;
    Category category;
    Long authorId;
    int availableCopies;
}
