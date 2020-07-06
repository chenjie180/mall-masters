package cn.com.sparknet.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotEmpty;

@Data
@EqualsAndHashCode
public class PmsProductAttributeCategoryParam {
	@NotEmpty
	 private String name;


}
