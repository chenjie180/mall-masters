package cn.com.sparknet.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class OmsOrderDeliveryParam {
	@ApiModelProperty("订单id")
	private Long id;
	@ApiModelProperty("物流公司")
	private String deliveryCompany;
	@ApiModelProperty("物流单号")
	private String deliverySn;

}
