package cn.com.sparknet.service.impl;

import cn.com.sparknet.dto.PmsProductCategoryParam;
import cn.com.sparknet.mapper.PmsProductCategoryAttributeRelationMapper;
import cn.com.sparknet.model.PmsProductCategory;
import cn.com.sparknet.model.PmsProductCategoryAttributeRelation;
import cn.com.sparknet.model.PmsProductCategoryAttributeRelationExample;
import cn.com.sparknet.model.PmsProductCategoryExample;
import cn.com.sparknet.service.PmsProductCategoryService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * @author shkstart
 * @create 2020-07-05 13:31
 */
@Service
public class PmsProductCategoryServiceImpl  implements PmsProductCategoryService {
    @Autowired
    private cn.com.sparknet.mapper.PmsProductCategoryMapper pmsProductCategoryMapper;
    @Autowired
    private PmsProductCategoryAttributeRelationMapper pmsProductCategoryAttributeRelationMapper;
   
    
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
          pmsProductCategory.setProductCount(0);
        BeanUtils.copyProperties(pmsProductCategoryParam,pmsProductCategory);
        extracted(pmsProductCategory);//抽取方法
        int insert = pmsProductCategoryMapper.insertSelective(pmsProductCategory);
        List<Long> productAttributeIds = pmsProductCategoryParam.getProductAttributeId();
        extracted(pmsProductCategory, productAttributeIds);
        return insert;
    }

    //方法抽取
	private void extracted(PmsProductCategory pmsProductCategory) {
		//然后需要查询等级
        if(StringUtils.isEmpty(pmsProductCategory.getParentId())) {
        	pmsProductCategory.setLevel(0);
        	pmsProductCategory.setParentId(0L);
        }else {
        	PmsProductCategory selectByPrimaryKey = pmsProductCategoryMapper.selectByPrimaryKey(pmsProductCategory.getParentId());
        	pmsProductCategory.setLevel(selectByPrimaryKey.getLevel()+1);
        	
        }
	}

    private void insertProductCategoryAttributeRelation(Long productCategoryId, Long productAttributeId) {
		PmsProductCategoryAttributeRelation attributeRelation=new PmsProductCategoryAttributeRelation();
		attributeRelation.setProductAttributeId(productAttributeId);
		attributeRelation.setProductCategoryId(productCategoryId);
		pmsProductCategoryAttributeRelationMapper.insert(attributeRelation);
		
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
        extracted(pmsProductCategory);
        int i = pmsProductCategoryMapper.updateByPrimaryKey(pmsProductCategory);
        List<Long> productAttributeIds = pmsProductCategoryParam.getProductAttributeId();
        if(!CollectionUtils.isEmpty(productAttributeIds)) {
        	PmsProductCategoryAttributeRelationExample attributeRelationExample=new PmsProductCategoryAttributeRelationExample();
        	attributeRelationExample.createCriteria().andProductCategoryIdEqualTo(id);
        	pmsProductCategoryAttributeRelationMapper.deleteByExample(attributeRelationExample);
        }
        extracted(pmsProductCategory, productAttributeIds);
        return i;
    }

	private void extracted(PmsProductCategory pmsProductCategory, List<Long> productAttributeIds) {
		for (Long productAttributeId : productAttributeIds) {
        	insertProductCategoryAttributeRelation(pmsProductCategory.getId(),productAttributeId);
		}
	}
}
