package cn.com.sparknet.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;

import cn.com.sparknet.dao.OmsOrderReturnApplyDao;
import cn.com.sparknet.dto.OmsOrderReturnApplyParam;
import cn.com.sparknet.model.OmsOrderReturnApply;
import cn.com.sparknet.service.OmsOrderReturnApplyService;
@Service
public class OmsOrderReturnApplyServiceImpl implements OmsOrderReturnApplyService{
	@Autowired
	private OmsOrderReturnApplyDao omsOrderReturnApplyDao;
	
	public List<OmsOrderReturnApply> selectOmsOrderReturnApplyByPage(OmsOrderReturnApplyParam omsOrderReturnApplyParam,int pageNum,int pageSize){
		PageHelper.startPage(pageNum, pageSize);
		List<OmsOrderReturnApply> selectOmsOrderReturnApplyByPage = omsOrderReturnApplyDao.selectOmsOrderReturnApplyByPage(omsOrderReturnApplyParam);
		return  selectOmsOrderReturnApplyByPage;
	}

}
