package com.library.service.impl;

import com.library.entity.Book;
import com.library.exceptions.customException;
import com.library.mapper.BookMapper;
import com.library.model.BookModel;
import com.library.repository.AuthorDao;
import com.library.repository.BookDao;
import com.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;

@Transactional
@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDao dao;

    @Autowired
    private AuthorDao authorDao;

    @Autowired
    BookMapper mapper;

    @Override
    @Transactional
    public BookModel add(BookModel model) throws customException {
        Book entity = mapper.convertToEntity(model);
        entity.setAuthor(authorDao.find(model.getAuthor().getId()));
        return mapper.convertToModel(dao.create(entity));
    }

    @Override
    public List<BookModel> batchAdd(List<BookModel> models) throws customException {
        List<Book> entities = mapper.convertToEntities(models);
        Book book;
        for (int i=0;i<entities.size();i++) {
            book = entities.get(i);
            book.setAuthor(authorDao.find(models.get(i).getAuthor().getId()));
            entities.set(i,book);
        }
        return mapper.convertToModels(dao.batchCreate(entities));
    }

    @Override
    @Transactional
    public BookModel update(BookModel model) throws customException {
        Book entity = mapper.convertToEntity(model);
        entity.setAuthor(authorDao.find(model.getAuthor().getId()));
        return mapper.convertToModel(dao.update(entity));
    }

    @Override
    @Transactional
    public Boolean delete(Long id) throws customException {
        Book entity = dao.find(id);
        if (entity != null) {
            dao.delete(entity.getId());
            return true;
        }
        return false;
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

    @Override
    @Transactional(readOnly = true)
    public BookModel get(Long id) throws customException {
        return mapper.convertToModel(dao.find(id));
    }

}
