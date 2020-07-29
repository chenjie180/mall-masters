package cn.com.sparknet.dto;

import cn.com.sparknet.model.PmsProduct;
import cn.com.sparknet.model.SmsFlashPromotionProductRelation;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
@Data
@EqualsAndHashCode(callSuper = false)
public class SmsFlashPromotionProductRelationReturn extends  SmsFlashPromotionProductRelation{
	
	@ApiModelProperty("商品信息")
	private PmsProduct product;

}
