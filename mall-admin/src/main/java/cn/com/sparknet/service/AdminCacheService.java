package cn.com.sparknet.service;

import cn.com.sparknet.model.UmsAdmin;
import cn.com.sparknet.model.UmsResource;

import java.util.List;

/**
 * @author shkstart
 * @create 2020-08-09 21:18
 */
public interface AdminCacheService {
    public UmsAdmin getAdmin(String username);

    public void setAdmin(UmsAdmin umsAdmin);

    public List<UmsResource> getResource(Long id);

    public void setResource(Long id, List<UmsResource> umsResources);
}
