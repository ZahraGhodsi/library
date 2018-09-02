package com.library.service.impl;

import com.library.entity.Member;
import com.library.exceptions.customException;
import com.library.mapper.MemberMapper;
import com.library.model.MemberModel;
import com.library.repository.MemberDao;
import com.library.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Ahangari on 08/16/2017.
 */
@Transactional
@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberDao dao;
        
    @Autowired
    MemberMapper mapper;

    @Override
    @Transactional
    public MemberModel add(MemberModel model) throws customException {
        Member entity = mapper.convertToEntity(model);

        return mapper.convertToModel(dao.create(entity));
    }

    @Override
    public List<MemberModel> batchAdd(List<MemberModel> models) throws customException {
        List<Member> entities = mapper.convertToEntities(models);

        return mapper.convertToModels(dao.batchCreate(entities));
    }

    @Override
    @Transactional
    public MemberModel update(MemberModel model) throws customException {
        return mapper.convertToModel(dao.update(mapper.convertToEntity(model)));
    }

    @Override
    @Transactional
    public Boolean delete(Long id) throws customException {
        Member entity = dao.find(id);
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
    public MemberModel get(Long id) throws customException {
        return mapper.convertToModel(dao.find(id));
    }


}
