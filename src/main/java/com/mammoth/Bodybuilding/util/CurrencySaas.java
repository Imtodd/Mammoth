package com.mammoth.Bodybuilding.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

/**
 * 
 * @title : CurrencySaas
 * @description : 通用方法
 * @company : com.mammoth.Bodybuilding.util
 * @project Mammoth
 * @author xingzhaojun
 * @date 2018年4月14日 上午9:08:25
 */
public class CurrencySaas {
	/**
	 * 检查参数是否正确
	 * 
	 * @param result
	 * @return
	 */
	public static ResultObj checkFieldError(BindingResult result) {
		ResultObj resultObj = new ResultObj();
		if (result.hasErrors()) {
			List<ObjectError> allErrors = result.getAllErrors();
			ObjectError objectError = allErrors.get(allErrors.size()-1);
			resultObj.setCode(-1);
			resultObj.setMessager(objectError.getDefaultMessage());
			resultObj.setFlag(false);
		}
		return resultObj;
	}
}
