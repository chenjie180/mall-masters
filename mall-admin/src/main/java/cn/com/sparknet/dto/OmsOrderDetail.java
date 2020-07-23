package cn.com.sparknet.dto;

import java.util.List;

import cn.com.sparknet.model.OmsOrder;
import cn.com.sparknet.model.OmsOrderItem;
import cn.com.sparknet.model.OmsOrderOperateHistory;
import lombok.Data;
import lombok.EqualsAndHashCode;
@Data
@EqualsAndHashCode(callSuper = false)
public class OmsOrderDetail extends OmsOrder {
	
	public List<OmsOrderItem>  omsOrderItemList;
	public List<OmsOrderOperateHistory>   omsOrderOperateHistoryList;

}
