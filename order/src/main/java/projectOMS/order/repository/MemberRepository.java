package projectOMS.order.repository;


import projectOMS.order.domain.MemberVO;

public interface MemberRepository {
    // 회원 가입
    MemberVO memberSignIn(MemberVO member);


}

