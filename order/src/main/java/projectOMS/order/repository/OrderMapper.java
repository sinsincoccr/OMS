package projectOMS.order.repository;



import org.apache.ibatis.annotations.Mapper;
import projectOMS.order.domain.ItemCategoryVO;
import projectOMS.order.domain.OrderFormVO;

import java.util.List;

@Mapper
public interface OrderMapper {

    List<OrderFormVO> getOrderSearch(String cpn_cd);



}
