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

import org.openmrs.module.webservices.rest.web.RequestContext;
import org.openmrs.module.webservices.rest.web.RestConstants;
import org.openmrs.module.webservices.rest.web.annotation.PropertyGetter;
import org.openmrs.module.webservices.rest.web.annotation.SubResource;
import org.openmrs.module.webservices.rest.web.representation.DefaultRepresentation;
import org.openmrs.module.webservices.rest.web.representation.FullRepresentation;
import org.openmrs.module.webservices.rest.web.representation.RefRepresentation;
import org.openmrs.module.webservices.rest.web.representation.Representation;
import org.openmrs.module.webservices.rest.web.resource.api.PageableResult;
import org.openmrs.module.webservices.rest.web.resource.impl.DelegatingResourceDescription;
import org.openmrs.module.webservices.rest.web.resource.impl.DelegatingSubResource;
import org.openmrs.module.webservices.rest.web.resource.impl.NeedsPaging;
import org.openmrs.module.webservices.rest.web.response.ResourceDoesNotSupportOperationException;
import org.openmrs.module.webservices.rest.web.response.ResponseException;

import io.swagger.models.Model;
import io.swagger.models.ModelImpl;
import io.swagger.models.properties.BooleanProperty;
import io.swagger.models.properties.IntegerProperty;
import io.swagger.models.properties.StringProperty;

@SubResource(path = "adress", parent = StudentResource2_1.class, supportedClass = Adress.class, supportedOpenmrsVersions =
{ "1.8.*", "1.9.*", "1.10.*", "1.11.*", "1.12.*", "2.0.*", "2.1.*", "2.2.*" })
public class StudentAdressResource2_1 extends DelegatingSubResource<Adress, Student, StudentResource2_1> {
	
	AdressService serv = new AdressService();
	
	StudentServiceImpl sp = new StudentServiceImpl();
	
	@Override
	public Adress newDelegate() {
		// TODO Auto-generated method stub
		return new Adress();
	}
	
	@Override
	public Adress save(Adress delegate) {
		serv.AddAdress(delegate);
		return delegate;
	}
	
	@Override
	public Student getParent(Adress instance) {
		// TODO Auto-generated method stub
		return sp.getStudent(instance.getId());
	}
	
	@Override
	public void setParent(Adress instance, Student parent) {
		instance.setId(parent.getId());
		
	}
	
	@Override
	public PageableResult doGetAll(Student parent, RequestContext context) throws ResponseException {
		List<Adress> sts = serv.getallAdresses();
		return new NeedsPaging<Adress>(sts, context);
	}
	
	@Override
	public Adress getByUniqueId(String uniqueId) {
		return serv.getAdress(uniqueId);
	}
	
	@Override
	protected void delete(Adress delegate, String reason, RequestContext context) throws ResponseException {
		throw new ResourceDoesNotSupportOperationException();
		
	}
	
	@Override
	public void purge(Adress delegate, RequestContext context) throws ResponseException {
		throw new ResourceDoesNotSupportOperationException();
		
	}
	
	@Override
	public DelegatingResourceDescription getRepresentationDescription(Representation rep) {
		if (rep instanceof DefaultRepresentation) {
			DelegatingResourceDescription description = new DelegatingResourceDescription();
			description.addProperty("display");
			description.addProperty("uuid");
			description.addProperty("voided");
			description.addProperty("village");
			description.addProperty("country");
			description.addSelfLink();
			description.addLink("full", ".?v=" + RestConstants.REPRESENTATION_FULL);
			return description;
			
		}
		else if (rep instanceof FullRepresentation) {
			DelegatingResourceDescription description = new DelegatingResourceDescription();
			description.addProperty("uuid");
			description.addProperty("display");
			description.addProperty("voided");
			description.addProperty("id");
			description.addProperty("village");
			description.addProperty("country");
			description.addProperty("auditInfo");
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
		description.addRequiredProperty("village");
		description.addRequiredProperty("country");
		return description;
	}
	
	@Override
	public DelegatingResourceDescription getUpdatableProperties() throws ResourceDoesNotSupportOperationException {
		DelegatingResourceDescription description = new DelegatingResourceDescription();
		description.addProperty("village");
		description.addProperty("country");
		return description;
	}
	
	public Model getGETModel(Representation rep) {
		ModelImpl modelImpl = (ModelImpl) super.getGETModel(rep);
		if (rep instanceof DefaultRepresentation || rep instanceof FullRepresentation) {
			modelImpl
			        .property("uuid", new StringProperty())
			        .property("display", new StringProperty())
			        .property("village", new StringProperty())
			        .property("country", new StringProperty())
			        .property("voided", new BooleanProperty());
			
		}
		if (rep instanceof DefaultRepresentation) {
			modelImpl
			        //			        .property("display", new StringProperty())
			        .property("uuid", new StringProperty())
			        .property("display", new StringProperty())
			        .property("voided", new BooleanProperty())
			        .property("village", new StringProperty())
			        .property("country", new StringProperty());
		} else if (rep instanceof FullRepresentation) {
			modelImpl
			        //			        .property("display", new StringProperty())
			        .property("uuid", new StringProperty())
			        .property("display", new StringProperty())
			        .property("voided", new BooleanProperty())
			        .property("auditInfo", new StringProperty())
			        .property("id", new IntegerProperty())
			        .property("village", new StringProperty())
			        .property("country", new StringProperty());
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
		        .property("village", new StringProperty())
		        .property("country", new StringProperty());
		return model;
	}
	
	@Override
	public Model getUPDATEModel(Representation representation) {
		return new ModelImpl()
		        .property("village", new StringProperty())
		        .property("country", new StringProperty());
	}
	
	@PropertyGetter("display")
	public String getDisplayString(Adress st) {
		
		return st.getCountry();
	}
	
	@PropertyGetter("auditInfo")
	public String getAudit(Adress st) {
		return st.getVillage() + "Auditor";
	}
	
}
