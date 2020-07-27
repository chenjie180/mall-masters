package cn.com.sparknet.dto;

import java.math.BigDecimal;
import java.util.Date;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class OmsOrderReturnApplyParam {
	
	private Long id;

	@ApiModelProperty(value = "申请状态：0->待处理；1->退货中；2->已完成；3->已拒绝")
    private Integer status;
	 @ApiModelProperty(value = "处理时间")
	    private String handleTime;
    @ApiModelProperty(value = "申请时间")
    private String createTime;

    @ApiModelProperty(value = "处理人员")
    private String handleMan;

   

    @ApiModelProperty(value = "退货人姓名")
    private String returnName;

    @ApiModelProperty(value = "退货人电话")
    private String returnPhone;

    
	
}
