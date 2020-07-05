package cn.com.sparknet.service;

import cn.com.sparknet.dto.PmsBrandParam;
import cn.com.sparknet.model.PmsBrand;

import java.util.List;

/**
 * @author shkstart
 * @create 2020-07-03 14:19
 */
public interface PmsBrandService {

    public List<PmsBrand> selectBrandListbyPage(String name, int pageNum, int pageSize);

    public int updateBrandFactoryStatus(List<Long> ids, int factoryStatus);

    public int updateBrandShowStatus(List<Long> ids, int showStatus);

    PmsBrand selectBrandById(long id);

    int updateBrandInfoById(long id, PmsBrandParam pmsBrandParam);

    int insertBrand(PmsBrandParam pmsBrandParam);

    int deleteBrand(List<Long> ids);
}
