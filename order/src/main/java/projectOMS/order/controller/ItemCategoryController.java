package projectOMS.order.controller;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import projectOMS.order.domain.ItemCategoryVO;
import projectOMS.order.domain.MemberVO;
import projectOMS.order.service.ItemCategoryService;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        return "itemCategory/itemCategoryAdd";
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

    @GetMapping("/categoryUpdate")
    public String categoryUpdate(@RequestParam("ctgrCd") String ctgrCd, Model model, HttpSession session){
        MemberVO member = (MemberVO) session.getAttribute("loginMember");
        ItemCategoryVO itemCategory = itemCategoryService.getItemCategoryByctgrCd(ctgrCd);
        model.addAttribute("itemCategory", itemCategory);
        log.info("*######*itemCategory {}", itemCategory);
        return "itemCategory/modifyCategory";
    }

    @PostMapping("/categoryUpdate")
    public String categoryUpdatePro(@ModelAttribute ItemCategoryVO itemCategory, HttpSession session, Model model) {
        MemberVO member = (MemberVO) session.getAttribute("loginMember");
        Map<String, Object> Map = new HashMap<>();
        Map.put("itemCategory", itemCategory);
        Map.put("cpn_id", member.getCpn_id());

        itemCategoryService.itemCategoryUpdate(Map);
        return "redirect:/categorySearch";
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
