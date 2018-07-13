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
import com.sunjoy.trm.master.dao.criteria.CourseCriteria;
import com.sunjoy.trm.master.dao.entity.Course;
import com.sunjoy.trm.master.service.ICourseService;
import com.sunjoy.trm.web.master.vo.CourseVo;


@RestController
@RequestMapping(value = "/Course")
public class CourseController  extends WebController{
	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private ICourseService courseService;

	/**
	 * 分页查询
	 * 
	 * @param params
	 * @return
	 */
	@RequestMapping(value = "/listPage", method = RequestMethod.GET)
	public Response listCourseByPage(@RequestParam(name = "params") String params) {
		Response response = new Response();
		CourseCriteria criteria = JSONObject.parseObject(params, CourseCriteria.class);
		Page<Course> page = courseService.queryByPage(criteria,new PageInfo());
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
	public Response listCourse(@RequestParam(name = "params") String params) {

		Response response = new Response();
		CourseCriteria criteria = JSONObject.parseObject(params, CourseCriteria.class);
		List<Course> courses = courseService.query(criteria);
		response.setData(courses);
		return response;
	}

	@RequestMapping(value = "/get", method = RequestMethod.GET)
	public Response getCourse(@RequestParam(name = "params") String params) {

		Response response = new Response();
		CourseCriteria criteria = JSONObject.parseObject(params, CourseCriteria.class);
		BeanUtils.checkEmptyFields(criteria, "id");
		Course course = courseService.get(criteria.getId());
		response.setData(course);
		return response;
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public Response addCourse(@RequestBody CourseVo courseVo) {
		Response response = new Response();
		Course course=new Course();
		BeanUtils.copyProperties(courseVo,course);
		courseService.add(course);
		return response;
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public Response updateCourse(@RequestBody CourseVo courseVo) {

		Response response = new Response();
		Course course=new Course();
		BeanUtils.copyProperties(courseVo,course);
		courseService.update(course);
		return response;
	}
}
