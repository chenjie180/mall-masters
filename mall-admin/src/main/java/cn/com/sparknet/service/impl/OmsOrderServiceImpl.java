package cn.com.sparknet.service.impl;

import java.util.List;
import java.util.stream.Stream;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;

import cn.com.sparknet.dao.OmsOrderDao;
import cn.com.sparknet.dto.OmsOrderParam;
import cn.com.sparknet.mapper.OmsOrderMapper;
import cn.com.sparknet.model.OmsOrder;
import cn.com.sparknet.model.OmsOrderExample;
import cn.com.sparknet.model.OmsOrderExample.Criteria;
import cn.com.sparknet.service.OmsOrderService;

@Service
public class OmsOrderServiceImpl implements OmsOrderService{
	
	@Autowired
	private OmsOrderDao omsOrderDao;
	@Autowired
	private OmsOrderMapper omsOrderMapper;
	
	
	public List<OmsOrder> selectOmsOrderListByPage(OmsOrderParam  omsOrderParam,int pageNum,int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		List<OmsOrder> OmsOrderList= omsOrderDao.selectOmsOrderListByPage(omsOrderParam);
		return OmsOrderList;
	}


	@Override
	public void closeOmsOrderList(int status, List<Long> ids) {
		
		OmsOrder omsOrder=new OmsOrder();
		omsOrder.setStatus(status);
		OmsOrderExample omsOrderExample=new OmsOrderExample();
		omsOrderExample.createCriteria().andIdIn(ids);
		int updateByExampleSelective = omsOrderMapper.updateByExampleSelective(omsOrder, omsOrderExample);
		ids.stream();
		ids.forEach(id -> {
			System.out.println(id);
		});
		
	}
	

}
