package projectOMS.order.service;


import projectOMS.order.domain.ItemCategoryVO;
import projectOMS.order.domain.OrderFormVO;

import java.util.List;

public interface OrderService {

    List<OrderFormVO> getOrderSearch(String cpn_cd);



}
