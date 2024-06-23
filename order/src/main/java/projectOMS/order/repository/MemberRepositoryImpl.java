package projectOMS.order.repository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import projectOMS.order.domain.MemberVO;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
@Slf4j
public class MemberRepositoryImpl implements MemberRepository{

    private final MemberMapper memberMapper;
    private static long sequence = 0L;


    public MemberVO memberSignIn(MemberVO member) {
        memberMapper.memberSignIn(member);
        return member;
    }


    public Optional<MemberVO> findById(String user_id) {
        return null;
    }


    public Optional<MemberVO> findByPw(String user_pw) {
        return null;
    }


    public List<MemberVO> findAll() {
        return null;
    }
}
