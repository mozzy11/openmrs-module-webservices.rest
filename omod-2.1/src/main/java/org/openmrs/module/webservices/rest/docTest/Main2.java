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

public class Main2 {
	
	public static void main(String[] args) {
		
		Adress ad1 = new Adress();
		ad1.setVillage("kasana");
		ad1.setCountry("ug");
		
		Adress ad2 = new Adress();
		ad2.setVillage("chikago");
		ad2.setCountry("us");
		
		AdressService serv = new AdressService();
		serv.AddAdress(ad1);
		serv.AddAdress(ad2);
		
		String uuid = new String();
		System.out.println(">>>> ALL ads..................");
		for (Adress ad : serv.getallAdresses()) {
			System.out.println("ID:" + ad.getId());
			System.out.println("village :" + ad.getVillage());
			System.out.println("country :" + ad.getCountry());
			System.out.println("UUID:" + ad.getUuid());
			System.out.println("..................");
			uuid = ad.getUuid();
		}
		
		System.out.println(">>>> ALL ads from search..................");
		for (Adress ad : serv.getallAdresses("yo")) {
			System.out.println("ID:" + ad.getId());
			System.out.println("village :" + ad.getVillage());
			System.out.println("country :" + ad.getCountry());
			System.out.println("UUID:" + ad.getUuid());
			System.out.println("..................");
			uuid = ad.getUuid();
		}
		
		Adress ad3 = serv.getAdress(uuid);
		System.out.println(">>>> GET single add..................");
		System.out.println("ID:" + ad3.getId());
		System.out.println("village :" + ad3.getVillage());
		System.out.println("country :" + ad3.getCountry());
		System.out.println("UUID:" + ad3.getUuid());
		System.out.println("..................");
		
	}
	
}
