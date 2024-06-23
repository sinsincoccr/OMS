package projectOMS.order.service;



import projectOMS.order.domain.MemberVO;

public interface MemberService{
    //회원 가입
    MemberVO memberSignIn(MemberVO member);

    public int idCheck(String id);


}
