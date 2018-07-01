package com.sunjoy.trm.master.bizcore;

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

import com.alibaba.fastjson.JSONObject;
import com.sunjoy.common.utils.BeanUtils;
import com.sunjoy.framework.client.dto.Response;
import com.sunjoy.framework.dao.paging.Page;
import com.sunjoy.framework.service.controller.WebController;
import com.sunjoy.trm.bizcore.dao.criteria.RuleCriteria;
import com.sunjoy.trm.bizcore.dao.entity.Rule;
import com.sunjoy.trm.bizcore.service.IRuleSettingService;
import com.sunjoy.trm.master.vo.RuleVo;

/**
 *
 * @author liuganchao<740033486@qq.com>
 * @date 2018年6月27日
 */
public class RuleController extends WebController {
	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private IRuleSettingService ruleSettingService;

	/**
	 * 分页查询
	 * 
	 * @param params
	 * @return
	 */
	@ApiOperation(value = "分页查询")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "params", value = "RuleCriteria类型的json字符串", required = true, dataType = "String") })
	@RequestMapping(value = "/listPage", method = RequestMethod.GET)
	public Response listRuleByPage(@RequestParam(name = "params") String params) {
		Response response = new Response();
		RuleCriteria criteria = JSONObject.parseObject(params, RuleCriteria.class);
		Page<Rule> page = ruleSettingService.queryByPage(criteria);
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
	public Response listRule(@RequestParam(name = "params") String params) {
		Response response = new Response();
		RuleCriteria criteria = JSONObject.parseObject(params, RuleCriteria.class);
		List<Rule> students = ruleSettingService.query(criteria);
		response.setData(students);
		return response;
	}

	@RequestMapping(value = "/get", method = RequestMethod.GET)
	public Response getRule(@RequestParam(name = "params") String params) {
		Response response = new Response();
		RuleCriteria criteria = JSONObject.parseObject(params, RuleCriteria.class);
		BeanUtils.checkEmptyFields(criteria, "id");
		Rule student = ruleSettingService.get(criteria.getId());
		response.setData(student);
		return response;
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public Response addRule(@RequestBody RuleVo studentVo) {
		Response response = new Response();
		Rule student=new Rule();
		BeanUtils.copyProperties(studentVo,student);
		ruleSettingService.add(student);
		return response;
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public Response updateRule(@RequestBody RuleVo studentVo) {

		Response response = new Response();
		Rule student=new Rule();
		BeanUtils.copyProperties(studentVo,student);
		ruleSettingService.update(student);
		return response;
	}
	
	@RequestMapping(value = "/remove", method = RequestMethod.DELETE)
	public Response removeRule(@RequestParam(value = "id") String id) {

		Response response = new Response();
		Rule student=new Rule();
		//BeanUtils.copyProperties(studentVo,student);
		ruleSettingService.remove(id);
		return response;
	}
}