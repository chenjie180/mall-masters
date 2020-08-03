package cn.com.sparknet.service;

import cn.com.sparknet.model.UmsAdmin;

import java.util.List;

/**
 * @author shkstart
 * @create 2020-08-03 21:29
 */
public interface UmsAdminService {
    public  int insertUmsAdminInfo(UmsAdmin umsAdmin);

    public List<UmsAdmin> selectUmsAdminByPage(Integer pageNum, Integer pageSize, String userName);

    public int deleteUmsAdminById(Long id);

    public  int updateUmsAdminStatusById(Long id, int status);

    public UmsAdmin selectUmsAdminById(Long id);

    public int updateUmsAdminById(UmsAdmin umsAdmin);
}
