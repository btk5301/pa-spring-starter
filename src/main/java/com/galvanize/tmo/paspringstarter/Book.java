package com.galvanize.tmo.paspringstarter;


import lombok.*;

@ToString
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Book {

    private long id;
    private String author;
    private String title;
    private int yearPublished;
}
