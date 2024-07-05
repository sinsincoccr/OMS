package projectOMS.order.controller;

import jakarta.servlet.http.HttpSession;
import jakarta.websocket.Session;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import projectOMS.order.domain.ItemCategoryVO;
import projectOMS.order.domain.MemberVO;
import projectOMS.order.service.MemberService;

import java.util.HashMap;
import java.util.Map;

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
        memberService.memberSignIn(member);
        return "redirect:/"; // 회원 상세 페이지로 이동
    }

    // 아이디 중복체크
    @PostMapping("/idCheck")
    @ResponseBody
    public int idCheck(@RequestParam("id") String id) {
        int cnt = memberService.idCheck(id);
        return cnt;
    }

    @GetMapping("/mypage")
    public String mypageIn(Model model, HttpSession session){
        MemberVO member = (MemberVO) session.getAttribute("loginMember");
        model.addAttribute("member", member);
        return "member/mypage";
    }

    @GetMapping("/mypageUpdate")
    public String mypageUpdate(Model model, HttpSession session){
        MemberVO member = (MemberVO) session.getAttribute("loginMember");
        model.addAttribute("member", member);
        return "member/mypageUpdate";
    }



    @PostMapping("/mypageUpdate")
    public String mypageUpdatePro(@ModelAttribute("memberUpdate") MemberVO memberUpdate, HttpSession session) {
        MemberVO loginMember = (MemberVO) session.getAttribute("loginMember");
        log.info("*######*member {}", loginMember);

        Map<String, Object> map = new HashMap<>();
        map.put("member", memberUpdate);
        map.put("cpn_id", loginMember.getCpn_id());

        memberService.memberUpdate(map);
        return "redirect:/mypage";
    }











}
