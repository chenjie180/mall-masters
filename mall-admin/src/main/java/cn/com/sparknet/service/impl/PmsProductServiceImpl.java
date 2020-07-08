package cn.com.sparknet.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import cn.com.sparknet.dto.PmsProductParam;
import cn.com.sparknet.dto.PmsProductQueryParam;
import cn.com.sparknet.mapper.CmsPrefrenceAreaProductRelationMapper;
import cn.com.sparknet.mapper.CmsSubjectProductRelationMapper;
import cn.com.sparknet.mapper.PmsMemberPriceMapper;
import cn.com.sparknet.mapper.PmsProductAttributeValueMapper;
import cn.com.sparknet.mapper.PmsProductFullReductionMapper;
import cn.com.sparknet.mapper.PmsProductLadderMapper;
import cn.com.sparknet.mapper.PmsProductMapper;
import cn.com.sparknet.mapper.PmsSkuStockMapper;
import cn.com.sparknet.model.CmsPrefrenceAreaProductRelation;
import cn.com.sparknet.model.CmsSubjectProductRelation;
import cn.com.sparknet.model.PmsMemberPrice;
import cn.com.sparknet.model.PmsProduct;
import cn.com.sparknet.model.PmsProductAttributeValue;
import cn.com.sparknet.model.PmsProductExample;
import cn.com.sparknet.model.PmsProductExample.Criteria;
import cn.com.sparknet.model.PmsProductFullReduction;
import cn.com.sparknet.model.PmsProductLadder;
import cn.com.sparknet.model.PmsSkuStock;
import cn.com.sparknet.service.PmsProductService;

@Service
public class PmsProductServiceImpl  implements PmsProductService{
	
	@Autowired
	private PmsProductMapper pmsProductMapper;
	@Autowired
	private PmsMemberPriceMapper pmsMemberPriceMapper;
	@Autowired
	private PmsProductFullReductionMapper pmsProductFullReductionMapper;
	@Autowired
	private PmsProductLadderMapper pmsProductLadderMapper;
	@Autowired
	private PmsSkuStockMapper pmsSkuStockMapper;
	@Autowired
	private PmsProductAttributeValueMapper  pmsProductAttributeValueMapper;
	@Autowired
	private CmsSubjectProductRelationMapper  cmsSubjectProductRelationMapper;
	@Autowired
	private CmsPrefrenceAreaProductRelationMapper  cmsPrefrenceAreaProductRelationMapper;
	
	
	public int insertPmsProduct(PmsProductParam param) {
		PmsProduct pmsProduct=new PmsProduct();
		BeanUtils.copyProperties(param, pmsProduct);
		int insert = pmsProductMapper.insert(pmsProduct);
		//商品会员价格表
		List<PmsMemberPrice> pmsMemberPrices = param.getPmsMemberPriceList();
		for (PmsMemberPrice pmsMemberPrice : pmsMemberPrices) {
			pmsMemberPrice.setProductId(pmsProduct.getId());
			pmsMemberPriceMapper.insertSelective(pmsMemberPrice);
		}
		//商品满减表
		List<PmsProductFullReduction> pmsProductFullReductionList = param.getPmsProductFullReductionList();
		for (PmsProductFullReduction pmsProductFullReduction : pmsProductFullReductionList) {
			pmsProductFullReduction.setProductId(pmsProduct.getId());
			pmsProductFullReductionMapper.insert(pmsProductFullReduction);
		}
		//商品阶梯价格表
		List<PmsProductLadder> pmsProductLadderList = param.getPmsProductLadderList();
		for (PmsProductLadder pmsProductLadder : pmsProductLadderList) {
			pmsProductLadder.setProductId(pmsProduct.getId());
			pmsProductLadderMapper.insertSelective(pmsProductLadder);
		}
		//商品sku
		List<PmsSkuStock> pmsSkuStockList = param.getPmsSkuStockList();
		for (PmsSkuStock pmsSkuStock : pmsSkuStockList) {
			pmsSkuStock.setProductId(pmsProduct.getId());
			pmsSkuStock.setSale(0);
			pmsSkuStockMapper.insertSelective(pmsSkuStock);
		}
		//商品属性分类表
		List<PmsProductAttributeValue> pmsProductAttributeValueList = param.getPmsProductAttributeValueList();
		for (PmsProductAttributeValue pmsProductAttributeValue : pmsProductAttributeValueList) {
			pmsProductAttributeValue.setProductId(pmsProduct.getId());
			pmsProductAttributeValueMapper.insertSelective(pmsProductAttributeValue);
		}
		//商品关联专题
		List<CmsSubjectProductRelation> cmsSubjectProductRelationList = param.getCmsSubjectProductRelationList();
		for (CmsSubjectProductRelation cmsSubjectProductRelation : cmsSubjectProductRelationList) {
			cmsSubjectProductRelation.setProductId(pmsProduct.getId());
			cmsSubjectProductRelationMapper.insertSelective(cmsSubjectProductRelation);
		}
		//商品关联优选
		List<CmsPrefrenceAreaProductRelation> cmsPrefrenceAreaProductRelationList = param.getCmsPrefrenceAreaProductRelationList();
		for (CmsPrefrenceAreaProductRelation cmsPrefrenceAreaProductRelation : cmsPrefrenceAreaProductRelationList) {
			cmsPrefrenceAreaProductRelation.setProductId(pmsProduct.getId());
			cmsPrefrenceAreaProductRelationMapper.insertSelective(cmsPrefrenceAreaProductRelation);
		}
		return insert;
		
	}


	@Override
	public List<PmsProduct> selectPmsProductByPage(PmsProductQueryParam queryParam, Integer pageNum, Integer pageSize) {
		Page<Object> startPage = PageHelper.startPage(pageNum, pageSize);
		PmsProductExample example=new PmsProductExample();
		example.setOrderByClause(" sort");
		Criteria createCriteria = example.createCriteria();
		if(null!=queryParam.getName()) {
			createCriteria.andNameLike("%"+queryParam.getName()+"%");
		}
		if(null!=queryParam.getProductSn()) {
			createCriteria.andProductSnLike("%"+queryParam.getProductSn()+"%");
		}
		if(null!=queryParam.getProductCategoryId()) {
			createCriteria.andProductCategoryIdEqualTo(queryParam.getProductCategoryId());
		}
		if(null!=queryParam.getBrandId()) {
			createCriteria.andBrandIdEqualTo(queryParam.getBrandId());
		}
		if(null!=queryParam.getPublishStatus()) {
			createCriteria.andPublishStatusEqualTo(queryParam.getPublishStatus()) ;
		}
		if(null!=queryParam.getVerifyStatus()) {
			createCriteria.andVerifyStatusEqualTo(queryParam.getVerifyStatus()) ;
		}
		List<PmsProduct> selectByExample = pmsProductMapper.selectByExample(example);
		return selectByExample;
	}


	@Override
	public int updatePublishStatus(List<Long> ids, Integer publishStatus) {
		PmsProduct pmsProduct=new PmsProduct();
		pmsProduct.setPublishStatus(publishStatus);
		PmsProductExample example=new PmsProductExample();
		example.createCriteria().andIdIn(ids);
		int updateByExample = pmsProductMapper.updateByExampleSelective(pmsProduct, example);
		return  updateByExample;
	}
	
	@Override
	public int updateNewStatus(List<Long> ids, Integer newStatus) {
		PmsProduct pmsProduct=new PmsProduct();
		pmsProduct.setNewStatus(newStatus);
		PmsProductExample example=new PmsProductExample();
		example.createCriteria().andIdIn(ids);
		int updateByExample = pmsProductMapper.updateByExampleSelective(pmsProduct, example);
		return  updateByExample;
	}
	
	@Override
	public int updateRecommandStatus(List<Long> ids, Integer recommandStatus) {
		PmsProduct pmsProduct=new PmsProduct();
		pmsProduct.setRecommandStatus(recommandStatus);
		PmsProductExample example=new PmsProductExample();
		example.createCriteria().andIdIn(ids);
		int updateByExample = pmsProductMapper.updateByExampleSelective(pmsProduct, example);
		return  updateByExample;
	}
	
	
	
}
