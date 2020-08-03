package cn.com.sparknet.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.com.sparknet.model.SmsCouponProductRelation;

public interface SmsCouponProductRelationDao {

	public int insertBatch(@Param("list") List<SmsCouponProductRelation> couponProductRelationList, @Param("couponId")Long couponId);
	

}
