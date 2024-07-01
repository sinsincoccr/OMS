package projectOMS.order.controller;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
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

    @GetMapping("/categorySearch")
    public String categorySearch(Model model, HttpSession session){
        MemberVO member = (MemberVO) session.getAttribute("loginMember");
        List<ItemCategoryVO> itemCategory = itemCategoryService.getItemCategory(String.valueOf(member.getCpn_nm()));
        log.info("****member {}", member);
        model.addAttribute("itemCategory", itemCategory);
        log.info("****itemCategory {}", itemCategory);
        return "itemCategory/categorySearch";
    }

    @GetMapping("/categoryAdd")
    public String categoryAdd(Model model, HttpSession session){
        MemberVO member = (MemberVO) session.getAttribute("loginMember");
        model.addAttribute("itemCategoryList", new ItemCategoryVO());
        return "item/itemCategoryAdd";
    }

    @PostMapping("/categoryAdd")
    public String categoryAddPro(@ModelAttribute ItemCategoryVO itemCategory, HttpSession session) {
        MemberVO member = (MemberVO) session.getAttribute("loginMember");
        itemCategoryService.itemCategoryAdd(itemCategory, member);
        return "itemCategory/categorySearch";
    }

    @DeleteMapping("/categoryDelete/{ctgrCd}")
    public ResponseEntity<Void> categoryDelete(@PathVariable("ctgrCd") String ctgr_cd) {
        itemCategoryService.deleteItemCategory(ctgr_cd);
        return ResponseEntity.ok().build();
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
