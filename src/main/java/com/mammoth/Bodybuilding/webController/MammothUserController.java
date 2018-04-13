package com.mammoth.Bodybuilding.webController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mammoth.Bodybuilding.entity.MammothUserObj;

import io.swagger.annotations.ApiOperation;
/**
 * 
 * @title : MammothUserController 
 * @description : 猛犸健身后台 用户 控制器
 * @company :  com.mammoth.Bodybuilding.controller
 * @project Bodybuilding
 * @author xingzhaojun
 * @date 2018年4月13日 上午11:01:00
 */
@Controller
public class MammothUserController {
		/**
		 * pc端首页位置
		 * @return 首页映射
		 */
		@ApiOperation(value="首页",notes="pc端首页位置")
		@RequestMapping(value="/",method=RequestMethod.GET)
		public String homePage() {
			return "home";
		}

		/**
		 * 注册接口
		 * @param user 用户信息
		 * @param checkPass 检查密码
		 * @return 
		 */
		@ApiOperation(value="注册接口",notes="注册接口请求路径")
		@RequestMapping(value="register",method=RequestMethod.POST)
		public String register(MammothUserObj user,String checkPass) {
			return "";
		};
		
	
}
