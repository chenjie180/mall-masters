package cn.com.sparknet.service;

import cn.com.sparknet.common.api.CommonResult;
import cn.com.sparknet.model.PmsBrand;

import java.util.List;

/**
 * @author shkstart
 * @create 2020-07-03 14:19
 */
public interface PmsBrandService {

    public List<PmsBrand> selectBrandListbyPage(String name, int pageNum, int pageSize);
}
