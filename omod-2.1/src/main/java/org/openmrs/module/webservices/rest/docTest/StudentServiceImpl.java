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

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.openmrs.api.impl.BaseOpenmrsService;

public class StudentServiceImpl extends BaseOpenmrsService implements StudentService {
	
	List<Student> students = new ArrayList<Student>();
	
	Integer id = 0;
	
	@Override
	public List<Student> getallStudents() {
		
		File file = new File("C:\\Users\\Dell\\Desktop\\git comanda\\rest");
		File[] fList = file.listFiles();
		
		if (fList != null) {
			Student st = new Student();
			for (File f : fList) {
				try
				{
					FileInputStream fileIn = new FileInputStream("C:\\Users\\Dell\\Desktop\\git comanda\\rest\\"
					        + f.getName());
					ObjectInputStream in = new ObjectInputStream(fileIn);
					st = (Student) in.readObject();
					in.close();
					fileIn.close();
				}
				catch (Exception i)
				{
					i.printStackTrace();
				}
				
				students.add(st);
			}
			
		}
		return students;
	}
	
	@Override
	public Student updateStudentName(Integer id, String l_name) {
		for (Student st : getallStudents()) {
			if (StringUtils.equals(id.toString(), st.getId().toString())) {
				st.setFirst_Name(l_name);
				return st;
			}
			
		}
		return null;
	}
	
	@Override
	public Student getStudent(Integer student_id) {
		for (Student st : getallStudents()) {
			if (StringUtils.equals(student_id.toString(), st.getId().toString())) {
				return st;
			}
		}
		return null;
	}
	
	@Override
	public void addStudent(Student st) {
		id++;
		st.setId(id);
		//students.add(st);
		try
		{
			FileOutputStream fileOut =
			        new FileOutputStream("C:\\Users\\Dell\\Desktop\\git comanda\\rest\\rest" + id + ".txt");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(st);
			out.close();
			fileOut.close();
		}
		catch (IOException i)
		{
			i.printStackTrace();
		}
		
	}
	
	@Override
	public void addStudent(String f_Name, String l_name, String school) {
		
		id++;
		Student student = new Student();
		student.setId(id);
		student.setFirst_Name(f_Name);
		student.setLast_name(l_name);
		student.setSchool(school);
		//students.add(student);
		
		try
		{
			FileOutputStream fileOut =
			        new FileOutputStream("C:\\Users\\Dell\\Desktop\\git comanda\\rest\\rest" + id + ".txt");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(student);
			out.close();
			fileOut.close();
		}
		catch (IOException i)
		{
			i.printStackTrace();
		}
	}
	
	@Override
	public Student getStudent(String uuid) {
		for (Student st : getallStudents()) {
			if (StringUtils.equals(st.getUuid(), uuid)) {
				return st;
			}
		}
		return null;
	}
	
	@Override
	public List<Student> getallStudents(String q) {
		if (StringUtils.isNotEmpty(q) && StringUtils.equals(q, "ya")) {
			
			return getallStudents();
		}
		return null;
	}
	
}
