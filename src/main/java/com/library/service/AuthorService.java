package com.library.service;

import com.library.exceptions.customException;
import com.library.model.AuthorModel;
import java.util.List;

public interface AuthorService {
    AuthorModel add(AuthorModel model) throws customException;
    List<AuthorModel> batchAdd(List<AuthorModel> models) throws customException;
    AuthorModel update(AuthorModel model) throws customException;
    Boolean delete(Long id) throws customException;
    Boolean batchDelete(List<Long> idList) throws customException;

    AuthorModel get(Long id) throws customException;
}
