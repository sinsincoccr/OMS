package projectOMS.order.service;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projectOMS.order.domain.ItemListVO;
import projectOMS.order.domain.MemberVO;
import projectOMS.order.repository.ItemListMapper;

import java.util.List;
import java.util.Map;


@Service
@Slf4j
@RequiredArgsConstructor
public class ItemListServiceImpl implements ItemListService {


    private final ItemListMapper itemListMapper;

    @Override
    public void itemListAdd(ItemListVO itemList, MemberVO member) {
        itemListMapper.itemListAdd(itemList, member);
    }

    @Override
    public List<ItemListVO> getItemListOne(String ctgr_cd) {
        List<ItemListVO> getItemListOne = itemListMapper.getItemListOne(ctgr_cd);
        return getItemListOne;
    }

    @Override
    public ItemListVO getItemByProduct_cd(String product_cd) {
        ItemListVO getItemByProduct_cd = itemListMapper.getItemByProduct_cd(product_cd);
        return getItemByProduct_cd;
    }

    @Override
    public void itemListUpdate(Map<String, Object> Map) {
        itemListMapper.itemListUpdate(Map);

    }


}
