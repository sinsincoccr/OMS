package projectOMS.order.service;



import projectOMS.order.domain.ItemCategoryVO;
import projectOMS.order.domain.ItemListVO;
import projectOMS.order.domain.MemberVO;

import java.util.List;

public interface ItemCategoryService {

    List<ItemCategoryVO> getItemCategory();

    List<ItemListVO> getItemListOne(String ctgr_cd);



}
