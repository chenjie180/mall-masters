package cn.com.sparknet.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.com.sparknet.dto.OmsOrderParam;
import cn.com.sparknet.model.OmsOrder;

public interface OmsOrderDao {

	public List<OmsOrder> selectOmsOrderListByPage(@Param("omsOrderParam") OmsOrderParam omsOrderParam) ;

}
