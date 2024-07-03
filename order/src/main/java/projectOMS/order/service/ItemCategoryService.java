package projectOMS.order.service;



import projectOMS.order.domain.ItemCategoryVO;
import projectOMS.order.domain.ItemListVO;
import projectOMS.order.domain.MemberVO;

import java.util.List;
import java.util.Map;

public interface ItemCategoryService {

    List<ItemCategoryVO> getItemCategory(String cpn_nm);

    ItemCategoryVO getItemCategoryByctgrCd(String ctgr_cd);

    List<ItemListVO> getItemListOne(String ctgr_cd);

    void itemCategoryAdd(ItemCategoryVO itemCategory, MemberVO member);

    void itemCategoryUpdate(Map<String, Object> Map);

    void deleteItemCategory(String ctgr_cd);





}
