package com.mammoth.Bodybuilding.controller.mobile;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.mammoth.Bodybuilding.entity.SysUserObj;

import io.swagger.annotations.ApiOperation;

/**
 * 
 * @title : MammothAppUserController
 * @description : 猛犸健身APP 用户 控制器
 * @company : com.mammoth.Bodybuilding.controller.appcontroller
 * @project Mammoth
 * @author xingzhaojun
 * @date 2018年4月13日 下午12:34:01
 */
@RestController
@RequestMapping(value="/mobile")
public class MobileMammothUserController {
	/**
	 * 
	 * @param user
	 * @param checkPass
	 * @return
	 */
	@ApiOperation(value = "移动端注册", notes = "移动端用户注册")
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	@ResponseBody
	public String appRegister(SysUserObj user, String checkPass) {
		return "";
	}
	
	@ApiOperation(value = "移动端测试接口", notes = "移动端请求连接测试接口")
	@RequestMapping(value="/test",method=RequestMethod.GET)
	@ResponseBody
	public String test() {
		JSONObject json = new JSONObject();
		json.put("code", 1);
		json.put("msg", "移动端请求连接成功");
		return json.toJSONString();
	}
}
