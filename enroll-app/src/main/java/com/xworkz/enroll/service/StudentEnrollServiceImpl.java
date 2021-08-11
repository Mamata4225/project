package com.xworkz.enroll.service;

import java.util.Properties;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.xworkz.enroll.dao.StudentEnrollDAO;
import com.xworkz.enroll.dto.StudentEnrollDTO;
import com.xworkz.enroll.entity.StudentEnrollEntity;

@Service
public class StudentEnrollServiceImpl implements StudentEnrollService {

	@Autowired
	private StudentEnrollDAO enrollDAO;

	@Autowired
	private JavaMailSender mailSender;

	public StudentEnrollServiceImpl() {
		System.out.println(this.getClass().getSimpleName() + "object created");
	}

	public boolean enrollStudent(StudentEnrollDTO enrollDTO) {
		System.out.println("invoked enrollStudent");
		StudentEnrollEntity studentEnrollEntity = new StudentEnrollEntity();
		BeanUtils.copyProperties(enrollDTO, studentEnrollEntity);
		boolean result = this.enrollDAO.saveStudentEnrollData(studentEnrollEntity);
		if (result) {
			System.out.println("sending a mail");
			SimpleMailMessage simpleMailMessage =  new SimpleMailMessage();
			simpleMailMessage.setTo(enrollDTO.getEmail());
			simpleMailMessage.setSubject("Enrollment message");
			simpleMailMessage.setText("congrats !!! enrollment is successfull");
			mailSender.send(simpleMailMessage);
			System.out.println("mail sent");
			return true;
		} else {
			System.out.println("something went wrong please try again");
			return false;

		}
	}

}