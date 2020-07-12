package cn.com.sparknet.service.impl;

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

@Service
public class OmsOrderServiceImpl {
	
	@Autowired
	private OmsOrderDao omsOrderDao;
	
	
	public void selectOmsOrderListByPage(OmsOrderParam  omsOrderParam,int pageNum,int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		OmsOrder omsOrder=new OmsOrder();
		BeanUtils.copyProperties(omsOrderParam, omsOrder);
		
		omsOrderDao.selectOmsOrderListByPage(omsOrder);
	}
	

}
