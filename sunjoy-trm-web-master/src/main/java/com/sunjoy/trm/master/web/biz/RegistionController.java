package com.sunjoy.trm.master.web.biz;

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

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/Registion")
public class RegistionController extends WebController{
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
	public Response listRegistionByPage(@RequestParam(name = "params") String params) {
		Response response = new Response();
		RegistionCriteria criteria = JSONObject.parseObject(params, RegistionCriteria.class);
		Page<RegistionDto> page = registionService.query(criteria,new PageInfo());
		response.setData(page);
		return response;
	}

	/**
	 * 不分页查询
	 * 
	 * @param params
	 * @return
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public Response listRegistion(@RequestParam(name = "params") String params) {
		Response response = new Response();
		RegistionCriteria criteria = JSONObject.parseObject(params, RegistionCriteria.class);
		Page<RegistionDto> registions = registionService.query(criteria,null);
		response.setData(registions);
		return response;
	}

	@RequestMapping(value = "/get", method = RequestMethod.GET)
	public Response getRegistion(@RequestParam(name = "params") String params) {
		Response response = new Response();
		RegistionCriteria criteria = JSONObject.parseObject(params, RegistionCriteria.class);
		BeanUtils.checkEmptyFields(criteria, "id");
		RegistionDto registion = registionService.get(criteria.getId());
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