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
import com.sunjoy.framework.client.dto.Response;
import com.sunjoy.framework.dao.paging.Page;
import com.sunjoy.framework.dao.paging.PageInfo;
import com.sunjoy.framework.service.controller.WebController;
import com.sunjoy.framework.utils.BeanUtils;
import com.sunjoy.trm.master.dao.criteria.VenueCriteria;
import com.sunjoy.trm.master.dao.entity.Venue;
import com.sunjoy.trm.master.service.IVenueService;
import com.sunjoy.trm.web.master.vo.VenueVo;


@RestController
@RequestMapping(value = "/Venue")
public class VenueController  extends WebController{
	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private IVenueService venueService;

	/**
	 * 分页查询
	 * 
	 * @param params
	 * @return
	 */
	@RequestMapping(value = "/listPage", method = RequestMethod.GET)
	public Response listVenueByPage(@RequestParam(name = "params") String params) {
		Response response = new Response();
		VenueCriteria criteria = JSONObject.parseObject(params, VenueCriteria.class);
		Page<Venue> page = venueService.queryByPage(criteria,new PageInfo());
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
	public Response listVenue(@RequestParam(name = "params") String params) {

		Response response = new Response();
		VenueCriteria criteria = JSONObject.parseObject(params, VenueCriteria.class);
		List<Venue> venues = venueService.query(criteria);
		response.setData(venues);
		return response;
	}

	@RequestMapping(value = "/get", method = RequestMethod.GET)
	public Response getVenue(@RequestParam(name = "params") String params) {

		Response response = new Response();
		VenueCriteria criteria = JSONObject.parseObject(params, VenueCriteria.class);
		BeanUtils.checkEmptyFields(criteria, "id");
		Venue venue = venueService.get(criteria.getId());
		response.setData(venue);
		return response;
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public Response addVenue(@RequestBody VenueVo venueVo) {
		Response response = new Response();
		Venue venue=new Venue();
		BeanUtils.copyProperties(venueVo,venue);
		venueService.add(venue);
		return response;
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public Response updateVenue(@RequestBody VenueVo venueVo) {

		Response response = new Response();
		Venue venue=new Venue();
		BeanUtils.copyProperties(venueVo,venue);
		venueService.update(venue);
		return response;
	}
}
