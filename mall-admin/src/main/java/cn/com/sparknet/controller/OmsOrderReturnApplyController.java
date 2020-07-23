package cn.com.sparknet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import cn.com.sparknet.service.OmsOrderReturnApplyService;
import io.swagger.annotations.Api;

@Api(tags = "OmsOrderReturnApplyController", description = "退货申请处理管理")
@RestController
public class OmsOrderReturnApplyController {
	@Autowired
	private OmsOrderReturnApplyService omsOrderReturnApplyService;

}
