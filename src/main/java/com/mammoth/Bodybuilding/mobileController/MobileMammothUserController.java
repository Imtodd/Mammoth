package com.mammoth.Bodybuilding.mobileController;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mammoth.Bodybuilding.entity.SysUserObj;

import io.swagger.annotations.ApiOperation;

/**
 * 
 * @title : MammothAppUserController 
 * @description : 猛犸健身APP 用户 控制器
 * @company :  com.mammoth.Bodybuilding.controller.appcontroller
 * @project Mammoth
 * @author xingzhaojun
 * @date 2018年4月13日 下午12:34:01
 */
@RestController
public class MobileMammothUserController {
		/**
		 * 
		 * @param user
		 * @param checkPass
		 * @return
		 */
		@ApiOperation(value="移动端注册",notes="移动端用户注册")
		@RequestMapping(value="/appregister",method=RequestMethod.POST)
		public String appRegister(SysUserObj user,String checkPass) {
			return "";
		}
}
