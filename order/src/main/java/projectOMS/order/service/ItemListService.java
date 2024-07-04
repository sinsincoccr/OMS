package projectOMS.order.service;
import projectOMS.order.domain.ItemCategoryVO;
import projectOMS.order.domain.ItemListVO;
import projectOMS.order.domain.MemberVO;

import java.util.List;
import java.util.Map;


public interface ItemListService {

    void itemListAdd(ItemListVO itemList, MemberVO member);

    List<ItemListVO> getItemListOne(String ctgr_cd);

    ItemListVO getItemByProduct_cd(String product_cd);

    void itemListUpdate(Map<String, Object> Map);




}
