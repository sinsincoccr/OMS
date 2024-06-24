package projectOMS.order.repository;

import org.apache.ibatis.annotations.Mapper;
import projectOMS.order.domain.MemberVO;


import java.util.List;
import java.util.Optional;

@Mapper
public interface MemberMapper {
    int memberSignIn(MemberVO member);

    public int idCheck(String id);

    MemberVO findById(String cpn_id);

    Optional<MemberVO> findByPw(String pw);

    List<MemberVO> findAll();





}
