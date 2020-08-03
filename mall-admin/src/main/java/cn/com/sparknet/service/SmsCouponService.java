package cn.com.sparknet.service;

import java.util.List;

import cn.com.sparknet.dto.SmsCouponParam;
import cn.com.sparknet.model.SmsCoupon;

public interface SmsCouponService {

	public List<SmsCoupon> selectSmsCouponByPage(int pageNum,int pageSize,String name, Integer type);

	public int insertSmsCoupon(SmsCouponParam couponParam);

	public int deleteSmsCoupon(Long id);

	public SmsCoupon selectSmsCouponById(Long id);

	public List<SmsCouponParam> selectSmsCouponInfoById(Long id);

	public int updateSmsCouponInfoById(SmsCouponParam smsCouponParam);
}
