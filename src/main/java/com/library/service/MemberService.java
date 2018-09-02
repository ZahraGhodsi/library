package com.library.service;

import com.library.exceptions.customException;
import com.library.model.MemberModel;

import java.util.List;

public interface MemberService {
    MemberModel add(MemberModel model) throws customException;
    List<MemberModel> batchAdd(List<MemberModel> models) throws customException;
    MemberModel update(MemberModel model) throws customException;
    Boolean delete(Long id) throws customException;
    Boolean batchDelete(List<Long> idList) throws customException;
    MemberModel get(Long id) throws customException;
}
