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

import org.openmrs.api.OpenmrsService;

public interface StudentService extends OpenmrsService {
	
	public List<Student> getallStudents();
	
	public void addStudent(String f_Name, String l_name, String school);
	
	public void addStudent(Student st);
	
	public Student updateStudentName(Integer id, String name);
	
	public Student getStudent(Integer student_id);
	
	public Student getStudent(String uuid);
	
	public List<Student> getallStudents(String q);
	
}
