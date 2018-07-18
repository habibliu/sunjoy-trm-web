package com.sunjoy.trm.web.base;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sunjoy.common.auth.service.ISecurityService;

/**
 *
 * @author liuganchao<740033486@qq.com>
 * @date 2018年7月18日
 */
@RestController
public class LoginController {

	@Autowired
	private ISecurityService securityService;
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage() {
        return "Organization";
    }

}
