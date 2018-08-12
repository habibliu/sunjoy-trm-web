package com.sunjoy.trm.web.bizcore;

import java.util.List;

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
import com.sunjoy.trm.bizcore.dao.dto.ScheduleDto;
import com.sunjoy.trm.bizcore.dao.dto.ShiftDto;
import com.sunjoy.trm.bizcore.dao.dto.ShiftStudentDto;
import com.sunjoy.trm.bizcore.dao.entity.Rule;
import com.sunjoy.trm.bizcore.service.IScheduelService;
import com.sunjoy.trm.bizcore.service.IShiftService;

/**
 *
 * @author liuganchao<740033486@qq.com>
 * @date 2018年6月27日
 */
@RestController
@RequestMapping(value = "/Shift")
public class ShiftController extends WebController{
	@Autowired
	private IShiftService shiftService;
	/**
	 * 分页查询
	 * 
	 * @param params
	 * @return
	 */
	@RequestMapping(value = "/listPage", method = RequestMethod.GET)
	public Response listRuleByPage(@RequestParam(name = "params") String params,@RequestParam(name = "page") String pageInfo) {
		Response response = new Response();
		ShiftDto criteria = JSONObject.parseObject(params, ShiftDto.class);
		PageInfo page=JSONObject.parseObject(pageInfo, PageInfo.class);
		Page<ShiftDto> returnPage = shiftService.query(criteria,page);
		response.setData(returnPage);
		return response;
	}
	
	@RequestMapping(value = "/listShiftStudents", method = RequestMethod.GET)
	public Response listShiftStudents(@RequestParam(name = "params") String params) {
		Response response = new Response();
		ShiftDto criteria = JSONObject.parseObject(params, ShiftDto.class);
		List<ShiftStudentDto> data = shiftService.queryShiftStudents(criteria.getId());
		response.setData(data);
		return response;
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public Response deleteShift(@RequestBody ShiftDto shift) {
		Response response = new Response();
		shiftService.deleteShift(shift.getId());
		return response;
	}
	
	@RequestMapping(value = "/batchdelete", method = RequestMethod.POST)
	public Response batchDeleteShift(@RequestParam(value = "ids") String id) {
		Response response = new Response();
		shiftService.deleteShift(id);
		return response;
	}
	
	@RequestMapping(value = "/updateAttendance", method = RequestMethod.POST)
	public Response updateAttendance(@RequestBody ShiftDto shift) {
		Response response = new Response();
		shiftService.updateAttendance(shift);
		return response;
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public Response updateShift(@RequestBody ShiftDto shift) {
		Response response = new Response();
		shiftService.updateShift(shift);
		return response;
	}
}
