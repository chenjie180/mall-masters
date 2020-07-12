package cn.com.sparknet.dto;

import java.util.Date;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
@Data
@EqualsAndHashCode(callSuper = false)
public class OmsOrderParam {
	
		@ApiModelProperty(value = "订单编号")
		private String orderSn;
	
	 	@ApiModelProperty(value = "收货人姓名")
	    private String receiverName;

	    @ApiModelProperty(value = "收货人电话")
	    private String receiverPhone;
	    
	    @ApiModelProperty(value = "提交时间")
	    private Date createTime;
	    
	    @ApiModelProperty(value = "订单id")
	    private Long id;
	    @ApiModelProperty(value = "订单来源：0->PC订单；1->app订单")
	    private Integer sourceType;

	    @ApiModelProperty(value = "订单状态：0->待付款；1->待发货；2->已发货；3->已完成；4->已关闭；5->无效订单")
	    private Integer status;

	   
}
