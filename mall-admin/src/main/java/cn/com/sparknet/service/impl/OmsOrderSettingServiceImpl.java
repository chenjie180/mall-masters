package cn.com.sparknet.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.sparknet.mapper.OmsOrderSettingMapper;
import cn.com.sparknet.model.OmsOrderSetting;
import cn.com.sparknet.model.OmsOrderSettingExample;
import cn.com.sparknet.service.OmsOrderSettingService;
@Service
public class OmsOrderSettingServiceImpl implements OmsOrderSettingService {

	@Autowired
	private OmsOrderSettingMapper omsOrderSettingMapper;
	
	@Override
	public List<OmsOrderSetting> selectOrderSettingInfo() {
		OmsOrderSettingExample omsOrderSettingExample=new OmsOrderSettingExample();
		List<OmsOrderSetting> selectByExample = omsOrderSettingMapper.selectByExample(omsOrderSettingExample);
		return selectByExample;
	}

}
