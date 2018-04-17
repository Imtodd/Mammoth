package com.mammoth.Bodybuilding.webController;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult; 
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.mammoth.Bodybuilding.entity.SysUserObj;
import com.mammoth.Bodybuilding.service.IMammothUserService;
import com.mammoth.Bodybuilding.util.ClientType;
import com.mammoth.Bodybuilding.util.ResultObj;

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
	
		/**注入用户service**/
		@Autowired
		private IMammothUserService userService;
	
		/**
		 * pc端首页位置
		 * @return 首页映射
		 */
		@ApiOperation(value="登录页面",notes="pc端首页位置")
		@RequestMapping(value="/login",method=RequestMethod.GET)
		public String loginPage(Model model) {
			model.addAttribute("user", new SysUserObj());
			model.addAttribute("resultObj", null);
			return "login";
		}
		
		/**
		 * 注册接口
		 * @param user 用户信息
		 * @param result 获取校验用户信息错误
		 * @param checkPass 密码确认
		 * @param model request对象
		 * @return 
		 */
		@ApiOperation(value="注册接口",notes="注册接口请求路径")
		@RequestMapping(value="/register",method=RequestMethod.POST)
		public String register(@ModelAttribute  @Valid SysUserObj user,BindingResult result,@RequestParam String checkPass,Model model) {
			/**调用service**/
			ResultObj resultObj = userService.registUser(user, checkPass,ClientType.PCMANAGETYPE,result);
			if(!resultObj.isFlag()) {
				model.addAttribute("user",new SysUserObj());
				model.addAttribute("resultObj", resultObj);
				return "login";
			}
			/**注册成功,跳转成功页面**/
			return "home";
		};
}
