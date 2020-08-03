package cn.com.sparknet.dao;

import java.util.List;

import cn.com.sparknet.dto.SmsCouponParam;

public interface SmsCouponDao {

	
	public List<SmsCouponParam> selectSmsCouponInfoById (Long id);
}
