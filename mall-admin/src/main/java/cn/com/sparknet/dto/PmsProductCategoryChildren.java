package cn.com.sparknet.dto;

import java.util.List;

import cn.com.sparknet.model.PmsProductCategory;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class PmsProductCategoryChildren extends PmsProductCategory {

	
	List<PmsProductCategory>  children;
}
