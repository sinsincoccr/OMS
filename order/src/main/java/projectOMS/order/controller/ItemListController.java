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
import projectOMS.order.service.ItemListService;

import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/")
public class ItemListController {

    private final ItemCategoryService itemCategoryService;

    private final ItemListService itemListService;



    @GetMapping("/itemSearch")
    public String itemSearch(Model model, HttpSession session) {
        MemberVO member = (MemberVO) session.getAttribute("loginMember");
        List<ItemCategoryVO> categorySearch = itemCategoryService.getItemCategory(String.valueOf(member.getCpn_nm()));
        model.addAttribute("categorySearch", categorySearch);
        log.info("****categorySearch {}", categorySearch);
        return "item/itemSearch";
    }

    @GetMapping("/getItemListOne")
    @ResponseBody
    public List<ItemListVO> getItemListOne(@RequestParam("ctgr_cd") String ctgrCd) {
        return itemCategoryService.getItemListOne(ctgrCd);
    }

    @GetMapping("/itemAdd")
    public String itemAdd(Model model, HttpSession session){
        MemberVO member = (MemberVO) session.getAttribute("loginMember");
        model.addAttribute("itemList", new ItemListVO());
        return "item/itemAdd";
    }

    @PostMapping("/itemAdd")
    public String itemAddPro(@ModelAttribute ItemListVO itemList, HttpSession session) {
        MemberVO member = (MemberVO) session.getAttribute("loginMember");
        itemListService.itemListAdd(itemList, member);
        return "item/itemSearch";
    }














}
