package cn.com.sparknet.dto;

import cn.com.sparknet.model.SmsFlashPromotionSession;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
public class SmsFlashPromotionSessionReturn extends SmsFlashPromotionSession{
    @Setter
    @Getter
    @ApiModelProperty("商品数量")
    private Long productCount;

}
