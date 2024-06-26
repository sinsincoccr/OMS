package projectOMS.order.service;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import projectOMS.order.domain.ItemCategoryVO;
import projectOMS.order.domain.MemberVO;
import projectOMS.order.repository.ItemCategoryMapper;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ItemCategoryServiceImpl implements ItemCategoryService {


    private final ItemCategoryMapper itemCategoryMapper;

    @Override
    public List<ItemCategoryVO> getItemCategory() {
        return itemCategoryMapper.getItemCategory();
    }


    @Override
    public void updateView(String ctgr_cd) {
        itemCategoryMapper.updateView(ctgr_cd);
    }








}
