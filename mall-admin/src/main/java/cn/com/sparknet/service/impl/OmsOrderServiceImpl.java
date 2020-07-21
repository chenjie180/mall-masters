package cn.com.sparknet.service.impl;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.mysql.cj.x.protobuf.MysqlxCrud.OrderOrBuilder;

import cn.com.sparknet.dao.OmsOrderDao;
import cn.com.sparknet.dao.OmsOrderOperateHistoryDao;
import cn.com.sparknet.dto.OmsOrderParam;
import cn.com.sparknet.mapper.OmsOrderMapper;
import cn.com.sparknet.mapper.OmsOrderOperateHistoryMapper;
import cn.com.sparknet.model.OmsOrder;
import cn.com.sparknet.model.OmsOrderExample;
import cn.com.sparknet.model.OmsOrderExample.Criteria;
import cn.com.sparknet.model.OmsOrderOperateHistory;
import cn.com.sparknet.service.OmsOrderService;

@Service
public class OmsOrderServiceImpl implements OmsOrderService{
	
	@Autowired
	private OmsOrderDao omsOrderDao;
	@Autowired
	private OmsOrderMapper omsOrderMapper;
	@Autowired
	private OmsOrderOperateHistoryDao omsOrderOperateHistoryDao;
	
	
	public List<OmsOrder> selectOmsOrderListByPage(OmsOrderParam  omsOrderParam,int pageNum,int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		List<OmsOrder> OmsOrderList= omsOrderDao.selectOmsOrderListByPages(omsOrderParam);
		return OmsOrderList;
	}


	@Override
	public int closeOmsOrderList(int status, List<Long> ids) {
		OmsOrder omsOrder=new OmsOrder();
		omsOrder.setStatus(status);
		OmsOrderExample omsOrderExample=new OmsOrderExample();
		omsOrderExample.createCriteria().andIdIn(ids);
		int updateByExampleSelective = omsOrderMapper.updateByExampleSelective(omsOrder, omsOrderExample);
		List<OmsOrderOperateHistory> historyList=ids.stream().map(orderId->{
			OmsOrderOperateHistory omsOrderOperateHistory=new OmsOrderOperateHistory();
			omsOrderOperateHistory.setOrderId(orderId);
			omsOrderOperateHistory.setOperateMan("后台管理员");
			omsOrderOperateHistory.setCreateTime(new Date());
			omsOrderOperateHistory.setOrderStatus(4);
			omsOrderOperateHistory.setNote("关闭订单："+orderId);
			return omsOrderOperateHistory;
		}).collect(Collectors.toList());
		omsOrderOperateHistoryDao.insertBatch(historyList);
		return  updateByExampleSelective;
		
	}


	@Override
	public int deleteOmsOrderList(int status, List<Long> ids) {
		OmsOrder omsOrder=new OmsOrder();
		omsOrder.setStatus(1);
		OmsOrderExample omsOrderExample=new OmsOrderExample();
		omsOrderExample.createCriteria().andIdIn(ids).andStatusEqualTo(0);
		int updateByExampleSelective = omsOrderMapper.updateByExampleSelective(omsOrder, omsOrderExample);
		return updateByExampleSelective;
	}


	@Override
	public int sendOmsOrderList(int status, List<Long> ids) {
		OmsOrder omsOrder=new OmsOrder();
		omsOrder.setStatus(status);
		OmsOrderExample omsOrderExample=new OmsOrderExample();
		omsOrderExample.createCriteria().andIdIn(ids);
		int updateByExampleSelective = omsOrderMapper.updateByExampleSelective(omsOrder, omsOrderExample);
		List<OmsOrderOperateHistory> historyList=ids.stream().map(orderId->{
			OmsOrderOperateHistory omsOrderOperateHistory=new OmsOrderOperateHistory();
			omsOrderOperateHistory.setOrderId(orderId);
			omsOrderOperateHistory.setOperateMan("后台管理员");
			omsOrderOperateHistory.setCreateTime(new Date());
			omsOrderOperateHistory.setOrderStatus(status);
			omsOrderOperateHistory.setNote("完成发货："+orderId);
			return omsOrderOperateHistory;
		}).collect(Collectors.toList());
		omsOrderOperateHistoryDao.insertBatch(historyList);
		return  updateByExampleSelective;
	}
	

}
