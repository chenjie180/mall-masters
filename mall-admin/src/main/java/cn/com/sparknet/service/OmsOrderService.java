package cn.com.sparknet.service;

import java.util.List;

import cn.com.sparknet.dto.OmsOrderDetail;
import cn.com.sparknet.dto.OmsOrderParam;
import cn.com.sparknet.dto.OmsOrderReceiveParam;
import cn.com.sparknet.model.OmsOrder;

public interface OmsOrderService {

	public List<OmsOrder> selectOmsOrderListByPage(OmsOrderParam  omsOrderParam,int pageNum,int pageSize);

	public int closeOmsOrderList(int status, List<Long> ids);

	public int deleteOmsOrderList(int status, List<Long> ids);

	public int sendOmsOrderList(int status, List<Long> ids);

	public List<OmsOrderDetail> selectOmsOrderInfo(Long id);
	
	public int updateOmsOrderNote(Long id,int status,String note);

	public int updatereceiverInfo(OmsOrderReceiveParam omsOrderReceiveParam);

}
