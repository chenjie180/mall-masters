package cn.com.sparknet.controller;

import cn.com.sparknet.common.api.CommonResult;
import cn.com.sparknet.model.UmsRole;
import cn.com.sparknet.service.UmsRoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
}
