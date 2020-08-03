package cn.com.sparknet.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.github.pagehelper.PageHelper;

import cn.com.sparknet.mapper.SmsCouponHistoryMapper;
import cn.com.sparknet.model.SmsCouponHistory;
import cn.com.sparknet.model.SmsCouponHistoryExample;
import cn.com.sparknet.model.SmsCouponHistoryExample.Criteria;
import cn.com.sparknet.service.SmsCouponHistoryService;

@Service
public class SmsCouponHistoryServiceImpl implements  SmsCouponHistoryService{
	
	@Autowired
	private SmsCouponHistoryMapper couponHistoryMapper;
	
	@Override
	public List<SmsCouponHistory> selectSmsCouponHistoryByCouponId(int pageNum, int pageSize, Long couponId,
			Integer useStatus, Long orderId) {
		PageHelper.startPage(pageNum, pageSize);
		SmsCouponHistoryExample example=new SmsCouponHistoryExample();
		Criteria andCouponIdEqualTo = example.createCriteria(); 
				andCouponIdEqualTo.andCouponIdEqualTo(couponId);
		if(StringUtils.isEmpty(useStatus)) {
			andCouponIdEqualTo.andUseStatusEqualTo(useStatus);
		}
		if(StringUtils.isEmpty(orderId)) {
			andCouponIdEqualTo.andOrderIdEqualTo(orderId);
		}
		List<SmsCouponHistory> selectByExample = couponHistoryMapper.selectByExample(example);
		return  selectByExample;
	}

}
