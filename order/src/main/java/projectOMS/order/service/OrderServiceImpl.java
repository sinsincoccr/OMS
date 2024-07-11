package projectOMS.order.service;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import projectOMS.order.domain.ItemCategoryVO;
import projectOMS.order.domain.OrderFormVO;
import projectOMS.order.repository.ItemCategoryMapper;
import projectOMS.order.repository.OrderMapper;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {


    private final OrderMapper orderMapper;



    @Override
    public List<OrderFormVO> getOrderSearch(String cpn_cd) {
        List<OrderFormVO> orderForm = orderMapper.getOrderSearch(cpn_cd);
        return orderForm;
    }
}
