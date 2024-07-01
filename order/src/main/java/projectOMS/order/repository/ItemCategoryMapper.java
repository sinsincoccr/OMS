package projectOMS.order.repository;



import org.apache.ibatis.annotations.Mapper;
import projectOMS.order.domain.ItemCategoryVO;
import projectOMS.order.domain.ItemListVO;
import projectOMS.order.domain.MemberVO;

import java.util.List;

@Mapper
public interface ItemCategoryMapper {

    List<ItemCategoryVO> getItemCategory(String cpn_nm);

    List<ItemListVO> getItemListOne(String ctgr_cd);

    void itemCategoryAdd(ItemCategoryVO itemCategory, MemberVO member);





}
