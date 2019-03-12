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

import java.io.Serializable;

import org.openmrs.BaseOpenmrsData;

public class Student extends BaseOpenmrsData implements Serializable {
	
	public static final long serialVersionUID = 1L;
	
	private Integer Student_id;
	
	private String school;
	
	private String first_Name;
	
	private String last_name;
	
	private Adress adress;
	
	/**
	 * @return the adress
	 */
	public Adress getAdress() {
		return adress;
	}
	
	/**
	 * @param adress the adress to set
	 */
	public void setAdress(Adress adress) {
		this.adress = adress;
	}
	
	/**
	 * @return the school
	 */
	public String getSchool() {
		return school;
	}
	
	/**
	 * @param school the school to set
	 */
	public void setSchool(String school) {
		this.school = school;
	}
	
	/**
	 * @return the first_Name
	 */
	public String getFirst_Name() {
		return first_Name;
	}
	
	/**
	 * @param first_Name the first_Name to set
	 */
	public void setFirst_Name(String first_Name) {
		this.first_Name = first_Name;
	}
	
	/**
	 * @return the last_name
	 */
	public String getLast_name() {
		return last_name;
	}
	
	/**
	 * @param last_name the last_name to set
	 */
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	
	@Override
	public Integer getId() {
		// TODO Auto-generated method stub
		return Student_id;
	}
	
	@Override
	public void setId(Integer Student_id) {
		this.Student_id = Student_id;
		
	}
	
}
