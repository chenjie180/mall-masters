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
import cn.com.sparknet.dto.OmsOrderDeliveryParam;
import cn.com.sparknet.dto.OmsOrderDetail;
import cn.com.sparknet.dto.OmsOrderParam;
import cn.com.sparknet.dto.OmsOrderReceiveParam;
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
	@Autowired
	private OmsOrderOperateHistoryMapper omsOrderOperateHistoryMapper;
	
	
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


	@Override
	public List<OmsOrderDetail> selectOmsOrderInfo(Long id) {
		List<OmsOrderDetail> selectOmsOrderInfo = omsOrderDao.selectOmsOrderInfo(id);
		return selectOmsOrderInfo;
	}


	@Override
	public int updateOmsOrderNote(Long id, int status,String note) {
		OmsOrderExample omsOrderExample=new OmsOrderExample();
		omsOrderExample.createCriteria().andIdEqualTo(id);
		OmsOrder omsOrder=new OmsOrder();
		omsOrder.setNote(note);
		omsOrder.setStatus(status);
		int updateByExampleSelective = omsOrderMapper.updateByExampleSelective(omsOrder, omsOrderExample);
		OmsOrderOperateHistory record=new OmsOrderOperateHistory();
		record.setCreateTime(new Date());
		record.setNote("修改备注信息:"+note);
		record.setOperateMan("后台管理员");
		record.setOrderStatus(status);
		record.setOrderId(id);
		omsOrderOperateHistoryMapper.insertSelective(record);
		int i=1;
		return i;
	}


	@Override
	public int updatereceiverInfo(OmsOrderReceiveParam omsOrderReceiveParam) {
		System.out.println("修改收货");
		OmsOrder omsOrder=new OmsOrder();
		BeanUtils.copyProperties(omsOrderReceiveParam, omsOrder);
		int updateByPrimaryKeySelective = omsOrderMapper.updateByPrimaryKeySelective(omsOrder);
		OmsOrderOperateHistory record=new OmsOrderOperateHistory();
		record.setCreateTime(new Date());
		record.setNote("修改收货人信息");
		record.setOperateMan("后台管理员");
		record.setOrderStatus(1);
		record.setOrderId(omsOrder.getId());
		omsOrderOperateHistoryMapper.insertSelective(record);
		int i=1;
		return i;
	}


	@Override
	public int sendOmsOrdersList(int status, List<OmsOrderDeliveryParam> omsOrderDeliveryParamList) {
		int i=omsOrderDao.delivery(omsOrderDeliveryParamList);
		List<OmsOrderOperateHistory> historyList = omsOrderDeliveryParamList.stream().map(omsOrderDeliveryParam->{
			OmsOrderOperateHistory omsOrderOperateHistory=new OmsOrderOperateHistory();
			omsOrderOperateHistory.setOrderId(omsOrderDeliveryParam.getId());
			omsOrderOperateHistory.setOperateMan("后台管理员");
			omsOrderOperateHistory.setCreateTime(new Date());
			omsOrderOperateHistory.setOrderStatus(status);
			omsOrderOperateHistory.setNote("完成发货："+omsOrderDeliveryParam.getId());
			return omsOrderOperateHistory;
		}).collect(Collectors.toList());
		  
		  omsOrderOperateHistoryDao.insertBatch(historyList);;
		 
		return i;
	}
	

}
