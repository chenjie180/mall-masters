package cn.com.sparknet.controller;

import cn.com.sparknet.common.api.CommonPage;
import cn.com.sparknet.common.api.CommonResult;
import cn.com.sparknet.dto.PmsBrandParam;
import cn.com.sparknet.model.PmsBrand;
import cn.com.sparknet.service.PmsBrandService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author shkstart
 * @create 2020-07-03 14:18
 */
@Api(tags = "PmsBrandController", description = "商品品牌管理")
@RestController
public class PmsBrandController {
    @Autowired
    private PmsBrandService pmsBrandService;
//    @PreAuthorize("hasAuthority('pms:brand:read')")
    @ApiOperation("分页查询品牌集合")
    @RequestMapping(value = "brand/list",method = RequestMethod.POST)
    public CommonResult<CommonPage<PmsBrand>> selectBrandListbyPage(@RequestParam("name") String name,
                                                                    @RequestParam(value ="pageNum",defaultValue = "1") int pageNum,
                                                                    @RequestParam(value ="pageSize",defaultValue = "5") int pageSize){
        List<PmsBrand> pmsBrandList = pmsBrandService.selectBrandListbyPage(name, pageNum, pageSize);
        CommonResult<CommonPage<PmsBrand>> success = CommonResult.success(CommonPage.restPage(pmsBrandList));
        return success;
    }

    @ApiOperation("是否是品牌制造商")
    @RequestMapping(value = "brand/update/factoryStatus",method = RequestMethod.POST)
    public CommonResult  updateBrandFactoryStatus(@RequestParam("ids") List<Long> ids,
                                                  @RequestParam("factoryStatus") int factoryStatus){
        int i = pmsBrandService.updateBrandFactoryStatus(ids, factoryStatus);
        if(i>0){
            return  CommonResult.success(i);
        }else{
            return  CommonResult.failed("修改品牌制造商状态失败");
        }
    }

    @ApiOperation("是否是品牌制造商")
    @RequestMapping(value = "brand/update/showStatus",method = RequestMethod.POST)
    public CommonResult  updateBrandShowStatus(@RequestParam("ids") List<Long> ids,
                                               @RequestParam("showStatus") int showStatus){
        int i = pmsBrandService.updateBrandShowStatus(ids, showStatus);
        if(i>0){
            return  CommonResult.success(i);
        }else{
            return  CommonResult.failed("修改品牌制造商状态失败");
        }
    }


    @ApiOperation("通过id查询品牌信息")
    @RequestMapping(value = "brand/{id}",method = RequestMethod.POST)
    public CommonResult  selectBrandById(@PathVariable(name ="id" ) long id){
        PmsBrand pmsBrand = pmsBrandService.selectBrandById(id);
        return  CommonResult.success(pmsBrand);
    }

    @ApiOperation("通过id修改品牌信息")
    @RequestMapping(value = "brand/update/{id}",method = RequestMethod.POST)
    public CommonResult  updateBrandInfoById(@PathVariable(name ="id" ) long id,
                                             @Validated @RequestBody PmsBrandParam pmsBrandParam,
                                             BindingResult result){
        int i = 0;
        i = pmsBrandService.updateBrandInfoById(id, pmsBrandParam);
        if(i>0){
            return  CommonResult.success(i);
        }
        return  CommonResult.failed("通过id修改品牌信息失败");
    }


    @ApiOperation("新增品牌")
    @RequestMapping(value = "brand/insert",method = RequestMethod.POST)
    public CommonResult  insertBrand(@RequestBody PmsBrandParam pmsBrandParam,
                                     BindingResult result){
        int i = 0;
        i = pmsBrandService.insertBrand( pmsBrandParam);
        if(i>0){
            return  CommonResult.success(i);
        }
        return  CommonResult.failed("新增品牌失败");
    }

    @ApiOperation("删除品牌")
    @RequestMapping(value = "brand/delete",method = RequestMethod.POST)
    public CommonResult  deleteBrand(@RequestParam  List<Long> ids
    ){
        int i = 0;
        i = pmsBrandService.deleteBrand( ids);
        if(i>0){
            return  CommonResult.success(i);
        }
        return  CommonResult.failed("删除品牌失败");
    }

}
