package com.mammoth.Bodybuilding.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

/**
 * 
 * @title : MammothUserObj
 * @description : 猛犸健身 用户实体类
 * @company : com.mammoth.Bodybuilding.po
 * @project Bodybuilding
 * @author xingzhaojun
 * @date 2018年4月13日 上午10:39:24
 */
@Entity
@Table(name = "MAMMOTH_BODYBUILDING_USER")
public class MammothUserObj implements Serializable {

	/**
	 * 序列号
	 */
	private static final long serialVersionUID = 5007714420218370143L;
	/** 主键id **/
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	/** 登录名 **/
	@NotEmpty(message = "用户名不能为空")
	private String loginName;
	/** 密码 **/
	@NotEmpty(message = "密码不能为空")
	@Length(min = 8,message="密码长度不能少于8位")
	private String password;
	/** 昵称 **/
	private String nickName;
	/** 姓氏 **/
	private String surName;
	/** 真是姓名 **/
	private String fullName;
	/** 手机号码 **/
	private String phoneNum;
	/** 身份证号码 **/
	private String IDCard;
	/** 邮箱地址 **/
	@Email(message="电子邮件格式不正确")
	private String email;
	/** 头像地址 **/
	private String headIMG;
	/** 用户简介 **/
	private String introduce;
	/** 注册时间 **/
	@Temporal(TemporalType.TIMESTAMP)
	private Date createTime;
	/** 修改时间 **/
	@Temporal(TemporalType.TIMESTAMP)
	private Date updateTime;
	/** 生日日期 **/
	@Temporal(TemporalType.TIMESTAMP)
	private Date birthday;
	/** 扩展字段1 **/
	private String ext1;
	/** 扩展字段2 **/
	private String ext2;
	/** 扩展字段2 **/
	private String ext3;
	/** 扩展字段4 **/
	private String ext4;
	/** 扩展字段5 **/
	private String ext5;

	public int getId() {
		return id;
	}

	public String getLoginName() {
		return loginName;
	}

	public String getPassword() {
		return password;
	}

	public String getNickName() {
		return nickName;
	}

	public String getSurName() {
		return surName;
	}

	public String getFullName() {
		return fullName;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public String getIDCard() {
		return IDCard;
	}

	public String getEmail() {
		return email;
	}

	public String getHeadIMG() {
		return headIMG;
	}

	public String getIntroduce() {
		return introduce;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public Date getBirthday() {
		return birthday;
	}

	public String getExt1() {
		return ext1;
	}

	public String getExt2() {
		return ext2;
	}

	public String getExt3() {
		return ext3;
	}

	public String getExt4() {
		return ext4;
	}

	public String getExt5() {
		return ext5;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public void setSurName(String surName) {
		this.surName = surName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public void setIDCard(String iDCard) {
		IDCard = iDCard;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setHeadIMG(String headIMG) {
		this.headIMG = headIMG;
	}

	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public void setExt1(String ext1) {
		this.ext1 = ext1;
	}

	public void setExt2(String ext2) {
		this.ext2 = ext2;
	}

	public void setExt3(String ext3) {
		this.ext3 = ext3;
	}

	public void setExt4(String ext4) {
		this.ext4 = ext4;
	}

	public void setExt5(String ext5) {
		this.ext5 = ext5;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((IDCard == null) ? 0 : IDCard.hashCode());
		result = prime * result + ((birthday == null) ? 0 : birthday.hashCode());
		result = prime * result + ((createTime == null) ? 0 : createTime.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((ext1 == null) ? 0 : ext1.hashCode());
		result = prime * result + ((ext2 == null) ? 0 : ext2.hashCode());
		result = prime * result + ((ext3 == null) ? 0 : ext3.hashCode());
		result = prime * result + ((ext4 == null) ? 0 : ext4.hashCode());
		result = prime * result + ((ext5 == null) ? 0 : ext5.hashCode());
		result = prime * result + ((fullName == null) ? 0 : fullName.hashCode());
		result = prime * result + ((headIMG == null) ? 0 : headIMG.hashCode());
		result = prime * result + id;
		result = prime * result + ((introduce == null) ? 0 : introduce.hashCode());
		result = prime * result + ((loginName == null) ? 0 : loginName.hashCode());
		result = prime * result + ((nickName == null) ? 0 : nickName.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((phoneNum == null) ? 0 : phoneNum.hashCode());
		result = prime * result + ((surName == null) ? 0 : surName.hashCode());
		result = prime * result + ((updateTime == null) ? 0 : updateTime.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MammothUserObj other = (MammothUserObj) obj;
		if (IDCard == null) {
			if (other.IDCard != null)
				return false;
		} else if (!IDCard.equals(other.IDCard))
			return false;
		if (birthday == null) {
			if (other.birthday != null)
				return false;
		} else if (!birthday.equals(other.birthday))
			return false;
		if (createTime == null) {
			if (other.createTime != null)
				return false;
		} else if (!createTime.equals(other.createTime))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (ext1 == null) {
			if (other.ext1 != null)
				return false;
		} else if (!ext1.equals(other.ext1))
			return false;
		if (ext2 == null) {
			if (other.ext2 != null)
				return false;
		} else if (!ext2.equals(other.ext2))
			return false;
		if (ext3 == null) {
			if (other.ext3 != null)
				return false;
		} else if (!ext3.equals(other.ext3))
			return false;
		if (ext4 == null) {
			if (other.ext4 != null)
				return false;
		} else if (!ext4.equals(other.ext4))
			return false;
		if (ext5 == null) {
			if (other.ext5 != null)
				return false;
		} else if (!ext5.equals(other.ext5))
			return false;
		if (fullName == null) {
			if (other.fullName != null)
				return false;
		} else if (!fullName.equals(other.fullName))
			return false;
		if (headIMG == null) {
			if (other.headIMG != null)
				return false;
		} else if (!headIMG.equals(other.headIMG))
			return false;
		if (id != other.id)
			return false;
		if (introduce == null) {
			if (other.introduce != null)
				return false;
		} else if (!introduce.equals(other.introduce))
			return false;
		if (loginName == null) {
			if (other.loginName != null)
				return false;
		} else if (!loginName.equals(other.loginName))
			return false;
		if (nickName == null) {
			if (other.nickName != null)
				return false;
		} else if (!nickName.equals(other.nickName))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (phoneNum == null) {
			if (other.phoneNum != null)
				return false;
		} else if (!phoneNum.equals(other.phoneNum))
			return false;
		if (surName == null) {
			if (other.surName != null)
				return false;
		} else if (!surName.equals(other.surName))
			return false;
		if (updateTime == null) {
			if (other.updateTime != null)
				return false;
		} else if (!updateTime.equals(other.updateTime))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "MammothUserObj [id=" + id + ", loginName=" + loginName + ", password=" + password + ", nickName="
				+ nickName + ", surName=" + surName + ", fullName=" + fullName + ", phoneNum=" + phoneNum + ", IDCard="
				+ IDCard + ", email=" + email + ", headIMG=" + headIMG + ", introduce=" + introduce + ", createTime="
				+ createTime + ", updateTime=" + updateTime + ", birthday=" + birthday + ", ext1=" + ext1 + ", ext2="
				+ ext2 + ", ext3=" + ext3 + ", ext4=" + ext4 + ", ext5=" + ext5 + "]";
	}

}
