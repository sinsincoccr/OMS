package projectOMS.order.controller;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import projectOMS.order.domain.MemberVO;
import projectOMS.order.service.LoginService;
import projectOMS.order.service.MemberService;



@Slf4j
@Controller
@RequiredArgsConstructor
public class LoginController {
    private final MemberService memberService;
    private final LoginService loginService;

    @RequestMapping("/")
    public String home(@ModelAttribute MemberVO member, HttpSession session, HttpServletRequest request, Model model) {
        model.addAttribute("member", new MemberVO());
        // 세션 없으면 로그인로 이동
        if (session == null) {
            // 세션에 null 값을 넣기
            session.setAttribute("loginMember", null);
            log.info("session null");
            return "login/login";
        }
        return "member/memberLogin";
    }

    @GetMapping("/memberLogin")
    public String memberLogin(@ModelAttribute MemberVO member, Model model){
        model.addAttribute("member", new MemberVO());
        return "member/memberLogin";
    }

    @PostMapping("/memberLogin")
    public String memberLoginPro(@ModelAttribute MemberVO member, HttpSession session, Model model){
        log.info("member PostMapping : {}", member);

        // 로그인 로직 구현
        MemberVO loginMember = loginService.memberLogin(member);
        log.info("loginMember {}", loginMember);
        if(loginMember != null) {
            session.setAttribute("loginMember", loginMember);
            return "redirect:/categorySearch"; // 로그인 후 홈으로 이동
        } else {  // 알럿창 띄우기 추가
            model.addAttribute("loginFail", true);
            // 로그인 실패 시 알림 창 띄우기 위해 Flash Attributes 사용
            session.setAttribute("loginFailMessage", "");

            return "redirect:/"; // 로그인 실패 시 폼 html 보여주기
        }
    }



    // 로그아웃 요청
    @GetMapping("logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }
}
