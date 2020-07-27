package cn.com.sparknet.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.com.sparknet.dto.OmsOrderDeliveryParam;
import cn.com.sparknet.dto.OmsOrderDetail;
import cn.com.sparknet.dto.OmsOrderParam;
import cn.com.sparknet.model.OmsOrder;

public interface OmsOrderDao {

	public List<OmsOrder> selectOmsOrderListByPages(@Param("omsOrderParam") OmsOrderParam omsOrderParam) ;

	public List<OmsOrderDetail> selectOmsOrderInfo(@Param("id") Long id);

	public int delivery(@Param("list") List<OmsOrderDeliveryParam> lists);
	

}
