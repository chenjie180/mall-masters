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
import cn.com.sparknet.dto.UmsMenuNode;
import cn.com.sparknet.model.UmsAdmin;
import cn.com.sparknet.model.UmsMenu;
import cn.com.sparknet.model.UmsRole;
import cn.com.sparknet.service.UmsMenuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(tags = "UmsMenuController",description = "菜单管理")
public class UmsMenuController {
	
	@Autowired
	private UmsMenuService umsMenuService;

	
	@ApiOperation("新增菜单")
    @RequestMapping(value = "/UmsMenu/insert",method = RequestMethod.POST)
    public CommonResult insertUmsMenuInfo(@RequestBody UmsMenu umsMenu ){
        int i = umsMenuService.insertUmsMenuInfo(umsMenu);
        if(i>0){
            return  CommonResult.success(i);
        }
        return  CommonResult.failed("新增菜单失败");

    }
	
	
	 @ApiOperation("分页查询菜单列表")
	    @RequestMapping(value = "/UmsMenu/selectByPage",method = RequestMethod.POST)
	    public CommonResult selectUmsMenuByPage(@RequestParam(value = "pageNum" ,defaultValue = "1") Integer pageNum,
	                                                            @RequestParam(value = "pageSize" ,defaultValue = "5") Integer pageSize,
	                                                            @RequestParam(value = "parentId" ,defaultValue = "0") Long parentId
	    ){
	        List<UmsMenu> smsFlashPromotionSession = umsMenuService.selectUmsMenuByPage(pageNum, pageSize,parentId);
	        return  CommonResult.success(CommonPage.restPage(smsFlashPromotionSession));
	    }
	 
	 
	 @ApiOperation("是否显示菜单状态")
	    @RequestMapping(value = "/UmsMenu/updateHiddenById",method = RequestMethod.GET)
	    public CommonResult updateUmsMenuHiddenById(@RequestParam("id")  Long id,@RequestParam("hidden") int hidden
	    ){
	        int i = umsMenuService.updateUmsMenuHiddenById(id,hidden);
	        if(i>0){
	            return  CommonResult.success(i);
	        }
	        return  CommonResult.failed("批量设为推荐/取消首页专题推荐列表失败");
	    }
	 
	 
	 @ApiOperation("删除菜单")
	    @RequestMapping(value = "/UmsMenu/deleteById",method = RequestMethod.POST)
	    public CommonResult deleteUmsMenuById(Long id
	    ){
	        int i = umsMenuService.deleteUmsMenuById(id);
	        if(i>0){
	            return  CommonResult.success(i);
	        }
	        return  CommonResult.failed("删除菜单失败");
	    }

	 
	 @ApiOperation("查询单个菜单信息")
	    @RequestMapping(value = "/UmsMenu/selectById",method = RequestMethod.GET)
	    public CommonResult selectUmsMenuById(@RequestParam("id")  Long id
	    ){
		 UmsMenu umsMenu = umsMenuService.selectUmsMenuById(id);
	            return  CommonResult.success(umsMenu);
	    }
	 
	 
	 @ApiOperation("修改菜单信息")
	    @RequestMapping(value = "/UmsMenu/update",method = RequestMethod.GET)
	    public CommonResult updateUmsMenuById(@RequestBody UmsMenu umsMenu
	    ){
	        int i = umsMenuService.updateUmsMenuById( umsMenu);
	        return  CommonResult.success(i);
	    }
	 
	 
	 @ApiOperation("查询角色和菜单的绑定关系")
	    @RequestMapping(value = "/UmsMenu/selectTreeNode",method = RequestMethod.GET)
	    public CommonResult selectTreeNodeUmsMenu(
	    ){
	        List<UmsMenuNode> selectTreeNodeUmsMenu = umsMenuService.selectTreeNodeUmsMenu( );
	        return  CommonResult.success(selectTreeNodeUmsMenu);
	    }
	
}
