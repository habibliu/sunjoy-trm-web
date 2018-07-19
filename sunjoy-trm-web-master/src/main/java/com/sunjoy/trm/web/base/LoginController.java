package com.sunjoy.trm.web.base;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sunjoy.common.auth.service.ISecurityService;
import com.sunjoy.framework.client.dto.Response;

/**
 *
 * @author liuganchao<740033486@qq.com>
 * @date 2018年7月18日
 */
@RestController
public class LoginController {
	
	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private ISecurityService securityService;
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
    public Response loginPage(@RequestParam(name = "username") String username) {
		logger.info("{} is logining....",username);
		Response response = new Response();
		UserDetails user=securityService.loadUserByUsername(username);
		if(user!=null){
			response.setData(user);
		}else{
			response.setCode("000001");
		}
        return response;
    }

}