package projectOMS.order.service;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import projectOMS.order.domain.ItemCategoryVO;
import projectOMS.order.domain.ItemListVO;
import projectOMS.order.domain.MemberVO;
import projectOMS.order.repository.ItemCategoryMapper;

import java.util.List;

@Service
@Slf4j
public class ItemCategoryServiceImpl implements ItemCategoryService {


    private final ItemCategoryMapper itemCategoryMapper;

    public ItemCategoryServiceImpl(ItemCategoryMapper itemCategoryMapper) {
        this.itemCategoryMapper = itemCategoryMapper;
    }

    @Override
    public List<ItemCategoryVO> getItemCategory(String cpn_nm) {
        List<ItemCategoryVO> itemCategory = itemCategoryMapper.getItemCategory(cpn_nm);
        return itemCategory;
    }

    @Override
    public List<ItemListVO> getItemListOne(String ctgr_cd) {
        List<ItemListVO> getItemListOne = itemCategoryMapper.getItemListOne(ctgr_cd);
        return getItemListOne;
    }

    @Override
    public void itemCategoryAdd(ItemCategoryVO itemCategory, MemberVO member) {
        itemCategoryMapper.itemCategoryAdd(itemCategory, member);
    }


}
