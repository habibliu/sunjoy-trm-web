package com.sunjoy.trm.web.base;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.sunjoy.common.dao.entity.Dictionary;
import com.sunjoy.common.service.IDictionaryService;
import com.sunjoy.framework.client.dto.Response;

/**
 * 数据字典
 * @author liuganchao<740033486@qq.com>
 * @date 2018年7月5日
 */
@RestController
@RequestMapping(value = "/Dictionary")
public class DictionaryController {
	
	@Autowired
	private IDictionaryService dictionaryService;
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public Response listRegistionByPage(@RequestParam(name = "params") String params ) {
		Response response = new Response();
		Dictionary criteria = JSONObject.parseObject(params, Dictionary.class);
		List<Dictionary> returnData = dictionaryService.getDictionaries(criteria.getTypeCode());
		response.setData(returnData);
		return response;
	}

}
