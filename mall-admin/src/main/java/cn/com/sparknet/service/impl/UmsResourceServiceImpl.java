package cn.com.sparknet.service.impl;

import cn.com.sparknet.mapper.UmsResourceMapper;
import cn.com.sparknet.model.UmsResource;
import cn.com.sparknet.model.UmsResourceExample;
import cn.com.sparknet.service.UmsResourceService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;
@Service
public class UmsResourceServiceImpl implements UmsResourceService {
@Autowired
private UmsResourceMapper UmsResourceMapper;

@Override
public int insertUmsResourceInfo(UmsResource umsResource) {
	umsResource.setCreateTime(new Date());
	int insertSelective = UmsResourceMapper.insertSelective(umsResource);
	return insertSelective;
}

@Override
public List<UmsResource> selectUmsResourceByPage(Integer pageNum, Integer pageSize, String name, String url,
		Long categoryId) {
	  PageHelper.startPage(pageNum,pageSize);
	  UmsResourceExample umsAdminExample=new UmsResourceExample();
      if(!StringUtils.isEmpty(name)){
          umsAdminExample.createCriteria().andNameLike("%"+name+"%");
      }
      if(!StringUtils.isEmpty(url)){
          umsAdminExample.createCriteria().andUrlLike("%"+url+"%");
      }
      if(!StringUtils.isEmpty(url)){
          umsAdminExample.createCriteria().andCategoryIdEqualTo(categoryId);
      }
      List<UmsResource> umsAdmins = UmsResourceMapper.selectByExample(umsAdminExample);
      return umsAdmins;
}

@Override
public int deleteUmsResourceById(Long id) {
	int deleteByPrimaryKey = UmsResourceMapper.deleteByPrimaryKey(id);
	return deleteByPrimaryKey;
}

@Override
public UmsResource selectUmsResourceById(Long id) {
	UmsResource selectByPrimaryKey = UmsResourceMapper.selectByPrimaryKey(id);
	return selectByPrimaryKey;
}

@Override
public int updateUmsResourceById(UmsResource umsResource) {
	int updateByPrimaryKeySelective = UmsResourceMapper.updateByPrimaryKeySelective(umsResource);
	return updateByPrimaryKeySelective;
}

@Override
public List<UmsResource> selectUmsResourceselectAll(String name, String url, Long categoryId) {
	 UmsResourceExample umsAdminExample=new UmsResourceExample();
     if(!StringUtils.isEmpty(name)){
         umsAdminExample.createCriteria().andNameLike("%"+name+"%");
     }
     if(!StringUtils.isEmpty(url)){
         umsAdminExample.createCriteria().andUrlLike("%"+url+"%");
     }
     if(!StringUtils.isEmpty(url)){
         umsAdminExample.createCriteria().andCategoryIdEqualTo(categoryId);
     }
     List<UmsResource> umsAdmins = UmsResourceMapper.selectByExample(umsAdminExample);
     return umsAdmins;
}

    @Override
    public List<UmsResource> listAll() {
        return UmsResourceMapper.selectByExample(new UmsResourceExample());
    }


}
