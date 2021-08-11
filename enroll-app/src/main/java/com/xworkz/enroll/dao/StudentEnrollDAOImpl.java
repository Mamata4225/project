package com.xworkz.enroll.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.xworkz.enroll.entity.StudentEnrollEntity;

@Repository
public class StudentEnrollDAOImpl implements StudentEnrollDAO {
	@Autowired
	private SessionFactory factory;

	public StudentEnrollDAOImpl() {
		System.out.println(this.getClass().getSimpleName() + "object created");
	}

	public boolean saveStudentEnrollData(StudentEnrollEntity enrollEntity) {
		System.out.println("save method started");
		Session session = this.factory.openSession();
		try {
			org.hibernate.Transaction transaction = session.beginTransaction();
			session.save(enrollEntity);
			transaction.commit();
			System.out.println("data is saved in SQL successfully");
			return true;
		} catch (Exception e) {
			session.getTransaction().rollback();
			System.out.println("data is not saved in SQL try again ");

		} finally {
			if (session != null) {
				System.out.println("session closed");
				session.close();
			} else {
				System.out.println("session is not closed");
			}
		}
		return false;
	}
}
