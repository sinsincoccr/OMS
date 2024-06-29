package projectOMS.order.controller;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import projectOMS.order.domain.ItemCategoryVO;
import projectOMS.order.domain.ItemListVO;
import projectOMS.order.domain.MemberVO;
import projectOMS.order.service.ItemCategoryService;

import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/")
public class ItemListController {

    private final ItemCategoryService itemCategoryService;



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
