package cn.com.sparknet.dto;

import javax.validation.constraints.NotEmpty;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class PmsProductAttributeCategoryParam {
	@NotEmpty
	 private String name;


}
