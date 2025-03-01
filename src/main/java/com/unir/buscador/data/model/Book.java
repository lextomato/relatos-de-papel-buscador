package com.unir.buscador.data.model;

import java.time.LocalDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Document(indexName = "books", createIndex = true)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Book {

    @Id
    private String id;

    @Field(type = FieldType.Search_As_You_Type, name = "title", docValues = false, maxShingleSize = 3)
    private String title;

    @Field(type = FieldType.Search_As_You_Type, name = "author", docValues = false, maxShingleSize = 3)
    private String author;

    @Field(type = FieldType.Keyword, name = "category")
    private String category;

    @Field(type = FieldType.Keyword, name = "img_url")
    private String imgUrl;

    @Field(type = FieldType.Keyword, name = "isbn")
    private String isbn;

    @Field(type = FieldType.Float, name = "price")
    private Float price;

    @Field(type = FieldType.Date, name = "publication_date", pattern = "yyyy-MM-dd")
    private LocalDate publicationDate;

    @Field(type = FieldType.Float, name = "rating")
    private Float rating;

    @Field(type = FieldType.Integer, name = "stock")
    private Integer stock;

    @Field(type = FieldType.Boolean, name = "visible")
    private Boolean visible;

    // Método isVisible que devuelve un booleano primitivo
    public boolean isVisible() {
        return visible != null && visible;
    }
}
