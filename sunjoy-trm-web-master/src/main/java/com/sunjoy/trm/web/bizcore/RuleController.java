package com.sunjoy.trm.web.bizcore;


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
import com.sunjoy.framework.client.dto.Response;
import com.sunjoy.framework.dao.paging.Page;
import com.sunjoy.framework.dao.paging.PageInfo;
import com.sunjoy.framework.service.controller.WebController;
import com.sunjoy.framework.utils.BeanUtils;
import com.sunjoy.trm.bizcore.dao.criteria.RuleCriteria;
import com.sunjoy.trm.bizcore.dao.dto.RuleDto;
import com.sunjoy.trm.bizcore.dao.entity.Rule;
import com.sunjoy.trm.bizcore.service.IRuleService;

/**
 *
 * @author liuganchao<740033486@qq.com>
 * @date 2018年6月27日
 */
@RestController
@RequestMapping(value = "/Rule")
public class RuleController extends WebController {
	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private IRuleService ruleService;

	/**
	 * 分页查询
	 * 
	 * @param params
	 * @return
	 */
	@RequestMapping(value = "/listPage", method = RequestMethod.GET)
	public Response listRuleByPage(@RequestParam(name = "params") String params,@RequestParam(name = "page") String pageInfo) {
		Response response = new Response();
		RuleCriteria criteria = JSONObject.parseObject(params, RuleCriteria.class);
		PageInfo page=JSONObject.parseObject(pageInfo, PageInfo.class);
		Page<RuleDto> returnPage = ruleService.queryByPage(criteria,page);
		response.setData(returnPage);
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
		List<Rule> students = ruleService.query(criteria);
		response.setData(students);
		return response;
	}

	@RequestMapping(value = "/get", method = RequestMethod.GET)
	public Response getRule(@RequestParam(name = "params") String params) {
		Response response = new Response();
		RuleCriteria criteria = JSONObject.parseObject(params, RuleCriteria.class);
		BeanUtils.checkEmptyFields(criteria, "id");
		Rule student = ruleService.get(criteria.getId());
		response.setData(student);
		return response;
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public Response addRule(@RequestBody RuleDto ruleVo) {
		Response response = new Response();
		Rule student=new Rule();
		BeanUtils.copyProperties(ruleVo,student);
		ruleService.add(student);
		return response;
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public Response updateRule(@RequestBody RuleDto studentVo) {

		Response response = new Response();
		Rule student=new Rule();
		BeanUtils.copyProperties(studentVo,student);
		ruleService.update(student);
		return response;
	}
	
	@RequestMapping(value = "/remove", method = RequestMethod.DELETE)
	public Response removeRule(@RequestParam(value = "id") String id) {

		Response response = new Response();
		Rule student=new Rule();
		//BeanUtils.copyProperties(studentVo,student);
		ruleService.remove(id);
		return response;
	}
}