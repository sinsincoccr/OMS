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

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/")
public class MemberController {

    private final MemberService memberService;
    private static final String SALT = "rainpassword";

    @GetMapping("/memberSignIn")
    public String memberSignIn(Model model){
        model.addAttribute("member", new MemberVO());
        return "member/memberSignIn";
    }

    @PostMapping("/memberSignIn")
    public String memberSignInPro(MemberVO member) {
        String hashedPassword = hashPassword(member.getCpn_pw() + SALT);
        member.setCpn_pw(hashedPassword);
        memberService.memberSignIn(member);
        return "redirect:/"; // 회원 상세 페이지로 이동
    }
    private String hashPassword(String password) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] encodedHash = digest.digest(password.getBytes(StandardCharsets.UTF_8));
            StringBuilder hexString = new StringBuilder();
            for (byte b : encodedHash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
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
