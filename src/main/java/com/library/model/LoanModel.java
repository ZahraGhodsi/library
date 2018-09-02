package com.library.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class LoanModel implements Serializable {
    private Long id;
    private Long version;
    private BookModel book;
    private MemberModel member;
    private Date takeDate;
    private Date returnDate;
}
