package cn.com.sparknet.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.util.StringUtil;

import cn.com.sparknet.dao.SmsCouponDao;
import cn.com.sparknet.dao.SmsCouponProductCategoryRelationDao;
import cn.com.sparknet.dao.SmsCouponProductRelationDao;
import cn.com.sparknet.dto.SmsCouponParam;
import cn.com.sparknet.mapper.SmsCouponMapper;
import cn.com.sparknet.mapper.SmsCouponProductCategoryRelationMapper;
import cn.com.sparknet.mapper.SmsCouponProductRelationMapper;
import cn.com.sparknet.model.SmsCoupon;
import cn.com.sparknet.model.SmsCouponExample;
import cn.com.sparknet.model.SmsCouponProductCategoryRelationExample;
import cn.com.sparknet.model.SmsCouponProductRelation;
import cn.com.sparknet.model.SmsCouponProductRelationExample;
import cn.com.sparknet.service.SmsCouponService;
@Service

public class SmsCouponServiceImpl implements SmsCouponService {

	@Autowired
	private SmsCouponMapper smsCouponMapper;
	
	@Autowired
	private SmsCouponDao smsCouponDao;
	@Autowired
	private SmsCouponProductRelationDao smsCouponProductRelationDao;
	@Autowired
	private SmsCouponProductCategoryRelationDao smsCouponProductCategoryRelationDao;
	@Autowired
	private SmsCouponProductCategoryRelationMapper smsCouponProductCategoryRelationMapper;
	@Autowired
	private SmsCouponProductRelationMapper smsCouponProductRelationMapper;
	
	public List<SmsCoupon> selectSmsCouponByPage(int pageNum,int pageSize,String name, Integer type){
		PageHelper.startPage(pageNum, pageSize);
		SmsCouponExample example=new SmsCouponExample();
		if(StringUtil.isNotEmpty(name)) {
			example.createCriteria().andNameLike("%"+name+"%");
		}
		if(null!=type) {
			example.createCriteria().andTypeEqualTo(type);
		}
		List<SmsCoupon> selectByExample = smsCouponMapper.selectByExample(example);
		return selectByExample;
	}

	@Override
	public int insertSmsCoupon(SmsCouponParam couponParam) {
		SmsCoupon coupon=new SmsCoupon();
		BeanUtils.copyProperties(couponParam, coupon);
		int insertSelective = smsCouponMapper.insertSelective(coupon);
		if(!StringUtils.isEmpty(couponParam.getCouponProductRelationList())&&coupon.getUseType()==2) {
			int i=smsCouponProductRelationDao.insertBatch(couponParam.getCouponProductRelationList(),coupon.getId());
		}
		if(!StringUtils.isEmpty(couponParam.getSmsCouponProductCategoryRelationList())&&coupon.getUseType()==1) {
			int i=smsCouponProductCategoryRelationDao.insertBatch(couponParam.getSmsCouponProductCategoryRelationList(),coupon.getId());
		}
		int a=1;
		return a;
	}

	@Override
	public int deleteSmsCoupon(Long id) {
		int deleteByPrimaryKey = smsCouponMapper.deleteByPrimaryKey(id);
		return deleteByPrimaryKey;
	}

	@Override
	public SmsCoupon selectSmsCouponById(Long id) {
		SmsCoupon selectByPrimaryKey = smsCouponMapper.selectByPrimaryKey(id);
		return selectByPrimaryKey;
	}

	@Override
	public List<SmsCouponParam> selectSmsCouponInfoById(Long id) {
		List<SmsCouponParam> selectSmsCouponInfoById = smsCouponDao.selectSmsCouponInfoById(id);
		return selectSmsCouponInfoById;
	}

	@Override
	public int updateSmsCouponInfoById(SmsCouponParam smsCouponParam) {
		SmsCouponExample example=new SmsCouponExample();
		example.createCriteria().andIdEqualTo(smsCouponParam.getId());
		SmsCoupon coupon=new SmsCoupon();
		BeanUtils.copyProperties(smsCouponParam, coupon);
		int updateByExampleSelective = smsCouponMapper.updateByExampleSelective(coupon, example);
		List<SmsCouponProductRelation> couponProductRelationList = smsCouponParam.getCouponProductRelationList();
		if(!StringUtils.isEmpty(smsCouponParam.getCouponProductRelationList())&&coupon.getUseType()==2) {
			//做删除的操作
			SmsCouponProductRelationExample example2=new SmsCouponProductRelationExample();
			example2.createCriteria().andCouponIdEqualTo(smsCouponParam.getId());
			smsCouponProductRelationMapper.deleteByExample(example2);
			int i=smsCouponProductRelationDao.insertBatch(smsCouponParam.getCouponProductRelationList(),coupon.getId());
		}
		if(!StringUtils.isEmpty(smsCouponParam.getSmsCouponProductCategoryRelationList())&&coupon.getUseType()==1) {
			//做删除的操作
			SmsCouponProductCategoryRelationExample categoryRelationExample=new SmsCouponProductCategoryRelationExample();
			categoryRelationExample.createCriteria().andCouponIdEqualTo(smsCouponParam.getId());
			smsCouponProductCategoryRelationMapper.deleteByExample(categoryRelationExample);
			int i=smsCouponProductCategoryRelationDao.insertBatch(smsCouponParam.getSmsCouponProductCategoryRelationList(),coupon.getId());
		}
		int a=1;
		return a;
	}

	

	
	 
	
}
