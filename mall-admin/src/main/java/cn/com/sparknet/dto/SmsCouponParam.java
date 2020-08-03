package cn.com.sparknet.dto;

import java.util.List;

import cn.com.sparknet.model.SmsCoupon;
import cn.com.sparknet.model.SmsCouponProductCategoryRelation;
import cn.com.sparknet.model.SmsCouponProductRelation;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
@Data
@EqualsAndHashCode(callSuper =  false)
public class SmsCouponParam extends SmsCoupon {
	@ApiModelProperty("优惠券和商品的关系表")
	private List<SmsCouponProductRelation> couponProductRelationList;
	@ApiModelProperty("优惠券和商品分类关系表")
	private List<SmsCouponProductCategoryRelation> smsCouponProductCategoryRelationList;

}
