package cn.com.sparknet.dto;

import java.util.List;

import cn.com.sparknet.model.PmsProductAttribute;
import cn.com.sparknet.model.PmsProductAttributeCategory;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class PmsProductAttributeCategoryItem extends PmsProductAttributeCategory {

	List<PmsProductAttribute> pmsProductAttributeList;
}
