package com.mammoth.Bodybuilding.util;

import java.io.Serializable;

/**
 * 
 * @title : ResultObj
 * @description : 前后台交互对象
 * @company : com.mammoth.Bodybuilding.util
 * @project Mammoth
 * @author xingzhaojun
 * @date 2018年4月14日 上午9:03:32
 */
public class ResultObj implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8985343406969344090L;

	private int code;
	private boolean flag;
	private String messager;
	private Object result;

	public int getCode() {
		return code;
	}

	public boolean isFlag() {
		return flag;
	}

	public String getMessager() {
		return messager;
	}

	public Object getResult() {
		return result;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public void setMessager(String messager) {
		this.messager = messager;
	}

	public void setResult(Object result) {
		this.result = result;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + code;
		result = prime * result + (flag ? 1231 : 1237);
		result = prime * result + ((messager == null) ? 0 : messager.hashCode());
		result = prime * result + ((this.result == null) ? 0 : this.result.hashCode());
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
		ResultObj other = (ResultObj) obj;
		if (code != other.code)
			return false;
		if (flag != other.flag)
			return false;
		if (messager == null) {
			if (other.messager != null)
				return false;
		} else if (!messager.equals(other.messager))
			return false;
		if (result == null) {
			if (other.result != null)
				return false;
		} else if (!result.equals(other.result))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ResultObj [code=" + code + ", flag=" + flag + ", messager=" + messager + ", result=" + result + "]";
	}

}
