package com.mvc.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;
import static java.util.stream.Collectors.groupingBy;

import java.util.ArrayList;

import static java.util.stream.Collectors.counting;
import org.springframework.beans.factory.annotation.AnnotationBeanWiringInfoResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mvc.entity.Exam;
import com.mvc.entity.ExamName;
import com.mvc.validator.ExamValidator;

@Controller
@RequestMapping("/exam")
public class ExamController {

	private static List<Exam> exams = new CopyOnWriteArrayList<>();
	
    private static List<ExamName> examNames = new ArrayList<>();
    private static List<ExamName> exampays = new ArrayList<>();
    private static List<ExamName> examslot = new ArrayList<>();
    static {
    	examNames.add( new ExamName("808", "1Z0-808"));
    	examNames.add( new ExamName("809", "1Z0-809")); 
    	examNames.add( new ExamName("900", "1Z0-900"));
    	examNames.add( new ExamName("peko", "miko"));
    	exampays.add(new ExamName ("false","��ú��"));
    	exampays.add(new ExamName ("true","�wú��"));
    	exampays.add(new ExamName ("tttrrr","ice"));
    	examslot.add(new ExamName("19:00~20:30","�ߤW"));
    	examslot.add(new ExamName("8:30~10:00","���W"));
    	examslot.add(new ExamName("14:00~16:30","�U��"));
    }
   
    
	
    @Autowired
	private ExamValidator examValidator;

	@RequestMapping(value = { "/", "/index" })
	public String index(Model model) {
		Exam e = new Exam();   
		model.addAttribute("exam", e); // �����ϥ�
		model.addAttribute("exams", exams); // ����Ƨe�{�ϥ�
		model.addAttribute("examNames", examNames); // ����Ƨe�{�ϥ�
		model.addAttribute("exampays", exampays); // ����Ƨe�{�ϥ�
		model.addAttribute("examslot", examslot); // ����Ƨe�{�ϥ�
		model.addAttribute("action", "create");
		// �έp���
		model.addAttribute("stat1", getStat1());
		model.addAttribute("stat2", getStat2());
		return "exam";
	}

	// CRUD create, read, update, delete
	@RequestMapping(value = "/create")
	public String create(Exam exam , BindingResult result ,Model model) {
		System.out.println(exams);
		//����exam����
		//���ҵ��G���result��
		examValidator.validate(exam, result);
		//���ҵ��G�O�_�����~
		if (result.hasErrors()) {
			//���~�o�ͦ^��exam������
			//�@�åᵹ�e��
			model.addAttribute("exams", exams); // ����Ƨe�{�ϥ�
			model.addAttribute("action", "create");
			model.addAttribute("examNames", examNames); // ����Ƨe�{�ϥ�
			model.addAttribute("exampays", exampays); // ����Ƨe�{�ϥ�
			model.addAttribute("examslot", examslot); // ����Ƨe�{�ϥ�
			// �έp���
			model.addAttribute("stat1", getStat1());
			model.addAttribute("stat2", getStat2());
			return "exam";
		}
		exams.add(exam); // �s�W
		return "redirect:/mvc/exam/"; // ���ɨ쭺��
	}

	@RequestMapping(value = "/get/{id}")
	public String get(@PathVariable("id") String id, Model model) {
		Optional<Exam> optExam = exams.stream().filter(e -> e.getId().equals(id)).findFirst();
		model.addAttribute("exam", optExam.isPresent() ? optExam.get() : new Exam()); // �����ϥ�
		model.addAttribute("exams", exams); // ����Ƨe�{�ϥ�
		model.addAttribute("action", "update");
		// �έp���
		model.addAttribute("stat1", getStat1());
		model.addAttribute("stat2", getStat2());
		return "exam";
	}

	@RequestMapping(value = "/update")
	public String update(Exam exam) {
		Optional<Exam> optExam = exams.stream().filter(e -> e.getId().equals(exam.getId())).findFirst();
		if (optExam.isPresent()) {
			// oExam �쥻�����
			// ���Ǩ� exam �n�ק諸���
			Exam oExam = optExam.get();
			oExam.setName(exam.getName());
			oExam.setSlot(exam.getSlot());
			oExam.setPay(exam.getPay());
			oExam.setNote(exam.getNote());
		}

		return "redirect:/mvc/exam/"; // ���ɨ쭺��
	}

	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable("id") String id) {
		exams.removeIf(e -> e.getId().equals(id));
		return "redirect:/mvc/exam/"; // ���ɨ쭺��
	}

	// �έp��� 1. �U��Ҹճ��W�H��
	private Map<String, Long> getStat1() {
		return exams.stream().collect(groupingBy(Exam::getName, counting()));
	}

	// �έp��� 2. �U��Ҹճ��W�H��
	private Map<String, Long> getStat2() {
		return exams.stream().collect(groupingBy(Exam::getPay, counting()));
	}

}
