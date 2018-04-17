package com.mammoth.Bodybuilding.service;

import com.mammoth.Bodybuilding.entity.SysUserObj;
import com.mammoth.Bodybuilding.util.ResultObj;

/**
 * 
 * @title : IMammothUserService 
 * @description :  猛犸健身 用户 服务层
 * @company :  com.mammoth.Bodybuilding.service
 * @project Mammoth
 * @author xingzhaojun
 * @date 2018年4月16日 下午4:38:51
 */
public interface IMammothUserService {
	/**
	 * 注册用户接口
	 * 
	 * @param user
	 *            用户信息
	 * @param objects
	 *            [确认密码，终端类型，验证信息]
	 * @return
	 */
	ResultObj registUser(SysUserObj user,Object...objects) ;
}
