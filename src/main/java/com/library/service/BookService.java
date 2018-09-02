package com.library.service;

import com.library.exceptions.customException;
import com.library.model.BookModel;

import java.util.List;

public interface BookService {
    BookModel add(BookModel model) throws customException;
    List<BookModel> batchAdd(List<BookModel> models) throws customException;
    BookModel update(BookModel model) throws customException;
    Boolean delete(Long id) throws customException;
    Boolean batchDelete(List<Long> idList) throws customException;
    BookModel get(Long id) throws customException;
}
