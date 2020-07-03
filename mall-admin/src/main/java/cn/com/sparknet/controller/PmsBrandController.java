package cn.com.sparknet.controller;

import cn.com.sparknet.common.api.CommonPage;
import cn.com.sparknet.common.api.CommonResult;
import cn.com.sparknet.model.PmsBrand;
import cn.com.sparknet.service.PmsBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author shkstart
 * @create 2020-07-03 14:18
 */
@RestController
public class PmsBrandController {
    @Autowired
    private PmsBrandService pmsBrandService;

    public CommonResult<CommonPage<PmsBrand>> selectBrandListbyPage(@RequestParam("name") String name,
                                                        @RequestParam(value ="pageNum",defaultValue = "1") int pageNum,
                                                        @RequestParam(value ="pageSize",defaultValue = "5") int pageSize){
        List<PmsBrand> pmsBrandList = pmsBrandService.selectBrandListbyPage(name, pageNum, pageSize);
        CommonResult<CommonPage<PmsBrand>> success = CommonResult.success(CommonPage.restPage(pmsBrandList));
        return success;
    }

}
