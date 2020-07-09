package cn.com.sparknet.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.com.sparknet.dto.PmsProductParam;
import cn.com.sparknet.dto.PmsProductQueryParam;

public interface PmsproductDao {

		List<PmsProductParam>  selectPmsProductByProductId(@Param(value = "id") long id);
}
