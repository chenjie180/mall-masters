package cn.com.sparknet.dto;

import java.math.BigDecimal;
import java.util.Date;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
@Data
@EqualsAndHashCode(callSuper = false)
public class PmsProductQueryParam {

	  private Long brandId;

	    private Long productCategoryId;

	   

	    private String name;

	    @ApiModelProperty(value = "货号")
	    private String productSn;

	   
	    @ApiModelProperty(value = "上架状态：0->下架；1->上架")
	    private Integer publishStatus;

	  
	    @ApiModelProperty(value = "审核状态：0->未审核；1->审核通过")
	    private Integer verifyStatus;


	   

	

}
