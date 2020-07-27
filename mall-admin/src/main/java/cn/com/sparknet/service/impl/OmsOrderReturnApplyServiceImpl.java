package cn.com.sparknet.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;

import cn.com.sparknet.dao.OmsOrderReturnApplyDao;
import cn.com.sparknet.dto.OmsOrderReturnApplyParam;
import cn.com.sparknet.dto.OmsUpdateStatusParam;
import cn.com.sparknet.mapper.OmsOrderReturnApplyMapper;
import cn.com.sparknet.model.OmsOrderReturnApply;
import cn.com.sparknet.model.OmsOrderReturnApplyExample;
import cn.com.sparknet.service.OmsOrderReturnApplyService;
@Service
public class OmsOrderReturnApplyServiceImpl implements OmsOrderReturnApplyService{
	@Autowired
	private OmsOrderReturnApplyDao omsOrderReturnApplyDao;
	@Autowired
	private OmsOrderReturnApplyMapper omsOrderReturnApplyMapper;
	
	public List<OmsOrderReturnApply> selectOmsOrderReturnApplyByPage(OmsOrderReturnApplyParam omsOrderReturnApplyParam,int pageNum,int pageSize){
		PageHelper.startPage(pageNum, pageSize);
		List<OmsOrderReturnApply> selectOmsOrderReturnApplyByPage = omsOrderReturnApplyDao.selectOmsOrderReturnApplyByPage(omsOrderReturnApplyParam);
		return  selectOmsOrderReturnApplyByPage;
	}

	@Override
	public int deleteOmsOrderReturnApplyByIds(List<Long> ids) {
		OmsOrderReturnApplyExample example=new OmsOrderReturnApplyExample();
		example.createCriteria().andIdIn(ids);
		int deleteByExample = omsOrderReturnApplyMapper.deleteByExample(example);
		return deleteByExample;
	}

	@Override
	public OmsOrderReturnApply selectOmsOrderReturnApplyById(Long id) {
		OmsOrderReturnApply selectByPrimaryKey = omsOrderReturnApplyMapper.selectByPrimaryKey(id);
		return selectByPrimaryKey;
	}

	

	@Override
	public int updateOmsOrderReturnApplyStatus(Long id, OmsUpdateStatusParam omsUpdateStatusParam) {
		omsUpdateStatusParam.setId(id);
		OmsOrderReturnApply record=new OmsOrderReturnApply();
		if("1".equals(omsUpdateStatusParam.getStatus())) {
			BeanUtils.copyProperties(omsUpdateStatusParam, record);
			record.setReceiveTime(new Date());
		}if("3".equals(omsUpdateStatusParam.getStatus())) {
			record.setId(id);
			record.setStatus(3);
	        record.setHandleTime(new Date());
	        record.setHandleMan(omsUpdateStatusParam.getHandleMan());
	        record.setHandleNote(omsUpdateStatusParam.getHandleNote());
		}
		if("2".equals(omsUpdateStatusParam.getStatus())) {
			record.setId(id);
			record.setStatus(2);
	        record.setHandleTime(new Date());
	        record.setHandleMan(omsUpdateStatusParam.getHandleMan());
	        record.setHandleNote(omsUpdateStatusParam.getHandleNote());
		}
		
		
		
		int updateByPrimaryKeySelective = omsOrderReturnApplyMapper.updateByPrimaryKeySelective(record);
		return  updateByPrimaryKeySelective;
	}

}
