package cn.com.sparknet.service.impl;

import cn.com.sparknet.mall.security.service.RedisService;
import cn.com.sparknet.model.UmsAdmin;
import cn.com.sparknet.model.UmsResource;
import cn.com.sparknet.service.AdminCacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author shkstart
 * @create 2020-08-09 21:18
 */
@Service
public class AdminCacheServiceImpl implements AdminCacheService {
    @Value("${redis.database}")
    private String REDIS_DATABASE;
    @Value("${redis.expire.common}")
    private Long REDIS_EXPIRE;
    @Value("${redis.key.admin}")
    private String REDIS_KEY_ADMIN;
    @Value("${redis.key.resourceList}")
    private String REDIS_KEY_RESOURCE_LIST;
@Autowired
private RedisService redisService;


    @Override
    public UmsAdmin getAdmin(String username) {
        String key = REDIS_DATABASE + ":" + REDIS_KEY_ADMIN + ":" + username;
        UmsAdmin o = (UmsAdmin) redisService.get(key);
        return o;
    }

    @Override
    public void setAdmin(UmsAdmin umsAdmin) {
        String key = REDIS_DATABASE + ":" + REDIS_KEY_ADMIN + ":" + umsAdmin.getUsername();
        redisService.set(key,umsAdmin);
    }

    @Override
    public List<UmsResource> getResource(Long id) {
        String key = REDIS_DATABASE + ":" + REDIS_KEY_RESOURCE_LIST + ":" + id;
        List<UmsResource> o = (List<UmsResource>) redisService.get(key);
        return o;
    }

    @Override
    public void setResource(Long id,List<UmsResource> umsResourceList) {
        String key = REDIS_DATABASE + ":" + REDIS_KEY_RESOURCE_LIST + ":" + id;
        redisService.set(key,umsResourceList);
    }
}
