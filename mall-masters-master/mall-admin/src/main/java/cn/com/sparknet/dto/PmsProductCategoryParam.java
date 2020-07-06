package cn.com.sparknet.dto;

import cn.com.sparknet.volidator.FlagValidator;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.validator.constraints.Length;

import java.util.List;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@EqualsAndHashCode(callSuper = false)
public class PmsProductCategoryParam {
    @NotNull
    @Min(value = 0,message = "排序最小值为0")
    @ApiModelProperty(value = "上机分类的编号：0表示一级分类")
    private Long parentId;
    @NotNull//任意类型,验证注解的元素不是null
    @NotBlank
    @Length(min = 1,max = 64)
    private String name;
    @FlagValidator(value = {"0","1"},message = "")
    @ApiModelProperty(value = "分类级别：0->1级；1->2级")
    private Integer level;

    private Integer productCount;

    private String productUnit;

    @ApiModelProperty(value = "是否显示在导航栏：0->不显示；1->显示")
    private Integer navStatus;

    @ApiModelProperty(value = "显示状态：0->不显示；1->显示")
    private Integer showStatus;
    @Min(value = 0,message = "排序最小值为0")
    private Integer sort;

    @ApiModelProperty(value = "图标")
    private String icon;

    private String keywords;

    @ApiModelProperty(value = "描述")
    private String description;

    @ApiModelProperty(value = "筛选属性")
    private List<Long> productAttributeId;

}