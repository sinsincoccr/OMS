package projectOMS.order.service;



import projectOMS.order.domain.ItemCategoryVO;
import projectOMS.order.domain.MemberVO;

import java.util.List;

public interface ItemCategoryService {

    List<ItemCategoryVO> getItemCategory();

    void updateView(String ctgr_cd);

}
