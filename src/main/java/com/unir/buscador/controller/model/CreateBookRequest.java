package com.unir.buscador.controller.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateBookRequest {

    private String title;
    private String category;
    private String author;
    private String isbn;
    private Float price;
    private Float rating;
    private Integer stock;
    private Date publication_date;
    private Boolean visible;
}