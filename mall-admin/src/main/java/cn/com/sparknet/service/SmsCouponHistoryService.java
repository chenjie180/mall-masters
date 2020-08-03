package cn.com.sparknet.service;

import java.util.List;

import cn.com.sparknet.model.SmsCouponHistory;

public interface SmsCouponHistoryService {

	public List<SmsCouponHistory>  selectSmsCouponHistoryByCouponId(int pageNum,int pageSize,Long couponId, Integer useStatus, Long orderId);
}
