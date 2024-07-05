package projectOMS.order.service;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import projectOMS.order.domain.MemberVO;
import projectOMS.order.repository.MemberMapper;
import projectOMS.order.repository.MemberRepository;

import java.util.Map;


@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class MemberServiceImpl implements MemberService{
    private final MemberRepository memberRepository;
    private final MemberMapper memberMapper;

    //회원가입
    @Override
    public MemberVO memberSignIn(MemberVO member) {
        log.info("**********Before memberSignIn - MemberVO: {}", member);
        return memberRepository.memberSignIn(member);
    }

    @Override
    public int idCheck(String id) {
        int cnt = memberMapper.idCheck(id);
        System.out.println("cnt: " + cnt);
        return cnt;
    }

    @Override
    public void memberUpdate(Map<String, Object> Map) {
        memberMapper.memberUpdate(Map);

    }




}
