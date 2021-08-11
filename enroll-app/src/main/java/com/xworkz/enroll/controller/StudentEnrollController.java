package com.xworkz.enroll.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xworkz.enroll.dto.StudentEnrollDTO;
import com.xworkz.enroll.service.StudentEnrollService;

@Controller
public class StudentEnrollController {

	@Autowired
	private StudentEnrollService enrollService;

	public StudentEnrollController() {

		System.out.println(this.getClass().getSimpleName() + "object created");
	}

	@RequestMapping(value = "/onenroll.do")
	private String onEnroll(@ModelAttribute StudentEnrollDTO studentEnrollDTO, Model model) {
		System.out.println("invoked onEnroll");
		System.out.println(studentEnrollDTO);

		boolean outcome = this.enrollService.enrollStudent(studentEnrollDTO);
		if (outcome) {
			model.addAttribute("enrollmessage", "congrats !!! enrollment is successfull");
			return "EnrollSuccess";
		} else {
			model.addAttribute("enrollmessage", "something went wrong !!! enrollment is not successfull");
			return "EnrollSuccess";
		}

	}

}
