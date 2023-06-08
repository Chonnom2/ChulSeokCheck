package com.ssafy.chulcheck.member.model.service;

import com.ssafy.chulcheck.member.model.MemberDto;

public interface MemberService {
    public int join(MemberDto memberDto) throws Exception;
    public int idCheck(String userId) throws Exception;

}
