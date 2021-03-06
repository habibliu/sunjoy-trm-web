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
import com.sunjoy.trm.master.dao.criteria.StudentCriteria;
import com.sunjoy.trm.master.dao.entity.Student;
import com.sunjoy.trm.master.service.IStudentService;
import com.sunjoy.trm.web.master.vo.StudentVo;


@RestController
@RequestMapping(value = "/Student")
public class StudentController extends WebController {
	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private IStudentService studentService;

	/**
	 * 分页查询
	 * 
	 * @param params
	 * @return
	 */
	@RequestMapping(value = "/listPage", method = RequestMethod.GET)
	public Response listStudentByPage(@RequestParam(name = "params") String params) {
		Response response = new Response();
		StudentCriteria criteria = JSONObject.parseObject(params, StudentCriteria.class);
		Page<Student> page = studentService.queryByPage(criteria,new PageInfo());
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
	public Response listStudent(@RequestParam(name = "params") String params) {
		Response response = new Response();
		StudentCriteria criteria = JSONObject.parseObject(params, StudentCriteria.class);
		List<Student> students = studentService.query(criteria);
		response.setData(students);
		return response;
	}

	@RequestMapping(value = "/get", method = RequestMethod.GET)
	public Response getStudent(@RequestParam(name = "params") String params) {
		Response response = new Response();
		StudentCriteria criteria = JSONObject.parseObject(params, StudentCriteria.class);
		BeanUtils.checkEmptyFields(criteria, "id");
		Student student = studentService.get(criteria.getId());
		response.setData(student);
		return response;
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public Response addStudent(@RequestBody StudentVo studentVo) {
		Response response = new Response();
		Student student=new Student();
		BeanUtils.copyProperties(studentVo,student);
		studentService.add(student);
		return response;
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public Response updateStudent(@RequestBody StudentVo studentVo) {

		Response response = new Response();
		Student student=new Student();
		BeanUtils.copyProperties(studentVo,student);
		studentService.update(student);
		return response;
	}
	
	@RequestMapping(value = "/remove", method = RequestMethod.DELETE)
	public Response removeStudent(@RequestParam(value = "id") String id) {

		Response response = new Response();
		Student student=new Student();
		//BeanUtils.copyProperties(studentVo,student);
		studentService.remove(id);
		return response;
	}
}
