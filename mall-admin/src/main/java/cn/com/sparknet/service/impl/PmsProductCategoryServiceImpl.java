package cn.com.sparknet.service.impl;

import cn.com.sparknet.dto.PmsProductCategoryParam;
import cn.com.sparknet.model.PmsProductCategory;
import cn.com.sparknet.model.PmsProductCategoryExample;
import cn.com.sparknet.service.PmsProductCategoryService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author shkstart
 * @create 2020-07-05 13:31
 */
@Service
public class PmsProductCategoryServiceImpl  implements PmsProductCategoryService {
    @Autowired
    private cn.com.sparknet.mapper.PmsProductCategoryMapper pmsProductCategoryMapper;

    @Override
    public List<PmsProductCategory> selectPmsProductCategoryByPage(long parentId,  int pageNum,int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        PmsProductCategoryExample pmsProductCategoryExample=new PmsProductCategoryExample();
        pmsProductCategoryExample.createCriteria().andParentIdEqualTo(parentId);
        List<PmsProductCategory> pmsProductCategories = pmsProductCategoryMapper.selectByExample(pmsProductCategoryExample);
        return  pmsProductCategories;
    }

    @Override
    public int updatePmsProductCategoryNavStatusById(List<Long> ids, int navStatus) {
        PmsProductCategory pmsProductCategory=new PmsProductCategory();
        pmsProductCategory.setNavStatus(navStatus);
        PmsProductCategoryExample pmsProductCategoryExample=new PmsProductCategoryExample();
        pmsProductCategoryExample.createCriteria().andIdIn(ids);
        int i = pmsProductCategoryMapper.updateByExampleSelective(pmsProductCategory, pmsProductCategoryExample);
    return i;
    }

    @Override
    public int updatePmsProductCategoryShowStatusById(List<Long> ids, int showStatus) {
        PmsProductCategory pmsProductCategory=new PmsProductCategory();
        pmsProductCategory.setShowStatus(showStatus);
        PmsProductCategoryExample pmsProductCategoryExample=new PmsProductCategoryExample();
        pmsProductCategoryExample.createCriteria().andIdIn(ids);
        int i = pmsProductCategoryMapper.updateByExampleSelective(pmsProductCategory, pmsProductCategoryExample);
        return i;
    }

    @Override
    public int deletePmsProductCategoryById(Long id) {
        PmsProductCategoryExample pmsProductCategoryExample=new PmsProductCategoryExample();
        pmsProductCategoryExample.createCriteria().andIdEqualTo(id);
        int i = pmsProductCategoryMapper.deleteByExample(pmsProductCategoryExample);
        return  i;
    }

    @Override
    public int deleteBatchPmsProductCategoryByIds(List<Long> ids) {
        PmsProductCategoryExample pmsProductCategoryExample=new PmsProductCategoryExample();
        pmsProductCategoryExample.createCriteria().andIdIn(ids);
        int i = pmsProductCategoryMapper.deleteByExample(pmsProductCategoryExample);
        return  i;
    }

    @Override
    public int insertPmsProductCategoryInfo(PmsProductCategoryParam pmsProductCategoryParam) {
          PmsProductCategory pmsProductCategory=new PmsProductCategory();
        BeanUtils.copyProperties(pmsProductCategoryParam,pmsProductCategory);
        int insert = pmsProductCategoryMapper.insert(pmsProductCategory);
        return insert;
    }

    @Override
    public PmsProductCategory selectPmsProductCategoryInfoById(Long id) {
        PmsProductCategory pmsProductCategory = pmsProductCategoryMapper.selectByPrimaryKey(id);
        return pmsProductCategory;
    }

    @Override
    public int updatePmsProductCategoryInfoById(Long id, PmsProductCategoryParam pmsProductCategoryParam) {
        PmsProductCategory pmsProductCategory=new PmsProductCategory();
        pmsProductCategory.setId(id);
        BeanUtils.copyProperties(pmsProductCategoryParam,pmsProductCategory);
        int i = pmsProductCategoryMapper.updateByPrimaryKey(pmsProductCategory);
        return i;
    }
}
