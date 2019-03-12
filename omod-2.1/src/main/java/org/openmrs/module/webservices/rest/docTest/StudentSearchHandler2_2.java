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

import org.apache.commons.lang3.StringUtils;
import org.openmrs.module.webservices.rest.web.RequestContext;
import org.openmrs.module.webservices.rest.web.RestConstants;
import org.openmrs.module.webservices.rest.web.resource.api.PageableResult;
import org.openmrs.module.webservices.rest.web.resource.api.SearchConfig;
import org.openmrs.module.webservices.rest.web.resource.api.SearchHandler;
import org.openmrs.module.webservices.rest.web.resource.api.SearchQuery;
import org.openmrs.module.webservices.rest.web.resource.impl.EmptySearchResult;
import org.openmrs.module.webservices.rest.web.resource.impl.NeedsPaging;
import org.openmrs.module.webservices.rest.web.response.ResponseException;
import org.springframework.stereotype.Component;

@Component
public class StudentSearchHandler2_2 implements SearchHandler {
	
	StudentService serv = new StudentServiceImpl();
	
	private final SearchConfig searchConfig = new SearchConfig("default", RestConstants.VERSION_1
	        + "/student",
	        Arrays.asList("1.8.*", "1.9.*", "1.10.*", "1.11.*", "1.12.*", "2.0.*", "2.1.*", "2.2.*"),
	        Arrays.asList(new SearchQuery.Builder("Allows you to find allstudents or only living patients")
	                .withRequiredParameters("all").build()));
	
	@Override
	public SearchConfig getSearchConfig() {
		return searchConfig;
	}
	
	@Override
	public PageableResult search(RequestContext context) throws ResponseException {
		String includeDeadstr = context.getParameter("all");
		
		Boolean includeDead = StringUtils.isNotBlank(includeDeadstr) ? Boolean.parseBoolean(includeDeadstr) : false;
		//List<Student> allPatients = Context.getService(StudentService.class).getallStudents();
		List<Student> allPatients = serv.getallStudents();
		
		if (includeDead) {
			if (allPatients != null && allPatients.size() > 0) {
				return new NeedsPaging<Student>(allPatients, context);
			}
			
		}
		else
		{
			if (allPatients != null && allPatients.size() > 0) {
				return new NeedsPaging<Student>(allPatients, context);
			}
			
		}
		return new EmptySearchResult();
	}
}
