package projectOMS.order.controller;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import projectOMS.order.domain.ItemCategoryVO;
import projectOMS.order.domain.ItemListVO;
import projectOMS.order.domain.MemberVO;
import projectOMS.order.service.ItemCategoryService;


import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/")
public class ItemCategoryController {

    private final ItemCategoryService itemCategoryService;

    @GetMapping("/itemCategory")
    public String itemCategory(Model model, HttpSession session){
        List<ItemCategoryVO> itemCategory = itemCategoryService.getItemCategory();
        model.addAttribute("itemCategory", itemCategory);
        MemberVO member = (MemberVO) session.getAttribute("loginMember");
        log.info("****itemCategory {}", itemCategory);
        return "itemCategory/itemCategory";
    }

    @GetMapping("/categorySearch")
    public String categorySearch(Model model, HttpSession session) {
        List<ItemCategoryVO> categorySearch = itemCategoryService.getItemCategory();
        MemberVO member = (MemberVO) session.getAttribute("loginMember");
        model.addAttribute("categorySearch", categorySearch);
        log.info("****categorySearch {}", categorySearch);
        return "itemCategory/categorySearch";
    }

    @GetMapping("/getItemListOne")
    @ResponseBody
    public List<ItemListVO> getItemListOne(@RequestParam("ctgr_cd") String ctgrCd) {
        return itemCategoryService.getItemListOne(ctgrCd);
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
