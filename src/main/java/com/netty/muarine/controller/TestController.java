/**   
* @Title: PayAjaxCallbackController.java 
* @Package com.rtmap.pay.controller 
* @Description: TODO(用一句话描述该文件做什么) 
* @author maoyun0903 maoyun@rtmap.com   
* @date 2015-4-11 下午06:46:32 
* @version V1.0   
*/
package com.netty.muarine.controller;

import com.netty.core.server.AppContext;
import com.netty.muarine.entity.User;
import com.netty.muarine.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
/**
 * 
 * TestController.
 * 
 * @author Muarine maoyun@rtmap.com
 * @since 0.1
 */
@ControllerAdvice
@RestController
@RequestMapping("/")
public class TestController extends BaseController{
	
	Logger log = LoggerFactory.getLogger(TestController.class);
	
	@RequestMapping("/foo")
	public Map<String,Object> handleFoo() {
		
		UserService service = (UserService) AppContext.getInstance().getAppContext().getBean("userService");
		User user = service.selectUserByNameOrMobile("muarine");
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("map", "hexuan");
		map.put("user", user);
		return map;
	}
	
	@RequestMapping("/")
	public String index() {
		log.debug("index");
		return "Hello world";
	}
	
	
	
}
