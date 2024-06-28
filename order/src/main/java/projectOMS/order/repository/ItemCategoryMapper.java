package projectOMS.order.repository;



import org.apache.ibatis.annotations.Mapper;
import projectOMS.order.domain.ItemCategoryVO;
import projectOMS.order.domain.ItemListVO;

import java.util.List;

@Mapper
public interface ItemCategoryMapper {

    List<ItemCategoryVO> getItemCategory();

    List<ItemListVO> getItemListOne(String ctgr_cd);





}
