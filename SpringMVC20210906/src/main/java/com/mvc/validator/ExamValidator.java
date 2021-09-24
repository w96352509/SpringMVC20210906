package com.mvc.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.mvc.entity.Exam;

@Component
public class ExamValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		//設定驗證的物件,若為false則不驗證
		//判定當前 clazz 是不是 Exam的類別
		//如果clazz是Exam的類別則ture反之false
		return Exam.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Exam exam =(Exam)target;   //已經翻裝好的Exam
		//判定id不可以null或空的
		if (exam.getId()==null || exam.getId().trim().length()==0) {
			//filed , errorCode , errorMessage
			//filed:要驗證的物件變數 EX="id"等等
			//errorCode:錯誤名稱(通常是指 errorMessages.properties 所設定的名稱/沒設定就null)
			//會到errorMessages.properties去找名稱
			//errorMessage:預設的錯誤訊息
			errors.rejectValue("id", "exam.id.required", "id不可空白");		
			}
		if(exam.getName() == null || exam.getName().trim().length() == 0) {
			errors.rejectValue("name", "exam.name.required", "請選擇考試代號");
		}
		if(exam.getSlot() == null || exam.getSlot().length == 0) {
			errors.rejectValue("slot", "exam.slot.required", "請選擇考試時段");
		}
		if(exam.getPay() == null || exam.getPay().trim().length() == 0) {
			errors.rejectValue("pay", "exam.pay.required", "請選擇繳費狀況");
		}
	}

	
	}


