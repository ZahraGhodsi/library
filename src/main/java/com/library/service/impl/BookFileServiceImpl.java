package com.library.service.impl;

import com.library.entity.BookFile;
import com.library.exceptions.customException;
import com.library.mapper.BookFileMapper;
import com.library.model.BookFileModel;
import com.library.repository.BookDao;
import com.library.repository.BookFileDao;
import com.library.service.BookFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;

@Transactional
@Service
public class BookFileServiceImpl implements BookFileService {

    @Autowired
    private BookFileDao dao;

    @Autowired
    private BookFileMapper mapper;

    public BookFileModel add(MultipartFile file) throws customException,Exception  {
        // Normalize file name
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        BookFileModel model = new BookFileModel();
        model.setName(fileName);
        model.setType(file.getContentType());
        model.setData(file.getBytes());

        BookFile entity = mapper.convertToEntity(model);
        return mapper.convertToModel(dao.create(entity));
    }


    @Override
    @Transactional
    public BookFileModel update(Long id,MultipartFile file) throws Exception ,customException {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        BookFileModel model = mapper.convertToModel(dao.find(id));
        model.setId(id);
        model.setName(fileName);
        model.setType(file.getContentType());
        model.setData(file.getBytes());

        BookFile entity = mapper.convertToEntity(model);

//        BookFile entity = mapper.convertToEntity(model);
        return mapper.convertToModel(dao.update(entity));
    }

    @Override
    @Transactional
    public Boolean delete(Long id) throws customException {
        BookFile entity = dao.find(id);
        if (entity != null) {
            dao.delete(entity.getId());
            return true;
        }
        return false;
    }
    @Override
    @Transactional(readOnly = true)
    public BookFileModel get(Long id) throws customException {
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
