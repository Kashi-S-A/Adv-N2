package com.spring.XmlAndAnn;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestA {

	public static void main(String[] args) {
		ConfigurableApplicationContext app = new ClassPathXmlApplicationContext("config1.xml");

		Employee employee = (Employee) app.getBean("employee");

		employee.work();

		System.out.println("=========================================");

		CollegeApp ca = (CollegeApp) app.getBean("collegeApp");

		ca.admission();

		System.out.println("=========================================");

		RCB rcb = (RCB) app.getBean("myRCB");// default bean id : RCB

		rcb.play();

		System.out.println("=========================================");

		RCB bean = app.getBean(RCB.class);

		bean.play();
	}
}
