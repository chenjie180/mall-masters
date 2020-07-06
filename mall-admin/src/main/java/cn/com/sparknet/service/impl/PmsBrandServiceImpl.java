package cn.com.sparknet.service.impl;

import cn.com.sparknet.dto.PmsBrandParam;
import cn.com.sparknet.mapper.PmsBrandMapper;
import cn.com.sparknet.model.PmsBrand;
import cn.com.sparknet.model.PmsBrandExample;
import cn.com.sparknet.service.PmsBrandService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author shkstart
 * @create 2020-07-03 14:21
 */
@Service
public class PmsBrandServiceImpl implements PmsBrandService {

    @Autowired
    private PmsBrandMapper pmsBrandMapper;

    @Override
    public List<PmsBrand> selectBrandListbyPage(String name,int pageNum,int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        PmsBrandExample pmsBrandExample=new PmsBrandExample();
        pmsBrandExample.setOrderByClause("sort desc");//排序
        PmsBrandExample.Criteria criteria = pmsBrandExample.createCriteria();//代码补全快捷键alt+ctrl+v
    if(name!=null&!"".equals(name)){
        criteria.andNameLike("%"+name+"%");
    }
        List<PmsBrand> pmsBrandList= pmsBrandMapper.selectByExample(pmsBrandExample);
        return pmsBrandList;
    }

    @Override
    public int updateBrandFactoryStatus(List<Long> ids, int factoryStatus) {
        PmsBrand pmsBrand=new PmsBrand();
        pmsBrand.setFactoryStatus(factoryStatus);
        PmsBrandExample pmsBrandExample=new PmsBrandExample();
        pmsBrandExample.createCriteria().andIdIn(ids);
        int i = pmsBrandMapper.updateByExampleSelective(pmsBrand, pmsBrandExample);
        return i;
    }

    @Override
    public int updateBrandShowStatus(List<Long> ids, int showStatus) {
        PmsBrand pmsBrand=new PmsBrand();
        pmsBrand.setShowStatus(showStatus);
        PmsBrandExample pmsBrandExample=new PmsBrandExample();
        pmsBrandExample.createCriteria().andIdIn(ids);
        int i = pmsBrandMapper.updateByExampleSelective(pmsBrand, pmsBrandExample);
        return i;
    }

    @Override
    public PmsBrand selectBrandById(long id) {
        PmsBrand pmsBrand = pmsBrandMapper.selectByPrimaryKey(id);
        return pmsBrand;
    }

    @Override
    public int updateBrandInfoById(long id, PmsBrandParam pmsBrandParam) {
        PmsBrand pmsBrand =new PmsBrand();
        BeanUtils.copyProperties(pmsBrandParam,pmsBrand);
        pmsBrand.setId(id);
        PmsBrandExample pmsBrandExample=new PmsBrandExample();
        pmsBrandExample.createCriteria().andIdEqualTo(id);
        int i = pmsBrandMapper.updateByExampleSelective(pmsBrand, pmsBrandExample);
        return i;
    }

    @Override
    public int insertBrand(PmsBrandParam pmsBrandParam) {
        PmsBrand pmsBrand =new PmsBrand();
        BeanUtils.copyProperties(pmsBrandParam,pmsBrand);
        int insert = pmsBrandMapper.insert(pmsBrand);
        return insert;
    }

    @Override
    public int deleteBrand(List<Long> ids) {
        PmsBrandExample pmsBrandExample=new PmsBrandExample();
        pmsBrandExample.createCriteria().andIdIn(ids);
        int i = pmsBrandMapper.deleteByExample(pmsBrandExample);
        return i;
    }
}
