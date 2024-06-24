package projectOMS.order.service;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import projectOMS.order.domain.MemberVO;
import projectOMS.order.repository.MemberMapper;
import projectOMS.order.repository.MemberRepository;


@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class LoginServiceImpl implements LoginService{
    private final MemberRepository memberRepository;

    //로그인
    @Override
    public MemberVO memberLogin(MemberVO member) {
        MemberVO findMember = memberRepository.findById(member.getCpn_id());
        log.info("== member : {}", member);
        log.info("== findMember : {}", findMember);
        if(findMember != null){
            if(findMember.getCpn_pw().equals(member.getCpn_pw())){
                return findMember;
            }
        }
        return null; // getCpn_id 없거나 다르면 , 비번이 틀리면 null 리턴
    }




}
