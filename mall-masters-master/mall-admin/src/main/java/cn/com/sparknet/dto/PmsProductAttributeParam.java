package cn.com.sparknet.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import cn.com.sparknet.volidator.FlagValidator;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
@Data
@EqualsAndHashCode
public class PmsProductAttributeParam {
		@NotNull(message = "属性分类不能为空")
	   private Long productAttributeCategoryId;
		@NotBlank(message = "属性分类不能为空")
		@Length(min = 1,max = 5)
	    private String name;
		@FlagValidator(value = {"0","1","2"}, message = "属性选择类型不正确")
	    @ApiModelProperty(value = "属性选择类型：0->唯一；1->单选；2->多选")
	    private Integer selectType;
		@FlagValidator(value = {"0","1"}, message = "属性录入方式不正确")
	    @ApiModelProperty(value = "属性录入方式：0->手工录入；1->从列表中选取")
	    private Integer inputType;
		@Length(min = 1,max = 255)
	    @ApiModelProperty(value = "可选值列表，以逗号隔开")
	    private String inputList;

	    @ApiModelProperty(value = "排序字段：最高的可以单独上传图片")
	    private Integer sort;
	    @FlagValidator(value = {"0","1"}, message = "分类筛选样式不正确")
	    @ApiModelProperty(value = "分类筛选样式：1->普通；1->颜色")
	    private Integer filterType;
	    @FlagValidator(value = {"0","1","2"}, message = "检索类型不正确")

	    @ApiModelProperty(value = "检索类型；0->不需要进行检索；1->关键字检索；2->范围检索")
	    private Integer searchType;
	    @FlagValidator(value = {"0","1"}, message = "相同属性产品不正确")
	    @ApiModelProperty(value = "相同属性产品是否关联；0->不关联；1->关联")
	    private Integer relatedStatus;
	    
	    @FlagValidator(value = {"0","1"}, message = "是否支持手动新增不正确")
	    @ApiModelProperty(value = "是否支持手动新增；0->不支持；1->支持")
	    private Integer handAddStatus;
	    
	    @FlagValidator(value = {"0","1"}, message = "属性的类型不正确")
	    @ApiModelProperty(value = "属性的类型；0->规格；1->参数")
	    private Integer type;

}
