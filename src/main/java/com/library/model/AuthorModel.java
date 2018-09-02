package com.library.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * Created by Ahangari on 08/16/2017.
 */
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class AuthorModel implements Serializable {
    private Long id;
    private Long version;
    private String name;
    private String lastName;
//    private List<BookModel> books;

}
