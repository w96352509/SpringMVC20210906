package com.mvc.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.mvc.entity.Exam;

@Component
public class ExamValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		//�]�w���Ҫ�����,�Y��false�h������
		//�P�w��e clazz �O���O Exam�����O
		//�p�Gclazz�OExam�����O�hture�Ϥ�false
		return Exam.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Exam exam =(Exam)target;   //�w�g½�˦n��Exam
		//�P�wid���i�Hnull�ΪŪ�
		if (exam.getId()==null || exam.getId().trim().length()==0) {
			//filed , errorCode , errorMessage
			//filed:�n���Ҫ������ܼ� EX="id"����
			//errorCode:���~�W��(�q�`�O�� errorMessages.properties �ҳ]�w���W��/�S�]�w�Nnull)
			//�|��errorMessages.properties�h��W��
			//errorMessage:�w�]�����~�T��
			errors.rejectValue("id", "exam.id.required", "id���i�ť�");		
			}
		if(exam.getName() == null || exam.getName().trim().length() == 0) {
			errors.rejectValue("name", "exam.name.required", "�п�ܦҸեN��");
		}
		if(exam.getSlot() == null || exam.getSlot().length == 0) {
			errors.rejectValue("slot", "exam.slot.required", "�п�ܦҸծɬq");
		}
		if(exam.getPay() == null || exam.getPay().trim().length() == 0) {
			errors.rejectValue("pay", "exam.pay.required", "�п��ú�O���p");
		}
	}

	
	}


