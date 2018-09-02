package com.library.service.impl;

import com.library.entity.Author;
import com.library.exceptions.customException;
import com.library.mapper.AuthorMapper;
import com.library.model.AuthorModel;
import com.library.repository.AuthorDao;
import com.library.repository.BookDao;
import com.library.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private AuthorDao dao;

    @Autowired
    private BookDao bookDao;
    
    @Autowired
    private AuthorMapper mapper;

    @Override
    @Transactional
    public AuthorModel add(AuthorModel model) throws customException {
        Author entity = mapper.convertToEntity(model);

        return mapper.convertToModel(dao.create(entity));
    }

    @Override
    public List<AuthorModel> batchAdd(List<AuthorModel> models) throws customException {
        List<Author> entities = mapper.convertToEntities(models);

        return mapper.convertToModels(dao.batchCreate(entities));
    }

    @Override
    @Transactional
    public AuthorModel update(AuthorModel model) throws customException {
        Author entity = mapper.convertToEntity(model);
        return mapper.convertToModel(dao.update(entity));
    }

    @Override
    @Transactional
    public Boolean delete(Long id) throws customException {
        Author entity = dao.find(id);
        if (entity != null) {
            dao.delete(entity.getId());
            return true;
        }
        return false;
    }
    @Override
    @Transactional(readOnly = true)
    public AuthorModel get(Long id) throws customException {
        return mapper.convertToModel(dao.find(id));
    }
    @Override
    @Transactional
    public Boolean batchDelete(List<Long> ids) throws customException {
        try {
            dao.batchDelete(ids);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
