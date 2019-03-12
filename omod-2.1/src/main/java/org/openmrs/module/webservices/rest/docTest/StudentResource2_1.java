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

import java.util.Arrays;
import java.util.List;

import org.openmrs.module.webservices.rest.web.RequestContext;
import org.openmrs.module.webservices.rest.web.RestConstants;
import org.openmrs.module.webservices.rest.web.annotation.PropertyGetter;
import org.openmrs.module.webservices.rest.web.annotation.PropertySetter;
import org.openmrs.module.webservices.rest.web.annotation.Resource;
import org.openmrs.module.webservices.rest.web.representation.DefaultRepresentation;
import org.openmrs.module.webservices.rest.web.representation.FullRepresentation;
import org.openmrs.module.webservices.rest.web.representation.RefRepresentation;
import org.openmrs.module.webservices.rest.web.representation.Representation;
import org.openmrs.module.webservices.rest.web.resource.api.PageableResult;
import org.openmrs.module.webservices.rest.web.resource.impl.DataDelegatingCrudResource;
import org.openmrs.module.webservices.rest.web.resource.impl.DelegatingResourceDescription;
import org.openmrs.module.webservices.rest.web.resource.impl.NeedsPaging;
import org.openmrs.module.webservices.rest.web.response.ResourceDoesNotSupportOperationException;
import org.openmrs.module.webservices.rest.web.response.ResponseException;

import io.swagger.models.Model;
import io.swagger.models.ModelImpl;
import io.swagger.models.properties.BooleanProperty;
import io.swagger.models.properties.IntegerProperty;
import io.swagger.models.properties.RefProperty;
import io.swagger.models.properties.StringProperty;

@Resource(name = RestConstants.VERSION_1 + "/student", supportedClass = Student.class, supportedOpenmrsVersions = {
        "2.0.*", "2.1.*", "2.2.*" })
public class StudentResource2_1 extends DataDelegatingCrudResource<Student> {
	
	StudentServiceImpl serv = new StudentServiceImpl();
	
	AdressService sp = new AdressService();
	
	@Override
	public DelegatingResourceDescription getRepresentationDescription(Representation rep) {
		if (rep instanceof DefaultRepresentation) {
			DelegatingResourceDescription description = new DelegatingResourceDescription();
			description.addProperty("display");
			description.addProperty("uuid");
			description.addProperty("voided");
			description.addProperty("school");
			description.addProperty("first_Name");
			description.addProperty("last_name");
			description.addProperty("adress", Representation.REF);
			description.addSelfLink();
			description.addLink("full", ".?v=" + RestConstants.REPRESENTATION_FULL);
			return description;
			
		}
		else if (rep instanceof FullRepresentation) {
			DelegatingResourceDescription description = new DelegatingResourceDescription();
			description.addProperty("uuid");
			description.addProperty("display");
			description.addProperty("voided");
			description.addProperty("Student_id");
			description.addProperty("school");
			description.addProperty("first_Name");
			description.addProperty("last_name");
			description.addProperty("auditInfo");
			description.addProperty("adress", Representation.DEFAULT);
			description.addSelfLink();
			return description;
		}
		else if (rep instanceof RefRepresentation) {
			DelegatingResourceDescription description = new DelegatingResourceDescription();
			description.addProperty("uuid");
			description.addProperty("display");
			description.addSelfLink();
			return description;
		}
		return null;
	}
	
	@Override
	public DelegatingResourceDescription getCreatableProperties() {
		DelegatingResourceDescription description = new DelegatingResourceDescription();
		description.addRequiredProperty("school");
		description.addRequiredProperty("first_Name");
		description.addProperty("last_name");
		description.addProperty("adress");
		return description;
	}
	
	@Override
	public DelegatingResourceDescription getUpdatableProperties() throws ResourceDoesNotSupportOperationException {
		DelegatingResourceDescription description = new DelegatingResourceDescription();
		description.addProperty("first_Name");
		return description;
	}
	
	public Model getGETModel(Representation rep) {
		ModelImpl modelImpl = (ModelImpl) super.getGETModel(rep);
		if (rep instanceof DefaultRepresentation || rep instanceof FullRepresentation) {
			modelImpl
			        .property("uuid", new StringProperty())
			        .property("display", new StringProperty())
			        .property("school", new StringProperty())
			        .property("first_Name", new StringProperty())
			        .property("voided", new BooleanProperty())
			        .property("last_name", new StringProperty())
			        .property("adress", new RefProperty("#/definitions/StudentAdressGetRef"));
			
		}
		if (rep instanceof DefaultRepresentation) {
			modelImpl
			        //			        .property("display", new StringProperty())
			        .property("uuid", new StringProperty())
			        .property("display", new StringProperty())
			        .property("school", new StringProperty())
			        .property("voided", new BooleanProperty())
			        .property("first_Name", new StringProperty())
			        .property("last_name", new StringProperty())
			        .property("adress", new RefProperty("#/definitions/StudentAdressGet"));
		} else if (rep instanceof FullRepresentation) {
			modelImpl
			        //			        .property("display", new StringProperty())
			        .property("uuid", new StringProperty())
			        .property("display", new StringProperty())
			        .property("voided", new BooleanProperty())
			        .property("auditInfo", new StringProperty())
			        .property("Student_id", new IntegerProperty())
			        .property("school", new StringProperty())
			        .property("first_Name", new StringProperty())
			        .property("last_name", new StringProperty());
		}
		else if (rep instanceof RefRepresentation) {
			modelImpl
			        .property("display", new StringProperty())
			        .property("uuid", new StringProperty());
			
		}
		return modelImpl;
	}
	
	@Override
	public Model getCREATEModel(Representation representation) {
		ModelImpl model = new ModelImpl()
		        .property("school", new StringProperty())
		        .property("first_Name", new StringProperty())
		        .property("last_name", new StringProperty())
		        .property("adress", new RefProperty("#/definitions/StudentAdressCreate"));
		return model;
	}
	
	@Override
	public Model getUPDATEModel(Representation representation) {
		return new ModelImpl()
		        .property("first_Name", new StringProperty());
	}
	
	@Override
	public Student newDelegate() {
		// TODO Auto-generated method stub
		return new Student();
	}
	
	@Override
	public Student save(Student delegate) {
		//Context.getService(StudentService.class).addStudent(delegate);
		serv.addStudent(delegate);
		return delegate;
	}
	
	@PropertyGetter("display")
	public String getDisplayString(Student st) {
		
		return st.getFirst_Name();
	}
	
	@PropertyGetter("auditInfo")
	public String getAudit(Student st) {
		return st.getFirst_Name() + "Auditor";
	}
	
	@Override
	public Student getByUniqueId(String uniqueId) {
		
		//return Context.getService(StudentService.class).getStudent(uniqueId);
		return serv.getStudent(uniqueId);
	}
	
	@Override
	protected void delete(Student delegate, String reason, RequestContext context) throws ResponseException {
		throw new ResourceDoesNotSupportOperationException();
		
	}
	
	@Override
	public void purge(Student delegate, RequestContext context) throws ResponseException {
		throw new ResourceDoesNotSupportOperationException();
		
	}
	
	@Override
	protected NeedsPaging<Student> doSearch(RequestContext context) {
		return new NeedsPaging<Student>(serv.getallStudents(context.getParameter("q")), context);
	}
	
	@Override
	public PageableResult doGetAll(RequestContext context) {
		List<Student> sts = serv.getallStudents();
		return new NeedsPaging<Student>(sts, context);
	}
	
	@PropertySetter("adress")
	public static void setMappings(Student instance, List<Adress> ads) {
		for (Adress ad : ads) {
			ad.setId(instance.getId());
		}
	}
	
	@PropertyGetter("adress")
	public List<Adress> getMappings(Student instance) {
		
		return sp.getallAdresses();
	}
	
	@Override
	public List<String> getPropertiesToExposeAsSubResources() {
		return Arrays.asList("adress");
	}
}
