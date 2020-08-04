package cn.com.sparknet.dto;

import java.util.List;

import cn.com.sparknet.model.UmsMenu;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
@Data
@EqualsAndHashCode(callSuper = false)
public class UmsMenuNode extends UmsMenu {

	@ApiModelProperty("孩子节点")
	private List<UmsMenuNode> children;
	
}
