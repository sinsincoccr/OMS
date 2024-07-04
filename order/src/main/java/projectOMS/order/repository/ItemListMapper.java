package projectOMS.order.repository;



import org.apache.ibatis.annotations.Mapper;
import projectOMS.order.domain.ItemCategoryVO;
import projectOMS.order.domain.ItemListVO;
import projectOMS.order.domain.MemberVO;

import java.util.List;
import java.util.Map;

@Mapper
public interface ItemListMapper {

    void itemListAdd(ItemListVO itemList, MemberVO member);







}
