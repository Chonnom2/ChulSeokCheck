package com.ssafy.chulcheck.member.model.service;

import com.ssafy.chulcheck.member.model.MemberDto;
import com.ssafy.chulcheck.member.model.mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService{

    private MemberMapper memberMapper;

    @Autowired
    public MemberServiceImpl(MemberMapper memberMapper) {
        this.memberMapper = memberMapper;
    }

    @Override
    public int join(MemberDto memberDto) throws Exception {
        return memberMapper.join(memberDto);
    }

    @Override
    public int idCheck(String userId) throws Exception {
        return memberMapper.idCheck(userId);
    }
}
