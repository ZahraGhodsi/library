package com.library.mapper;

import com.library.entity.Member;
import com.library.model.MemberModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MemberMapper extends BaseMapper<Member, MemberModel> {
}