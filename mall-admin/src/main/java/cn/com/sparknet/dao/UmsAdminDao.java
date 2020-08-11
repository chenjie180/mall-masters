package cn.com.sparknet.dao;

import cn.com.sparknet.model.UmsResource;

import java.util.List;

/**
 * @author shkstart
 * @create 2020-08-09 21:54
 */
public interface UmsAdminDao {

    public List<UmsResource> selectUserResource(Long id);
}
