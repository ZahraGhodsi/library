package com.library.service;
import com.library.exceptions.customException;
import com.library.model.BookFileModel;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface BookFileService {
    BookFileModel add(MultipartFile file) throws Exception,customException;
    BookFileModel update(Long id, MultipartFile file) throws Exception,customException;
    Boolean delete(Long id) throws customException;
    Boolean batchDelete(List<Long> idList) throws customException;
    BookFileModel get(Long id) throws customException;
}
