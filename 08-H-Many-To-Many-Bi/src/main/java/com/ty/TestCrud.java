package com.ty;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TestCrud {
	private static final Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("===========Welcome to Crud app===========");
		while (true) {

			System.out.println("Enter 1 to Save");
			System.out.println("enter 2 to fetch Student");
			System.out.println("enter 3 to fetch Subject");
			System.out.println("enter 4 to delete Student");
			System.out.println("enter 5 to delete Subject");
			System.out.println("enter 7 to exit");

			int choice = sc.nextInt();

			switch (choice) {
			case 1: {
				save();
			}
				break;

			case 2: {
				// fetch operation
			}
				break;
			case 5: {
				// delete subject
				System.out.println("enter the subject id to delete");
				int sid = sc.nextInt();
				CRUD.deleteSubject(sid);
			}
				break;
			case 7: {
				// to exit app
				System.out.println("Thank you!!!!!!");
				return;
			}
			default:
				System.out.println("invalid input");
				break;
			}

		}
	}

	public static void save() {
		System.out.println("enter student id : ");
		int sid = sc.nextInt();
		System.out.println("enter student name : ");
		String name = sc.next();
		Student student = CRUD.getStudentObj(sid, name);

		System.out.println("===========Assign subject=============");
		List<Subject> subjects = new ArrayList<Subject>();
		System.out.println("enter the no. subjects");
		int num = sc.nextInt();
		for (int i = 0; i < num; i++) {
			System.out.println("enter subject id : ");
			int subid = sc.nextInt();
			System.out.println("enter subject name : ");
			String sname = sc.next();
			subjects.add(CRUD.getSubjectObj(subid, sname));
		}

		CRUD.save(student, subjects);
		System.out.println("saved");
	}

}
