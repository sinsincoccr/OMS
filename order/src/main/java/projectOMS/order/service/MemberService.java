package projectOMS.order.service;



import projectOMS.order.domain.MemberVO;

import java.util.Map;

public interface MemberService{
    //회원 가입
    MemberVO memberSignIn(MemberVO member);

    public int idCheck(String id);

    void memberUpdate(Map<String, Object> Map);


}
