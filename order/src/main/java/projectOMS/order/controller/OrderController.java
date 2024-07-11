package projectOMS.order.controller;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import projectOMS.order.domain.ItemCategoryVO;
import projectOMS.order.domain.MemberVO;
import projectOMS.order.domain.OrderFormVO;
import projectOMS.order.service.OrderService;

import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/")
public class OrderController {

    private final OrderService orderService;

    @GetMapping("/orderSearch")
    public String orderSearch(Model model, HttpSession session){
        MemberVO member = (MemberVO) session.getAttribute("loginMember");
        List<OrderFormVO> orderForm = orderService.getOrderSearch(String.valueOf(member.getCpn_cd()));
        log.info("****member {}", member);
        model.addAttribute("orderForm", orderForm);
        log.info("****orderForm {}", orderForm);
        return "order/orderSearch";
    }








}
