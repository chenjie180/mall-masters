package cn.com.sparknet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.com.sparknet.common.api.CommonPage;
import cn.com.sparknet.common.api.CommonResult;
import cn.com.sparknet.model.UmsMenu;
import cn.com.sparknet.model.UmsResourceCategory;
import cn.com.sparknet.service.UmsResourceCategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(tags = "UmsResourceCategoryController",description = "资源分类管理")
public class UmsResourceCategoryController {
	@Autowired
	private UmsResourceCategoryService umsResourceCategoryService;
	
	@ApiOperation("新增资源分类")
    @RequestMapping(value = "/UmsResourceCategory/insert",method = RequestMethod.POST)
    public CommonResult insertUmsResourceCategoryInfo(@RequestBody UmsResourceCategory umsResourceCategory ){
        int i = umsResourceCategoryService.insertUmsResourceCategoryInfo(umsResourceCategory);
        if(i>0){
            return  CommonResult.success(i);
        }
        return  CommonResult.failed("新增菜单失败");

    }
	
	
	@ApiOperation("查询资源分类列表")
    @RequestMapping(value = "/UmsResourceCategory/selectList",method = RequestMethod.POST)
    public CommonResult selectUUmsResourceCategoryList(
    ){
        List<UmsResourceCategory> smsFlashPromotionSession = umsResourceCategoryService.selectUUmsResourceCategoryList();
        return  CommonResult.success(CommonPage.restPage(smsFlashPromotionSession));
    }
	
	@ApiOperation("删除资源分类")
    @RequestMapping(value = "/UmsResourceCategory/deleteById",method = RequestMethod.POST)
    public CommonResult deleteUmsResourceCategoryById(Long id
    ){
        int i = umsResourceCategoryService.deleteUmsResourceCategoryById(id);
        if(i>0){
            return  CommonResult.success(i);
        }
        return  CommonResult.failed("删除资源分类失败");
    }
	
	@ApiOperation("查询单个资源分类")
    @RequestMapping(value = "/UmsResourceCategory/selectById",method = RequestMethod.GET)
    public CommonResult selectUmsResourceCategoryById(@RequestParam("id")  Long id
    ){
		UmsResourceCategory umsResourceCategory = umsResourceCategoryService.selectUmsResourceCategoryById(id);
            return  CommonResult.success(umsResourceCategory);
    }
 
 
 @ApiOperation("修改资源分类")
    @RequestMapping(value = "/UmsResourceCategory/update",method = RequestMethod.GET)
    public CommonResult updateUmsResourceCategoryById(@RequestBody UmsResourceCategory umsResourceCategory
    ){
        int i = umsResourceCategoryService.updateUmsResourceCategoryById( umsResourceCategory);
        return  CommonResult.success(i);
    }
	
	

}
