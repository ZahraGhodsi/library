package com.library.mapper;

import com.library.entity.Book;
import com.library.model.BookModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = AuthorMapper.class)
public interface BookMapper extends BaseMapper<Book, BookModel> {
}