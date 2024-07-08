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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        return itemListService.getItemListOne(ctgrCd);
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

    @GetMapping("/itemListUpdate")
    public String itemListUpdate(@RequestParam("product_cd") String product_cd, Model model, HttpSession session){
        MemberVO member = (MemberVO) session.getAttribute("loginMember");
        ItemListVO itemList = itemListService.getItemByProduct_cd(product_cd);
        model.addAttribute("itemList", itemList);
        return "item/itemListUpdate";
    }

    @PostMapping("/itemListUpdate")
    public String itemListUpdatePro(@ModelAttribute ItemListVO itemList, HttpSession session, Model model) {
        MemberVO member = (MemberVO) session.getAttribute("loginMember");
        Map<String, Object> Map = new HashMap<>();
        Map.put("itemList", itemList);
        Map.put("cpn_id", member.getCpn_id());

        itemListService.itemListUpdate(Map);
        return "redirect:/itemSearch";
    }

    @DeleteMapping("/itemDelete/{product_cd}")
    public ResponseEntity<Void> itemDelete(@PathVariable("product_cd") String product_cd) {
       itemListService.deleteItem(product_cd);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/itemInventory")
    public String itemInventory(Model model, HttpSession session) {
        MemberVO member = (MemberVO) session.getAttribute("loginMember");
        List<ItemCategoryVO> categorySearch = itemCategoryService.getItemCategory(String.valueOf(member.getCpn_nm()));
        model.addAttribute("categorySearch", categorySearch);
        log.info("****categorySearch {}", categorySearch);
        return "item/itemInventory";
    }
















}
