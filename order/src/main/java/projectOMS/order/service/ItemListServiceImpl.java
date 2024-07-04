package projectOMS.order.service;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projectOMS.order.domain.ItemListVO;
import projectOMS.order.domain.MemberVO;
import projectOMS.order.repository.ItemListMapper;



@Service
@Slf4j
@RequiredArgsConstructor
public class ItemListServiceImpl implements ItemListService {


    private final ItemListMapper itemListMapper;

    @Override
    public void itemListAdd(ItemListVO itemList, MemberVO member) {
        itemListMapper.itemListAdd(itemList, member);
    }
}
