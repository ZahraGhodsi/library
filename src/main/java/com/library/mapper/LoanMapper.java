package com.library.mapper;

import com.library.entity.Loan;
import com.library.model.LoanModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {BookMapper.class, MemberMapper.class})
public interface LoanMapper extends BaseMapper<Loan, LoanModel> {
}