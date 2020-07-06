package cn.com.sparknet.controller;

import cn.com.sparknet.common.api.CommonPage;
import cn.com.sparknet.common.api.CommonResult;
import cn.com.sparknet.dto.PmsProductCategoryParam;
import cn.com.sparknet.model.PmsProductCategory;
import cn.com.sparknet.service.PmsProductCategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author shkstart
 * @create 2020-07-05 13:29
 */
@RestController
@Api(description = "商品分类管理",tags = "PmsProductCategoryController")
public class PmsProductCategoryController {

    @Autowired
    private PmsProductCategoryService pmsProductCategoryService;

    @ApiOperation(value = "分页通过parentId查询商品分类")
    @RequestMapping(value = "/pmsProductCategory/select/{parentId}",method = RequestMethod.POST)
    public CommonResult selectPmsProductCategoryByParentId(@PathVariable(name ="parentId" ) long parentId,
                                                           @RequestParam(defaultValue = "1",name = "pageNum") int pageNum,
                                                           @RequestParam(defaultValue = "5",name = "pageSize") int pageSize){
        List<PmsProductCategory> pmsProductCategories = pmsProductCategoryService.selectPmsProductCategoryByPage(parentId, pageNum, pageSize);
        if(StringUtils.isEmpty(pmsProductCategories)){
          return   CommonResult.failed("查询失败");
        }else{
          return   CommonResult.success(CommonPage.restPage(pmsProductCategories));
        }
    }


    @ApiOperation(value = "修改商品分类导航栏状态")
    @RequestMapping(value = "/pmsProductCategory/updateNavStatus",method = RequestMethod.POST)
    public CommonResult updatePmsProductCategoryNavStatusById(@RequestParam(name ="id" ) List<Long> ids,
                                                           @RequestParam(name = "navStatus") int navStatus
                                                           ){
        int i = pmsProductCategoryService.updatePmsProductCategoryNavStatusById(ids, navStatus);
        if(i>0){
            return   CommonResult.success(i);
        }else{
            return   CommonResult.failed("修改失败");
        }
    }

    @ApiOperation(value = "修改商品分类显示状态")
    @RequestMapping(value = "/pmsProductCategory/updateShowStatus",method = RequestMethod.POST)
    public CommonResult updatePmsProductCategoryShowStatusById(@RequestParam(name ="id" ) List<Long> ids,
                                                              @RequestParam(name = "showStatus") int showStatus
    ){
        int i = pmsProductCategoryService.updatePmsProductCategoryShowStatusById(ids, showStatus);
        if(i>0){
            return   CommonResult.success(i);
        }else{
            return   CommonResult.failed("修改失败");
        }
    }



    @ApiOperation(value = "批量删除商品分类")
    @RequestMapping(value = "/pmsProductCategory/deleteBatch/{ids}",method = RequestMethod.POST)
    public CommonResult deleteBatchPmsProductCategoryByIds(@PathVariable(value ="ids") List<Long> ids){
        int i = pmsProductCategoryService.deleteBatchPmsProductCategoryByIds(ids);
        if(i>0){
            return   CommonResult.success(i);
        }else{
            return   CommonResult.failed("修改失败");
        }
    }
    @ApiOperation(value = "删除商品分类")
    @RequestMapping(value = "/pmsProductCategory/delete/{id}",method = RequestMethod.POST)
    public CommonResult deletePmsProductCategoryByIds(@PathVariable(value ="id") Long id){
        int i = pmsProductCategoryService.deletePmsProductCategoryById(id);
        if(i>0){
            return   CommonResult.success(i);
        }else{
            return   CommonResult.failed("修改失败");
        }
    }

    @ApiOperation(value = "新增商品分类")
    @RequestMapping(value = "/pmsProductCategory/insert",method = RequestMethod.POST)
    public CommonResult insertPmsProductCategoryInfo(@RequestBody PmsProductCategoryParam pmsProductCategoryParam){
        int i = pmsProductCategoryService.insertPmsProductCategoryInfo(pmsProductCategoryParam);
        if(i>0){
            return   CommonResult.success(i);
        }else{
            return   CommonResult.failed("修改失败");
        }
    }


    @ApiOperation(value = "通过id查询商品分类信息")
    @RequestMapping(value = "/pmsProductCategory/{id}",method = RequestMethod.POST)
    public CommonResult selectPmsProductCategoryInfoById(@PathVariable(value ="id") Long id){
        PmsProductCategory pmsProductCategory = pmsProductCategoryService.selectPmsProductCategoryInfoById(id);
       System.out.println(pmsProductCategory);
        if(StringUtils.isEmpty(pmsProductCategory)){
            return   CommonResult.failed("查询失败");
        }else{
            return   CommonResult.success(pmsProductCategory);
        }
    }


    @ApiOperation(value = "修改商品分类")
    @RequestMapping(value = "/pmsProductCategory/update/{id}",method = RequestMethod.POST)
    public CommonResult updatePmsProductCategoryInfoById(@PathVariable(value ="id") Long id,
                                                         @RequestBody PmsProductCategoryParam pmsProductCategoryParam){
        int i = pmsProductCategoryService.updatePmsProductCategoryInfoById(id, pmsProductCategoryParam);
        if(i>1){
            return   CommonResult.success(i);
        }else{
            return   CommonResult.failed("修改失败");
        }
    }

}
