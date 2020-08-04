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
import cn.com.sparknet.model.UmsAdmin;
import cn.com.sparknet.model.UmsMenu;
import cn.com.sparknet.model.UmsResource;
import cn.com.sparknet.model.UmsResourceCategory;
import cn.com.sparknet.service.UmsResourceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(tags = "UmsResourceController",description = "资源列表管理")
public class UmsResourceController {
	@Autowired
	private UmsResourceService resourceService;
	
	

    @ApiOperation("新增资源列表")
    @RequestMapping(value = "/UmsResource/insert",method = RequestMethod.POST)
    public CommonResult insertUmsResourceInfo(@RequestBody UmsResource umsResource ){
        int i = resourceService.insertUmsResourceInfo(umsResource);
        if(i>0){
            return  CommonResult.success(i);
        }
        return  CommonResult.failed("新增资源列表失败");

    }

    @ApiOperation("分页查询资源列表")
    @RequestMapping(value = "/UmsResource/selectByPage",method = RequestMethod.POST)
    public CommonResult selectUmsResourceByPage(@RequestParam(value = "pageNum" ,defaultValue = "1") Integer pageNum,
                                                            @RequestParam(value = "pageSize" ,defaultValue = "5") Integer pageSize,
                                                            @RequestParam(value = "name" ) String name,
                                                            @RequestParam(value = "url" ) String url,
                                                            @RequestParam(value = "categoryId" ) Long categoryId
    ){
        List<UmsResource> smsFlashPromotionSession = resourceService.selectUmsResourceByPage(pageNum, pageSize,name,url,categoryId);
        return  CommonResult.success(CommonPage.restPage(smsFlashPromotionSession));
    }
	
    @ApiOperation("删除资源")
    @RequestMapping(value = "/UmsResource/deleteById",method = RequestMethod.POST)
    public CommonResult deleteUmsResourceById(Long id
    ){
        int i = resourceService.deleteUmsResourceById(id);
        if(i>0){
            return  CommonResult.success(i);
        }
        return  CommonResult.failed("删除资源失败");
    }
	
    
	@ApiOperation("查询单个资源")
    @RequestMapping(value = "/UmsResource/selectById",method = RequestMethod.GET)
    public CommonResult selectUmsResourceById(@RequestParam("id")  Long id
    ){
		UmsResource umsResource = resourceService.selectUmsResourceById(id);
            return  CommonResult.success(umsResource);
    }
 
 
 @ApiOperation("修改资源")
    @RequestMapping(value = "/UmsResource/update",method = RequestMethod.GET)
    public CommonResult updateUmsResourceById(@RequestBody UmsResource umsResource
    ){
        int i = resourceService.updateUmsResourceById( umsResource);
        return  CommonResult.success(i);
    }
    

}
