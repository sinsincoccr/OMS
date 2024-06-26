package projectOMS.order.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import projectOMS.order.domain.ItemCategoryVO;
import projectOMS.order.service.ItemCategoryService;


import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/")
public class ItemCategoryController {

    private final ItemCategoryService itemCategoryService;

    @GetMapping("/itemCategory")
    public String itemCategory(Model model){
        List<ItemCategoryVO> itemCategory = itemCategoryService.getItemCategory();
        model.addAttribute("itemCategory", itemCategory);
        log.info("****itemCategory {}", itemCategory);

        return "itemCategory/itemCategory";
    }




    /*
    @GetMapping("/itemCategoryInfo")
    public String itemCategory(String ctgr_cd, Model model, HttpSession session) {
        log.info("ctgr_cd : {}", ctgr_cd);
        ItemCategoryVO itemCategoryVO = itemCategoryService.getItemCategory(ctgr_cd);
        itemCategoryService.updateView(ctgr_cd);
        model.addAttribute("itemCategory", itemCategoryVO);

        if (session.getAttribute("loginMember") != null) {
            MemberVO loginMember = (MemberVO) session.getAttribute("loginMember");
            log.info("*********loginMember : {}", loginMember);
            String sessionNo = String.valueOf(loginMember.getCpn_cd());
            model.addAttribute("sessionNo", sessionNo); // result를 모델에 추가
        }

        return "itemCategory/itemCategoryInfo";
    }

    */









}
