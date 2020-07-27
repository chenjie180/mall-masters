package cn.com.sparknet.service;

import java.util.List;

import cn.com.sparknet.dto.OmsOrderReturnApplyParam;
import cn.com.sparknet.dto.OmsUpdateStatusParam;
import cn.com.sparknet.model.OmsOrderReturnApply;

public interface OmsOrderReturnApplyService {

	public List<OmsOrderReturnApply> selectOmsOrderReturnApplyByPage(OmsOrderReturnApplyParam omsOrderReturnApplyParam,int pageNum,int pageSize);

	public int deleteOmsOrderReturnApplyByIds(List<Long> ids);

	public OmsOrderReturnApply selectOmsOrderReturnApplyById(Long id);

	public int updateOmsOrderReturnApplyStatus(Long id, OmsUpdateStatusParam omsUpdateStatusParam);
}
