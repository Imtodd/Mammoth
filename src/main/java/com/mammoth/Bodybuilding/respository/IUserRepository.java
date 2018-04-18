package com.mammoth.Bodybuilding.respository;

import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mammoth.Bodybuilding.entity.SysUserObj;

/**
 * 
 * @title : IUserRepository
 * @description : 用户 数据仓库层
 * @company : com.mammoth.Bodybuilding.respository
 * @project Mammoth
 * @author xingzhaojun
 * @date 2018年4月16日 下午5:01:47
 */
@Repository
@Table(name = "SYS_USER")
@Qualifier("userRespository")
public interface IUserRepository extends JpaRepository<SysUserObj, Long> {
	/**
	 * 根据登录名获取用户信息
	 * @param username
	 * @return
	 */
	@Query("select u from SysUserObj u where u.loginName=:loginName")
	SysUserObj findByUsername(@Param("loginName") String loginName);
}
