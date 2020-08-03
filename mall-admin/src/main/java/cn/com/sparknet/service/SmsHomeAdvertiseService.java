package cn.com.sparknet.service;

import cn.com.sparknet.model.SmsHomeAdvertise;

import java.util.List;

public interface SmsHomeAdvertiseService {

	public int insertSmsHomeAdvertiseInfo(SmsHomeAdvertise smsHomeAdvertise);

    public List<SmsHomeAdvertise> selectSmsHomeAdvertiseByPage(Integer pageNum, Integer pageSize, String name, Integer type, String endTime);

    public int deleteSmsHomeAdvertiseByIds(List<Long> ids);

    public int updateSmsHomeAdvertiseStatusByIds(Long id, int status);

    public SmsHomeAdvertise selectSmsHomeAdvertiseById(Long id);

    public int updateSmsHomeAdvertiseInfo(SmsHomeAdvertise smsHomeAdvertise);
}
