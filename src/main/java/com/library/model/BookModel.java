package com.library.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class BookModel implements Serializable {

    private Long id;
    private Long version;
    private String name;
    private AuthorModel author;
    private Integer availableNumber;

}
