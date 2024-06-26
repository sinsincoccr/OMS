package projectOMS.order.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import projectOMS.order.domain.MemberVO;
import projectOMS.order.service.MemberService;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/")
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/memberSignIn")
    public String memberSignIn(Model model){
        model.addAttribute("member", new MemberVO());
        return "member/memberSignIn";
    }

    @PostMapping("/memberSignIn")
    public String memberSignInPro(MemberVO member) {
        MemberVO savedMember = memberService.memberSignIn(member);
        return "redirect:/"; // 회원 상세 페이지로 이동
    }

    // 아이디 중복체크
    @PostMapping("/idCheck")
    @ResponseBody
    public int idCheck(@RequestParam("id") String id) {
        int cnt = memberService.idCheck(id);
        return cnt;
    }








}
