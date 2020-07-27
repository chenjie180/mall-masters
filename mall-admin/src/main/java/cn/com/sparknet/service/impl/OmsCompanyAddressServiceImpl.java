package cn.com.sparknet.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.sparknet.mapper.OmsCompanyAddressMapper;
import cn.com.sparknet.model.OmsCompanyAddress;
import cn.com.sparknet.model.OmsCompanyAddressExample;
import cn.com.sparknet.service.OmsCompanyAddressService;
@Service
public class OmsCompanyAddressServiceImpl implements OmsCompanyAddressService {
	@Autowired
	private OmsCompanyAddressMapper companyAddressMapper;
	
	

	@Override
	public List<OmsCompanyAddress> selectOmsCompanyAddressList() {
		OmsCompanyAddressExample example=new OmsCompanyAddressExample();
		List<OmsCompanyAddress> selectByExample = companyAddressMapper.selectByExample(example);
		return selectByExample;
	}

	

	
}
