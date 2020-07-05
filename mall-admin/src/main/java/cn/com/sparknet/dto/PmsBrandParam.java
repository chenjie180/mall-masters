package cn.com.sparknet.dto;

import cn.com.sparknet.volidator.FlagValidator;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data//提供get,set方法
@EqualsAndHashCode(callSuper = false)//重写equal和hashcode方法，重新equal比较的是hash值，callSuper = false我们做hash比较的时候，比较的是自身的hash，如果和父类的无关
public class PmsBrandParam {

    @NotNull//任意类型,验证注解的元素不是null
    @NotBlank
    @Length(min = 1,max = 64)
    private String name;
    @Length(max = 8)
    private String firstLetter;
@Min(value = 0,message = "排序最小值为0")
    private Integer sort;
    @FlagValidator(value = {"0","1"}, message = "厂家状态不正确")
    private Integer factoryStatus;
    @FlagValidator(value = {"0","1"}, message = "显示状态不正确")
    private Integer showStatus;
    @Min(value = 0,message = "最小值为0")
    private Integer productCount;
    @Min(value = 0,message = "最小值为0")
    private Integer productCommentCount;
    @Length(max = 255)
    private String logo;
    @Length(max = 255)
    private String bigPic;

    private String brandStory;


}