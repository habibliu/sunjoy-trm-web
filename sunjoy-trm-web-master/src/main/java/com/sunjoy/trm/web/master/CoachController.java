package com.sunjoy.trm.web.master;

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
import com.sunjoy.trm.master.dao.criteria.CoachCriteria;
import com.sunjoy.trm.master.dao.entity.Coach;
import com.sunjoy.trm.master.service.ICoachService;
import com.sunjoy.trm.web.master.vo.CoachVo;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/Coach")
public class CoachController  extends WebController{
	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private ICoachService coachService;

	/**
	 * 分页查询
	 * 
	 * @param params
	 * @return
	 */
	@ApiOperation(value = "分页查询")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "params", value = "CoachCriteria类型的json字符串", required = true, dataType = "String") })
	@RequestMapping(value = "/listPage", method = RequestMethod.GET)
	public Response listCoachByPage(@RequestParam(name = "params") String params) {
		Response response = new Response();
		CoachCriteria criteria = JSONObject.parseObject(params, CoachCriteria.class);
		Page<Coach> page = coachService.queryByPage(criteria,new PageInfo());
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
	public Response listCoach(@RequestParam(name = "params") String params) {

		Response response = new Response();
		CoachCriteria criteria = JSONObject.parseObject(params, CoachCriteria.class);
		List<Coach> coachs = coachService.query(criteria);
		response.setData(coachs);
		return response;
	}

	@RequestMapping(value = "/get", method = RequestMethod.GET)
	public Response getCoach(@RequestParam(name = "params") String params) {

		Response response = new Response();
		CoachCriteria criteria = JSONObject.parseObject(params, CoachCriteria.class);
		BeanUtils.checkEmptyFields(criteria, "id");
		Coach coach = coachService.get(criteria.getId());
		response.setData(coach);
		return response;
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public Response addCoach(@RequestBody CoachVo coachVo) {
		Response response = new Response();
		Coach coach=new Coach();
		BeanUtils.copyProperties(coachVo,coach);
		coachService.add(coach);
		return response;
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public Response updateCoach(@RequestBody CoachVo coachVo) {

		Response response = new Response();
		Coach coach=new Coach();
		BeanUtils.copyProperties(coachVo,coach);
		coachService.update(coach);
		return response;
	}
}
