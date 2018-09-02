package com.library.mapper;

import com.library.entity.Author;
import com.library.model.AuthorModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AuthorMapper extends BaseMapper<Author, AuthorModel> {
}