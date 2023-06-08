package com.ssafy.chulcheck.member.model.mapper;

import com.ssafy.chulcheck.member.model.MemberDto;
import org.apache.ibatis.annotations.Mapper;

import java.sql.SQLException;

@Mapper
public interface MemberMapper {

    public int join(MemberDto memberDto) throws SQLException;
    public int idCheck(String userId) throws Exception;
}
