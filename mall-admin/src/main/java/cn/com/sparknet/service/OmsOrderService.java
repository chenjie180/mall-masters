package cn.com.sparknet.service;

import java.util.List;

import cn.com.sparknet.dto.OmsOrderParam;
import cn.com.sparknet.model.OmsOrder;

public interface OmsOrderService {

	public List<OmsOrder> selectOmsOrderListByPage(OmsOrderParam  omsOrderParam,int pageNum,int pageSize);

	public void closeOmsOrderList(int status, List<Long> ids);

}
