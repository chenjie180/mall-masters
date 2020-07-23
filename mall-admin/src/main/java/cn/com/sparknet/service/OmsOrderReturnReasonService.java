package cn.com.sparknet.service;


import java.util.List;

import cn.com.sparknet.model.OmsOrderReturnReason;

public interface OmsOrderReturnReasonService {

	public List<OmsOrderReturnReason> selectOmsOrderReturnReasonListByPage( int pageNum,int pageSize) ;

	public int updateOmsOrderReturnReasonStatusById(Long id, int status);

	public int deleteOmsOrderReturnReasonByIds(List<Long> ids);

	public OmsOrderReturnReason selectOmsOrderReturnReasonById(Long id);

	public int updateOmsOrderReturnReasonById(Long id, String name, Integer status, Integer sort);

	public int insertOmsOrderReturnReason(String name, Integer status, Integer sort);
}
