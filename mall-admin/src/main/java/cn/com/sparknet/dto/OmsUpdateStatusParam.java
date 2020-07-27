package cn.com.sparknet.dto;

import java.math.BigDecimal;
import java.util.Date;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class OmsUpdateStatusParam {
	@ApiModelProperty("id")
	public Long id;
	@ApiModelProperty("收货地址表id")
	public Long companyAddressId;
	@ApiModelProperty("处理备注")
	public String handleNote;
	@ApiModelProperty("处理人员")
	public String handleMan;
	@ApiModelProperty("收货人")
	public String receiveMan;
	@ApiModelProperty("收货时间")
	public Date receiveTime;
	@ApiModelProperty("收货备注")
	public String receiveNote;
	@ApiModelProperty("申请状态：0->待处理；1->退货中；2->已完成；3->已拒绝")
	public Integer status;
	@ApiModelProperty(value = "退款金额")
    private BigDecimal returnAmount;

}
