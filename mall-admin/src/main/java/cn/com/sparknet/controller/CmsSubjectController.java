package cn.com.sparknet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.com.sparknet.common.api.CommonResult;
import cn.com.sparknet.model.CmsSubject;
import cn.com.sparknet.service.CmsSubjectService;
import io.swagger.annotations.Api;

@Api(tags = "CmsSubjectController", description = "商品分类关联管理")
@RestController
public class CmsSubjectController {
	@Autowired
	private CmsSubjectService cmsSubjectService;
	
	@RequestMapping(value = "/cmsSubject/{categorgId}",method = RequestMethod.POST)
	public CommonResult selectCmsSubjectByCategoryId(@PathVariable("categorgId") long categorgId) {
		List<CmsSubject> selectCmsSubjectByCategoryId = cmsSubjectService.selectCmsSubjectByCategoryId(categorgId);
		if(!StringUtils.isEmpty(selectCmsSubjectByCategoryId)) {
			return  CommonResult.success(selectCmsSubjectByCategoryId);
		}else {
			return CommonResult.failed("查询商品分类关联失败");
		}
	}

}
