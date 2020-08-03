package cn.com.sparknet.controller;

import cn.com.sparknet.common.api.CommonPage;
import cn.com.sparknet.common.api.CommonResult;
import cn.com.sparknet.model.UmsAdmin;
import cn.com.sparknet.service.UmsAdminService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author shkstart
 * @create 2020-08-03 21:28
 */
@RestController
@Api(tags = "UmsAdminController",description = "用户管理")
public class UmsAdminController {

    @Autowired
    private UmsAdminService umsAdminService;

    @ApiOperation("新增用户")
    @RequestMapping(value = "/UmsAdmin/insert",method = RequestMethod.POST)
    public CommonResult insertUmsAdminInfo(@RequestBody UmsAdmin umsAdmin ){
        int i = umsAdminService.insertUmsAdminInfo(umsAdmin);
        if(i>0){
            return  CommonResult.success(i);
        }
        return  CommonResult.failed("新增用户失败");

    }

    @ApiOperation("分页查询用户列表")
    @RequestMapping(value = "/UmsAdmin/selectByPage",method = RequestMethod.POST)
    public CommonResult selectUmsAdminByPage(@RequestParam(value = "pageNum" ,defaultValue = "1") Integer pageNum,
                                                            @RequestParam(value = "pageSize" ,defaultValue = "5") Integer pageSize,
                                                            @RequestParam(value = "userName" )  String userName
    ){
        List<UmsAdmin> smsFlashPromotionSession = umsAdminService.selectUmsAdminByPage(pageNum, pageSize,userName);
        return  CommonResult.success(CommonPage.restPage(smsFlashPromotionSession));
    }

    @ApiOperation("删除用户")
    @RequestMapping(value = "/UmsAdmin/deleteById",method = RequestMethod.POST)
    public CommonResult deleteUmsAdminById(Long id
    ){
        int i = umsAdminService.deleteUmsAdminById(id);
        if(i>0){
            return  CommonResult.success(i);
        }
        return  CommonResult.failed("删除用户失败");
    }

    @ApiOperation("启用禁用用户状态")
    @RequestMapping(value = "/UmsAdmin/updateStatusById",method = RequestMethod.GET)
    public CommonResult updateUmsAdminStatusById(@RequestParam("id")  Long id,@RequestParam("status") int status
    ){
        int i = umsAdminService.updateUmsAdminStatusById(id,status);
        if(i>0){
            return  CommonResult.success(i);
        }
        return  CommonResult.failed("批量设为推荐/取消首页专题推荐列表失败");
    }


    @ApiOperation("查询单个用户信息")
    @RequestMapping(value = "/UmsAdmin/selectById",method = RequestMethod.GET)
    public CommonResult selectUmsAdminById(@RequestParam("id")  Long id
    ){
        UmsAdmin umsAdmin = umsAdminService.selectUmsAdminById(id);
            return  CommonResult.success(umsAdmin);
    }

    @ApiOperation("修改用户信息")
    @RequestMapping(value = "/UmsAdmin/update",method = RequestMethod.GET)
    public CommonResult updateUmsAdminById(@RequestBody UmsAdmin umsAdmin
    ){
        int i = umsAdminService.updateUmsAdminById( umsAdmin);
        return  CommonResult.success(umsAdmin);
    }


}
