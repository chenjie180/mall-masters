package cn.com.sparknet.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @author shkstart
 * @create 2020-07-27 21:11
 */
@Data
public class SmsFlashPromotionParam {
    private String title;

    @ApiModelProperty(value = "开始日期")
    private Date startDate;

    @ApiModelProperty(value = "结束日期")
    private Date endDate;

    @ApiModelProperty(value = "上下线状态")
    private Integer status;


}
