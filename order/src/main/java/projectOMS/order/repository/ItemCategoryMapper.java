package projectOMS.order.repository;



import org.apache.ibatis.annotations.Mapper;
import projectOMS.order.domain.ItemCategoryVO;

import java.util.List;

@Mapper
public interface ItemCategoryMapper {

    List<ItemCategoryVO> getItemCategory();

    void updateView(String ctgr_cd);



}
