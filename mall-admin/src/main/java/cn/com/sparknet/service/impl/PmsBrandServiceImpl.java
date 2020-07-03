package cn.com.sparknet.service.impl;

import cn.com.sparknet.common.api.CommonResult;
import cn.com.sparknet.mapper.PmsBrandMapper;
import cn.com.sparknet.model.PmsBrand;
import cn.com.sparknet.model.PmsBrandExample;
import cn.com.sparknet.service.PmsBrandService;
import com.github.pagehelper.PageHelper;
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
}
