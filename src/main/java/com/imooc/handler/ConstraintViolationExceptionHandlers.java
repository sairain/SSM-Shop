package com.imooc.handler;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.apache.commons.lang3.StringUtils;

//处理异常
public class ConstraintViolationExceptionHandlers {

	public static String getMessage(ConstraintViolationException e){
		List<String> msgList=new ArrayList<String>();
		for(ConstraintViolation<?> constraintViolation : e.getConstraintViolations()){
			msgList.add(constraintViolation.getMessage());
		}
		String messages=StringUtils.join(msgList.toArray());
		return messages;
	}
	
}
