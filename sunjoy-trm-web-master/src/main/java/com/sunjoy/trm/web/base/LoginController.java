package com.sunjoy.trm.web.base;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.sunjoy.common.auth.dao.entity.User;
import com.sunjoy.common.auth.service.ISecurityService;
import com.sunjoy.framework.client.dto.Response;
import com.sunjoy.framework.service.controller.WebController;

/**
 *
 * @author liuganchao<740033486@qq.com>
 * @date 2018年7月18日
 */
@RestController
public class LoginController extends WebController{
	
	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private ISecurityService securityService;
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
    public Response loginPage(@RequestParam(name = "params") String params) {
		User userVo=JSONObject.parseObject(params,User.class);
		logger.info("{} is logining....",userVo.getUsername());
		Response response = new Response();
		UserDetails user=securityService.loadUserByUsername(userVo.getUsername());
		if(user!=null){
			response.setData(user);
		}else{
			response.setCode("error");
		}
        return response;
    }

}