package projectOMS.order.repository;

import org.apache.ibatis.annotations.Mapper;
import projectOMS.order.domain.MemberVO;


import java.util.Map;

@Mapper
public interface MemberMapper {
    int memberSignIn(MemberVO member);

    public int idCheck(String id);

    MemberVO findById(String cpn_id);

    void memberUpdate(Map<String, Object> Map);





}
