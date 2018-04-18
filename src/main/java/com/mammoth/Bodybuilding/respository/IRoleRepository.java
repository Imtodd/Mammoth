package com.mammoth.Bodybuilding.respository;

import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mammoth.Bodybuilding.entity.SysRole;

/**
 * 
 * @title : IUserRepository
 * @description : 角色 数据仓库层
 * @company : com.mammoth.Bodybuilding.respository
 * @project Mammoth
 * @author xingzhaojun
 * @date 2018年4月16日 下午5:01:47
 */
@Repository
@Table(name = "SYS_ROLE")
@Qualifier("roleRespository")
public interface IRoleRepository extends JpaRepository<SysRole, Long> {

}
