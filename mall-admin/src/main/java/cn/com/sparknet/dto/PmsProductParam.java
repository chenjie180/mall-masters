package cn.com.sparknet.dto;

import java.util.List;

import cn.com.sparknet.model.CmsPrefrenceAreaProductRelation;
import cn.com.sparknet.model.CmsSubjectProductRelation;
import cn.com.sparknet.model.PmsMemberPrice;
import cn.com.sparknet.model.PmsProduct;
import cn.com.sparknet.model.PmsProductAttributeValue;
import cn.com.sparknet.model.PmsProductFullReduction;
import cn.com.sparknet.model.PmsProductLadder;
import cn.com.sparknet.model.PmsSkuStock;
import lombok.Data;
import lombok.EqualsAndHashCode;
@Data
@EqualsAndHashCode(callSuper = false)
public class PmsProductParam extends PmsProduct {
	
	List<PmsMemberPrice> pmsMemberPriceList;
	
	List<PmsProductFullReduction> pmsProductFullReductionList;
	
	List<PmsProductLadder> PmsProductLadderList;
	
	List<PmsSkuStock> PmsSkuStockList;
	
	List<PmsProductAttributeValue> pmsProductAttributeValueList;
	
	List<CmsSubjectProductRelation> cmsSubjectProductRelationList;
	
	List<CmsPrefrenceAreaProductRelation>  cmsPrefrenceAreaProductRelationList;
}
