package cn.com.sparknet.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;

import cn.com.sparknet.mapper.OmsOrderReturnApplyMapper;
import cn.com.sparknet.mapper.OmsOrderReturnReasonMapper;
import cn.com.sparknet.model.OmsOrderReturnReason;
import cn.com.sparknet.model.OmsOrderReturnReasonExample;
import cn.com.sparknet.service.OmsOrderReturnReasonService;
@Service
public class OmsOrderReturnReasonServiceImpl implements OmsOrderReturnReasonService {

	@Autowired
	private OmsOrderReturnReasonMapper omsOrderReturnReasonMapper;
	
	@Override
	public List<OmsOrderReturnReason> selectOmsOrderReturnReasonListByPage(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		OmsOrderReturnReasonExample example=new OmsOrderReturnReasonExample();
		List<OmsOrderReturnReason> selectByExample = omsOrderReturnReasonMapper.selectByExample(example);
		return selectByExample;
	}

	@Override
	public int updateOmsOrderReturnReasonStatusById(Long id, int status) {
		OmsOrderReturnReason record=new OmsOrderReturnReason();
		record.setStatus(status);
		record.setId(id);
		int updateByPrimaryKeySelective = omsOrderReturnReasonMapper.updateByPrimaryKeySelective(record);
		return updateByPrimaryKeySelective;
	}

	@Override
	public int deleteOmsOrderReturnReasonByIds(List<Long> ids) {
		OmsOrderReturnReasonExample example=new OmsOrderReturnReasonExample();
		example.createCriteria().andIdIn(ids);
		int deleteByExample = omsOrderReturnReasonMapper.deleteByExample(example);
		return deleteByExample;
	}

	@Override
	public OmsOrderReturnReason selectOmsOrderReturnReasonById(Long id) {
		OmsOrderReturnReason selectByPrimaryKey = omsOrderReturnReasonMapper.selectByPrimaryKey(id);	
		return selectByPrimaryKey;
	}

	@Override
	public int updateOmsOrderReturnReasonById(Long id, String name, Integer status, Integer sort) {
		OmsOrderReturnReason record=new OmsOrderReturnReason();
		record.setCreateTime(new Date());
		record.setId(id);
		record.setName(name);
		record.setSort(sort);
		record.setStatus(status);
		int updateByPrimaryKey = omsOrderReturnReasonMapper.updateByPrimaryKey(record);
		return updateByPrimaryKey;
	}

	@Override
	public int insertOmsOrderReturnReason(String name, Integer status, Integer sort) {
		OmsOrderReturnReason record=new OmsOrderReturnReason();
		record.setCreateTime(new Date());
		record.setName(name);
		record.setSort(sort);
		record.setStatus(status);
		int insertSelective = omsOrderReturnReasonMapper.insertSelective(record);
		return insertSelective;
	}

}
