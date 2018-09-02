package com.library.service;

import com.library.exceptions.customException;
import com.library.model.LoanModel;

import java.util.List;

public interface LoanService {
    LoanModel add(LoanModel model) throws customException;
    List<LoanModel> batchAdd(List<LoanModel> models) throws customException;
    LoanModel update(LoanModel model) throws customException;
    Boolean delete(Long id) throws customException;
    Boolean batchDelete(List<Long> idList) throws customException;

    LoanModel get(Long id) throws customException;
//    boolean checkBookLimitation(LoanModel model) throws customException;

}