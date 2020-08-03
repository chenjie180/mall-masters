package cn.com.sparknet.service;

import java.util.List;

import cn.com.sparknet.model.SmsHomeBrand;

public interface SmsHomeBrandService {

	public int insertSmsFlashPromotionSessionInfo(SmsHomeBrand smsHomeBrand);

	public List<SmsHomeBrand> selectSmsHomeBrandByPage(Integer pageNum, Integer pageSize, String brandName,
			Integer recommendStatus);

	public int deleteSmsHomeBrandByIds(List<Long> ids);

	public int updateSmsHomeBrandStatusByIds(List<Long> ids, int recommendStatus);

	public int updateSmsHomeBrandSortById(Long id, int sort);

}
