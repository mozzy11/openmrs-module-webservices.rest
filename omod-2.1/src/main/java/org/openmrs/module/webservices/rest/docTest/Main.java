/**
 * This Source Code Form is subject to the terms of the Mozilla Public License,
 * v. 2.0. If a copy of the MPL was not distributed with this file, You can
 * obtain one at http://mozilla.org/MPL/2.0/. OpenMRS is also distributed under
 * the terms of the Healthcare Disclaimer located at http://openmrs.org/license.
 *
 * Copyright (C) OpenMRS Inc. OpenMRS is a registered trademark and the OpenMRS
 * graphic logo is a trademark of OpenMRS Inc.
 */
package org.openmrs.module.webservices.rest.docTest;

import java.util.List;

public class Main {
	
	public static void main(String[] args) {
		//StudentService serv =Context.getService( StudentService.class);
		StudentService serv = new StudentServiceImpl();
		/*String u = new String();
		serv.addStudent("moses", "mutesa", "kats");
		serv.addStudent("moses2", "mutesa2", "kats2");
		serv.addStudent("moses3", "mutesa3", "kats3");
		
		List<Student> students = serv.getallStudents();
		
		for (Student student : students) {
			System.out.println("Id :" + student.getId());
			System.out.println("First name :" + student.getFirst_Name());
			System.out.println("Last name :" + student.getLast_name());
			System.out.println("School :" + student.getSchool());
			System.out.println("uuid :" + student.getUuid());
			System.out.println(".................");
			u = student.getUuid();
			
		}   */
		/*	System.out.println(">>>Updated .................");
			try {
				Student update = serv.updateStudentName(1, "update");
				System.out.println("Id :" + update.getId());
				System.out.println("First name :" + update.getFirst_Name());
				System.out.println("Last name :" + update.getLast_name());
				System.out.println("School :" + update.getSchool());
			}
			catch (NullPointerException e) {
				// TODO Auto-generated catch block
				System.out.println("Student id  doent exist");
			}
			System.out.println("................."); 
			
			System.out.println(">>>Get a student .................");
			try {
				Student update = serv.getStudent(2);
				System.out.println("Id :" + update.getId());
				System.out.println("First name :" + update.getFirst_Name());
				System.out.println("Last name :" + update.getLast_name());
				System.out.println("School :" + update.getSchool());
			}
			catch (NullPointerException e) {
				// TODO Auto-generated catch block
				System.out.println("Student id  doent exist");
			}
			*/
		/*	System.out.println(">>>Get a student by uuid.................");
			
			try {
				Student update = serv.getStudent(u);
				System.out.println("Id :" + update.getId());
				System.out.println("First name :" + update.getFirst_Name());
				System.out.println("Last name :" + update.getLast_name());
				System.out.println("School :" + update.getSchool());
			}
			catch (NullPointerException e) {
				// TODO Auto-generated catch block
				System.out.println("Student uuid  doent exist");
			}*/
		
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>Get a student by query.................");
		
		List<Student> studs = serv.getallStudents("ya");
		
		for (Student student : studs) {
			System.out.println("Id :" + student.getId());
			System.out.println("type >>> :" + student.getId().getClass());
			System.out.println("First name :" + student.getFirst_Name());
			System.out.println("Last name :" + student.getLast_name());
			System.out.println("School :" + student.getSchool());
			System.out.println("uuid :" + student.getUuid().getClass());
			System.out.println(".................");
			
		}
	}
	
}
