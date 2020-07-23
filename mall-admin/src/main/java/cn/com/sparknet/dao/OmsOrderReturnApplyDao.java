package cn.com.sparknet.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.com.sparknet.dto.OmsOrderReturnApplyParam;
import cn.com.sparknet.model.OmsOrderReturnApply;

public interface OmsOrderReturnApplyDao {
	
	public List<OmsOrderReturnApply> selectOmsOrderReturnApplyByPage(@Param(value = "omsOrderReturnApplyParam") OmsOrderReturnApplyParam omsOrderReturnApplyParam) ;

}
