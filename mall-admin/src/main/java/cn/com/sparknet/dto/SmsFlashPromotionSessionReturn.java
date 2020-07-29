package cn.com.sparknet.dto;

import cn.com.sparknet.model.SmsFlashPromotionSession;
import lombok.Data;
import lombok.EqualsAndHashCode;
@Data
@EqualsAndHashCode(callSuper = false)
public class SmsFlashPromotionSessionReturn extends SmsFlashPromotionSession{
	private Long count;

}
