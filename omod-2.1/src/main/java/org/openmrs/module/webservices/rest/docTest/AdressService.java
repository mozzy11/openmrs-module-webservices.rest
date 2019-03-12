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

public class AdressService {
	
	Integer id = 0;
	
	public List<Adress> ads = new ArrayList<Adress>();
	
	public Adress getAdress(String uuid) {
		for (Adress ad : getallAdresses()) {
			if (StringUtils.equals(ad.getUuid(), uuid)) {
				return ad;
			}
		}
		return null;
		
	}
	
	public List<Adress> getallAdresses() {
		
		File file = new File("C:\\Users\\Dell\\Desktop\\git comanda\\Subrest");
		File[] fList = file.listFiles();
		
		if (fList != null) {
			Adress ad = new Adress();
			for (File f : fList) {
				try
				{
					FileInputStream fileIn = new FileInputStream("C:\\Users\\Dell\\Desktop\\git comanda\\Subrest\\"
					        + f.getName());
					ObjectInputStream in = new ObjectInputStream(fileIn);
					ad = (Adress) in.readObject();
					in.close();
					fileIn.close();
				}
				catch (Exception i)
				{
					i.printStackTrace();
				}
				
				ads.add(ad);
			}
			
		}
		return ads;
	}
	
	public void AddAdress(Adress ad) {
		id++;
		ad.setId(id);
		try
		{
			FileOutputStream fileOut =
			        new FileOutputStream("C:\\Users\\Dell\\Desktop\\git comanda\\Subrest\\rest" + id + ".txt");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(ad);
			out.close();
			fileOut.close();
		}
		catch (IOException i)
		{
			i.printStackTrace();
		}
		
		;
	}
	
	public List<Adress> getallAdresses(String q) {
		if (StringUtils.isNotEmpty(q) && StringUtils.equals(q, "yo")) {
			
			return getallAdresses();
		}
		return null;
	}
	
}
