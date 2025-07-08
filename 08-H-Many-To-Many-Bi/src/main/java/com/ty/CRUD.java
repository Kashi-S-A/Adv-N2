package com.ty;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * CRUD class provide helper methods to perform crud operation like save to save
 * a record, fetch to fetch student based on studentID
 * 
 * @author Kashi
 * @version 0.0.1-snapshot
 */
public class CRUD {

	private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
	private static final EntityManager em = emf.createEntityManager();
	private static final EntityTransaction et = em.getTransaction();

	/**
	 * save method used to save non-existing student with non-existing and existing
	 * subjects.
	 * 
	 * @param student  : Student
	 * @param subjects : List<Subject>
	 */
	public static void save(Student student, List<Subject> subjects) {
		student.setSubjects(subjects);
		et.begin();
		if (em.find(Student.class, student.getId()) == null) {
			em.persist(student);
			for (Subject subject : subjects) {
				if (em.find(Subject.class, subject.getId()) == null) {
					em.persist(subject);
				}
			}
		} else {
			System.out.println("Student already exists");
		}
		et.commit();
	}

	public static void fetchStudent(int sid) {

	}

	public static void fetchSubject(int sid) {

	}

	public static Student getStudentObj(int sid, String name) {
		Student s = new Student();
		s.setId(sid);
		s.setName(name);
		return s;
	}

	public static Subject getSubjectObj(int sid, String name) {
		Subject s = new Subject();
		s.setId(sid);
		s.setName(name);
		return s;
	}
}
