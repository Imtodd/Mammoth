package com.mammoth.Bodybuilding.controller.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
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
 * @company : com.mammoth.Bodybuilding.controller
 * @project Bodybuilding
 * @author xingzhaojun
 * @date 2018年4月13日 上午11:01:00
 */
@Controller
public class MammothUserController {

	/** 注入用户service **/
	@Autowired
	private IMammothUserService userService;

	/**
	 * pc端首页位置
	 * 
	 * @return 首页映射
	 */
	@ApiOperation(value = "后台登录页面", notes = "pc端首页位置")
	@GetMapping(value ="/login")
	public String indexPage(Model model) {
		model.addAttribute("user", new SysUserObj());
		model.addAttribute("resultObj", null);
		return "login";
	}

	/**
	 * 后台登录后跳转首页
	 * 
	 * @param model
	 *            request对象
	 * @return
	 */
	@ApiOperation(value = "后台首页", notes = "后台首页位置")
	@GetMapping(value = {"/","/home"})
	public String homePage(Model model) {
		System.out.println("我跳");
		return "home";
	}
	/**
	 * 注册接口
	 * 
	 * @param user
	 *            用户信息
	 * @param result
	 *            获取校验用户信息错误
	 * @param checkPass
	 *            密码确认
	 * @param model
	 *            request对象
	 * @return
	 */
	@ApiOperation(value = "注册接口", notes = "注册请求接口")
	@PostMapping(value = "/register")
	public String register(@ModelAttribute @Valid SysUserObj user, BindingResult result, @RequestParam String checkPass,
			Model model) {
		/** 调用service **/
		ResultObj resultObj = userService.registUser(user, checkPass, ClientType.PCMANAGETYPE, result);
		model.addAttribute("user", new SysUserObj());
		model.addAttribute("resultObj", resultObj);
		/** 注册成功,跳转成功页面 **/
		return "login";
	};

	/**
	 * 忘记密码接口
	 * 
	 * @param userNameForget
	 *            登录名
	 * @param model
	 *            request对象
	 * @return
	 */
	@ApiOperation(value = "忘记密码", notes = "忘记密码请求接口")
	@PostMapping(value = "/forget")
	public String forget(@RequestParam String userNameForget, Model model) {
		ResultObj resultObj = userService.forgetPassword(userNameForget);
		model.addAttribute("user", new SysUserObj());
		model.addAttribute("resultObj", resultObj);
		return "login";
	}
}
