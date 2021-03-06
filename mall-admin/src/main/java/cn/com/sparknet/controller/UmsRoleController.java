package cn.com.sparknet.controller;

import cn.com.sparknet.common.api.CommonPage;
import cn.com.sparknet.common.api.CommonResult;
import cn.com.sparknet.model.UmsAdmin;
import cn.com.sparknet.model.UmsMenu;
import cn.com.sparknet.model.UmsResource;
import cn.com.sparknet.model.UmsRole;
import cn.com.sparknet.service.UmsRoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author shkstart
 * @create 2020-08-03 21:59
 */
@RestController
@Api(tags = "UmsRoleController",description = "角色管理")
public class UmsRoleController {
@Autowired
private UmsRoleService umsRoleService;

    @ApiOperation("新增角色")
    @RequestMapping(value = "/UmsRole/insert",method = RequestMethod.POST)
    public CommonResult insertUmsRoleInfo(@RequestBody UmsRole umsRole ){
        int i = umsRoleService.insertUmsRoleInfo(umsRole);
        if(i>0){
            return  CommonResult.success(i);
        }
        return  CommonResult.failed("新增用户失败");

    }

    @ApiOperation("分页查询角色列表")
    @RequestMapping(value = "/UmsRole/selectByPage",method = RequestMethod.POST)
    public CommonResult selectUmsRoleByPage(@RequestParam(value = "pageNum" ,defaultValue = "1") Integer pageNum,
                                                            @RequestParam(value = "pageSize" ,defaultValue = "5") Integer pageSize,
                                                            @RequestParam(value = "name" )  String name
    ){
        List<UmsRole> smsFlashPromotionSession = umsRoleService.selectUmsRoleByPage(pageNum, pageSize,name);
        return  CommonResult.success(CommonPage.restPage(smsFlashPromotionSession));
    }

    
    @ApiOperation("通过角色id查询资源列表")
    @RequestMapping(value = "/UmsRole/selectResourceById",method = RequestMethod.POST)
    public CommonResult selectResourceById(
                                                            @RequestParam(value = "roleId" )  Long roleId
    ){
        List<UmsResource> smsFlashPromotionSession = umsRoleService.selectResourceById(roleId);
        return  CommonResult.success(CommonPage.restPage(smsFlashPromotionSession));
    }
    
    
    @ApiOperation("通过角色id查询菜单列表")
    @RequestMapping(value = "/UmsRole/selectMenuById",method = RequestMethod.POST)
    public CommonResult selectMenuById(
                                                            @RequestParam(value = "roleId" )  Long roleId
    ){
        List<UmsMenu> smsFlashPromotionSession = umsRoleService.selectMenuById(roleId);
        return  CommonResult.success(CommonPage.restPage(smsFlashPromotionSession));
    }
    
    
    @ApiOperation("角色绑定资源列表")
    @RequestMapping(value = "/UmsRole/roleIdBingResourceById",method = RequestMethod.POST)
    public CommonResult roleIdBingResourceById(
                                                            @RequestParam(value = "roleId" )  Long roleId,@RequestParam("resources") List<Long> resources
    ){
        int roleIdBingResourceById = umsRoleService.roleIdBingResourceById(roleId,resources);
        if(roleIdBingResourceById>0){
            return  CommonResult.success(roleIdBingResourceById);
        }
        return  CommonResult.failed("角色绑定资源列表失败");
    }

    @ApiOperation("角色绑定菜单列表")
    @RequestMapping(value = "/UmsRole/roleIdBingMenuById",method = RequestMethod.POST)
    public CommonResult roleIdBingMenuById(
                                                            @RequestParam(value = "roleId" )  Long roleId,@RequestParam("menuId") List<Long> menuId
    ){
        int roleIdBingResourceById = umsRoleService.roleIdBingMenuById(roleId,menuId);
        if(roleIdBingResourceById>0){
            return  CommonResult.success(roleIdBingResourceById);
        }
        return  CommonResult.failed("角色绑定菜单失败");
    }



}
