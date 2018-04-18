package com.mammoth.Bodybuilding.service.Impl;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.mammoth.Bodybuilding.entity.SysUserObj;
import com.mammoth.Bodybuilding.respository.IUserRepository;
import com.mammoth.Bodybuilding.service.IMammothUserService;
import com.mammoth.Bodybuilding.util.ClientType;
import com.mammoth.Bodybuilding.util.CurrencySaas;
import com.mammoth.Bodybuilding.util.MD5Util;
import com.mammoth.Bodybuilding.util.ResultObj;

/**
 * 
 * @title : MammothUserServiceImpl
 * @description : 猛犸健身 用户 服务层实现
 * @company : com.mammoth.Bodybuilding.service.Impl
 * @project Mammoth
 * @author xingzhaojun
 * @date 2018年4月16日 下午4:54:54
 */
@Service
public class MammothUserServiceImpl implements IMammothUserService, UserDetailsService {

	/** 定义一个全局的记录器，通过LoggerFactory获取 **/
	private final static Logger logger = LoggerFactory.getLogger(MammothUserServiceImpl.class);

	/** 注入用户数据仓库 **/
	@Autowired
	private IUserRepository userRespository;

	/**
	 * 注册用户接口
	 * 
	 * @param user
	 *            用户信息
	 * @param objects
	 *            [确认密码，终端类型，验证信息]
	 * @return
	 */
	@Override
	public ResultObj registUser(SysUserObj user, Object... objects) {
		/** 初始化临时变量 **/
		ResultObj resultObj = new ResultObj();
		String clientType = new String();
		String checkPass = new String();
		/** 获取数据并校验 **/
		if (objects != null) {
			for (Object object : objects) {
				/** 判断是否是终端类型 **/
				if (object.getClass().equals(ClientType.class)) {
					/** 获取终端类型 **/
					ClientType value = ClientType.valueOf(object.toString());
					clientType = value.name();
				}
				/** 判断是否是字符串类型 **/
				if (object.getClass().equals(String.class)) {
					checkPass = object.toString();
				}
				/** 判断是否是校验对象 **/
				if (object.getClass().equals(BindingResult.class)) {
					/** 校验用户 **/
					resultObj = CurrencySaas.checkFieldError((BindingResult) object);
					/** 判断是否通过校验 **/
					if (!resultObj.isFlag()) {
						resultObj.setMessager(resultObj.getMessager() + ",请稍后重新注册!");
						/** 记录错误日志 **/
						logger.error(resultObj.getMessager());
						return resultObj;
					}
				}
			}
			/** 判读密码与确认密码是否一致 **/
			if (!user.getPassword().equals(checkPass)) {
				resultObj.setCode(-1);
				resultObj.setFlag(false);
				resultObj.setMessager("警告!密码与确认密码不一致，请稍后重新注册!");
				/** 记录错误日志 **/
				logger.error(resultObj.getMessager());
				return resultObj;
			}
			/** 判断用户名是否重复 **/
			SysUserObj temp = userRespository.findByUsername(user.getLoginName());
			if (temp != null) {
				resultObj.setCode(-1);
				resultObj.setFlag(false);
				resultObj.setMessager("警告!用户名已存在，请稍后重新注册!");
				/** 记录错误日志 **/
				logger.error(resultObj.getMessager());
				return resultObj;
			}
			/** 验证结束 **/
			/** 密码加密 **/
			user.setPassword(MD5Util.encode(user.getPassword()));
			/** 保存用户 **/
			try {
				/** 设置当前用户终端 **/
				user.setClientType(clientType);
				/** 设置创建时间 **/
				user.setCreateTime(new Date());
				/** 设置默认头像 **/
				user.setHeadIMG("/global/assets/img/ui-sam.jpg");
				SysUserObj save = userRespository.save(user);
				resultObj.setCode(1);
				resultObj.setFlag(true);
				resultObj.setMessager("恭喜!用户注册成功,请登录");
				resultObj.setResult(save);
				/** 记录错误日志 **/
				logger.info(resultObj.getMessager());
			} catch (Exception e) {
				resultObj.setCode(-1);
				resultObj.setFlag(false);
				resultObj.setMessager("警告!用户数据保存异常，请稍后重新注册!");
				/** 记录错误日志 **/
				logger.error(resultObj.getMessager());
				// e.printStackTrace();
			}
		}
		return resultObj;
	}

	/***
	 * 加载用户信息方法
	 */
	@Override
	public UserDetails loadUserByUsername(String loginName) throws UsernameNotFoundException {
		SysUserObj sysUser = userRespository.findByUsername(loginName);
		if (sysUser == null) {
			throw new UsernameNotFoundException("用户名不存在");
		}
		return sysUser;
	}

	/**
	 * 登录接口
	 * 
	 * @param loginName
	 *            用户名
	 * @param password
	 *            密码
	 * @return
	 */
	@Override
	public ResultObj LoginUser(String loginName, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 忘记密码
	 * 
	 * @param loginName
	 *            登录名
	 * @return
	 */
	@Override
	public ResultObj forgetPassword(String loginName) {
		// TODO Auto-generated method stub
		return null;
	}

}
