package com.sunjoy.trm.web.bizcore;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.sunjoy.common.utils.BeanUtils;
import com.sunjoy.framework.client.dto.Response;
import com.sunjoy.framework.dao.paging.Page;
import com.sunjoy.framework.dao.paging.PageInfo;
import com.sunjoy.framework.service.controller.WebController;
import com.sunjoy.trm.bizcore.dao.criteria.RegistionCriteria;
import com.sunjoy.trm.bizcore.dao.dto.RegistionDto;
import com.sunjoy.trm.bizcore.dao.entity.Registion;
import com.sunjoy.trm.bizcore.service.IRegistionService;

/**
 * 课程注册服务类
 * @author liuganchao<740033486@qq.com>
 * @date 2018年6月27日
 */
@RestController
@RequestMapping(value = "/Registion")
public class RegistionController extends WebController {
	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private IRegistionService registionService;

	/**
	 * 分页查询
	 * 
	 * @param params
	 * @return
	 */
	@ApiOperation(value = "分页查询")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "params", value = "RegistionCriteria类型的json字符串", required = true, dataType = "String") })
	@RequestMapping(value = "/listPage", method = RequestMethod.GET)
	public Response listRegistionByPage(@RequestParam(name = "params") String params ,@RequestParam(name = "page") String pageInfo) {
		Response response = new Response();
		RegistionCriteria criteria = JSONObject.parseObject(params, RegistionCriteria.class);
		PageInfo page=JSONObject.parseObject(pageInfo, PageInfo.class);
		Page<RegistionDto> returnPage = registionService.query(criteria,page);
		response.setData(returnPage);
		return response;
	}

	

	@RequestMapping(value = "/get", method = RequestMethod.GET)
	public Response getRegistion(@RequestParam(name = "params") String params) {
		Response response = new Response();
		RegistionCriteria criteria = JSONObject.parseObject(params, RegistionCriteria.class);
		BeanUtils.checkEmptyFields(criteria, "id");
		Registion registion = registionService.get(criteria.getId());
		response.setData(registion);
		return response;
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public Response addRegistion(@RequestBody RegistionDto registionVo) {
		Response response = new Response();
		registionService.add(registionVo);
		return response;
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public Response updateRegistion(@RequestBody RegistionDto registionVo) {

		Response response = new Response();
		registionService.update(registionVo);
		return response;
	}
	
	@RequestMapping(value = "/remove", method = RequestMethod.DELETE)
	public Response removeRegistion(@RequestParam(value = "id") String id) {

		Response response = new Response();
		Registion registion=new Registion();
		//BeanUtils.copyProperties(registionVo,registion);
		registionService.remove(id);
		return response;
	}
}

