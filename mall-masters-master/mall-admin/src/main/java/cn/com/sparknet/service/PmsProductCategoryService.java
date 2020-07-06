package cn.com.sparknet.service;

import cn.com.sparknet.dto.PmsProductCategoryParam;
import cn.com.sparknet.model.PmsProductCategory;

import java.util.List;

/**
 * @author shkstart
 * @create 2020-07-05 13:30
 */
public interface PmsProductCategoryService {

  public List<PmsProductCategory> selectPmsProductCategoryByPage(long parentId,  int pageNum,int pageSize);


  int updatePmsProductCategoryNavStatusById(List<Long> ids, int navStatus);

  int updatePmsProductCategoryShowStatusById(List<Long> ids, int showStatus);

  int deletePmsProductCategoryById(Long id);

  int deleteBatchPmsProductCategoryByIds(List<Long> ids);

  int insertPmsProductCategoryInfo(PmsProductCategoryParam pmsProductCategoryParam);

  PmsProductCategory selectPmsProductCategoryInfoById(Long id);

  int updatePmsProductCategoryInfoById(Long id, PmsProductCategoryParam pmsProductCategoryParam);
}
