package com.library.mapper;

import com.library.entity.BookFile;
import com.library.model.BookFileModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BookFileMapper extends BaseMapper<BookFile, BookFileModel> {
}