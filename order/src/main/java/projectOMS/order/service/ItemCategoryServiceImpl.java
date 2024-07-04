package projectOMS.order.service;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import projectOMS.order.domain.ItemCategoryVO;
import projectOMS.order.domain.ItemListVO;
import projectOMS.order.domain.MemberVO;
import projectOMS.order.repository.ItemCategoryMapper;

import java.util.List;
import java.util.Map;

@Service
@Slf4j
@RequiredArgsConstructor
public class ItemCategoryServiceImpl implements ItemCategoryService {


    private final ItemCategoryMapper itemCategoryMapper;


    @Override
    public List<ItemCategoryVO> getItemCategory(String cpn_nm) {
        List<ItemCategoryVO> itemCategory = itemCategoryMapper.getItemCategory(cpn_nm);
        return itemCategory;
    }

    @Override
    public ItemCategoryVO getItemCategoryByctgrCd(String ctgr_cd) {
        return itemCategoryMapper.getItemCategoryByctgrCd(ctgr_cd);
    }


    @Override
    public void itemCategoryAdd(ItemCategoryVO itemCategory, MemberVO member) {
        itemCategoryMapper.itemCategoryAdd(itemCategory, member);
    }

    @Override
    public void itemCategoryUpdate(Map<String, Object> Map) {
        itemCategoryMapper.itemCategoryUpdate(Map);

    }

    @Override
    public void deleteItemCategory(String ctgr_cd) {
        itemCategoryMapper.deleteItemCategory(ctgr_cd);
    }


}
