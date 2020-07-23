package cn.com.sparknet.dto;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.Data;
import lombok.EqualsAndHashCode;
@Data
@EqualsAndHashCode(callSuper = false)
public class OmsOrderReceiveParam {
	
	@ApiModelProperty("收货人姓名")
	private String receiverName;
	@ApiModelProperty("收货人电话")
	private String receiverPhone;
	@ApiModelProperty("收货人邮编")
	private String receiverPostCode;
	@ApiModelProperty("省份/直辖市")
	private String receiverProvince;
	@ApiModelProperty("城市")
	private String receiverCity;
	@ApiModelProperty("区")
	private String receiverRegion;
	@ApiModelProperty("详细地址")
	private String receiverDetailAddress;
	@ApiModelProperty("订单的id")
	private Long id;
	
}
