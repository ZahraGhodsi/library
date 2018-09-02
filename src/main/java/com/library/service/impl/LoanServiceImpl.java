package com.library.service.impl;

import com.library.entity.Book;
import com.library.entity.Loan;
import com.library.entity.Member;
import com.library.exceptions.customException;
import com.library.mapper.BookMapper;
import com.library.mapper.LoanMapper;
import com.library.model.LoanModel;
import com.library.repository.AuthorDao;
import com.library.repository.BookDao;
import com.library.repository.LoanDao;
import com.library.repository.MemberDao;
import com.library.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Ahangari on 08/16/2017.
 */
@Transactional
@Service
public class LoanServiceImpl implements LoanService {

    @Autowired
    private LoanDao dao;

    @Autowired
    private BookDao bookDao;

    @Autowired
    private MemberDao memberDao;

    @Autowired
    private AuthorDao authorDao;

    @Autowired
    LoanMapper mapper;

    @Override
    @Transactional
    public LoanModel add(LoanModel model) throws customException {
        Loan entity = mapper.convertToEntity(model);
        entity.setBook(bookDao.find(model.getBook().getId()));
        entity.setMember(memberDao.find(model.getMember().getId()));

        return mapper.convertToModel(dao.create(entity));
    }

    @Override
    public List<LoanModel> batchAdd(List<LoanModel> models) throws customException {
        Loan loan;
        Book book;
        Member member;
        List<Loan> entities =mapper.convertToEntities(models);
        for (int i=0; i<entities.size(); i++)
        {
            loan = entities.get(i);
            book = bookDao.find(models.get(i).getBook().getId());
            book.setAuthor(authorDao.find(models.get(i).getBook().getAuthor().getId()));
            loan.setBook(book);
            member = memberDao.find(models.get(i).getMember().getId());
            loan.setMember(member);
            entities.set(i,loan);
        }
        return mapper.convertToModels(dao.batchCreate(entities));
    }

    @Override
    @Transactional
    public LoanModel update(LoanModel model) throws customException {
        Loan entity = mapper.convertToEntity(model);
        entity.setBook(bookDao.find(model.getBook().getId()));
        entity.setMember(memberDao.find(model.getMember().getId()));
        return mapper.convertToModel(dao.update(entity));
    }

    @Override
    @Transactional
    public Boolean delete(Long id) throws customException {
        Loan entity = dao.find(id);
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
    public LoanModel get(Long id) throws customException {
        return mapper.convertToModel(dao.find(id));
    }


/*
    @Override
    public boolean checkBookLimitation(LoanModel model) throws customException {
        if(bookDao.find(model.getBook().getId()).getAvailableNumber()>0)
            return true;
        else
            return false;
    }*/
}
