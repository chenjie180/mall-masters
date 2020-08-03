package cn.com.sparknet.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.com.sparknet.model.SmsCouponProductCategoryRelation;

public interface SmsCouponProductCategoryRelationDao {

	int insertBatch(@Param("list")List<SmsCouponProductCategoryRelation> smsCouponProductCategoryRelationList, @Param("couponId")Long id);
	
	

	
}
