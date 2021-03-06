/*
 * Copyright 2007 Bastian Schenke Licensed under the Apache License, Version 2.0 (the "License"); 
 * you may not use this file except in compliance with the License. 
 * You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0 
 * Unless required by applicable law or agreed to in writing, software distributed under the 
 * License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, 
 * either express or implied. See the License for the specific language governing permissions 
 * and limitations under the License.
 */
package nz.org.take.r2ml;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import org.apache.log4j.Logger;

import de.tu_cottbus.r2ml.RuleBase;

import nz.org.take.KnowledgeBase;
import nz.org.take.KnowledgeElement;
import nz.org.take.KnowledgeSource;
import nz.org.take.Query;
import nz.org.take.TakeException;
import nz.org.take.r2ml.util.QueryGenerator;
import nz.org.take.r2ml.util.RuleBaseFilter;

public class R2MLKnowledgeSource implements KnowledgeSource {

	private Reader reader = null;

	private R2MLDriver driver = null;

	private KnowledgeBase kb = null;

	private RuleBase rb = null;

	private QueryGenerator queryGenerator = null;

	private R2MLKnowledgeSource() {
		super();
		this.driver = R2MLDriver.get();
	}

	public R2MLKnowledgeSource(Reader reader) {
		this();
		this.reader = reader;
	}

	public R2MLKnowledgeSource(InputStream in) {
		this();
		if (in == null)
			throw new NullPointerException("InputStream not found.");
		this.reader = new InputStreamReader(in);
	}

	public R2MLKnowledgeSource(File file) throws FileNotFoundException {
		this();
		this.reader = new FileReader(file);
	}

	public R2MLKnowledgeSource(String fileName) throws FileNotFoundException {
		this();
		File file = new File(fileName);
		this.reader = new FileReader(file);
	}

	public R2MLKnowledgeSource(RuleBase ruleBase) {
		this();
		this.rb = ruleBase;
	}
	
	/**
	 * Get a knowledge base.
	 * @param generateQuerries if true generate all possible querries for all supported predicates else dont
	 * 
	 * @return a knowledge base
	 */
	public KnowledgeBase getKnowledgeBase() throws TakeException {
		if (driver.logger.isDebugEnabled())
			driver.logger.debug("starting mapping process");
		if (kb == null) {
			if (rb == null) {
				if (driver.logger.isDebugEnabled())
					driver.logger.debug("loading rule base");
				unmarshallRuleBase();
			}
//			System.out.println("import rulebase");
			kb = driver.importKB(rb);
//			System.out.println("rulebase imported");
			if(driver.logger.isDebugEnabled())
				driver.logger.debug("KnowledgeBase imported.");
			if (queryGenerator != null )
				queryGenerator.generateQueries(kb);
		}
//		System.out.println("kb created");
		if (driver.logger.isDebugEnabled())
			driver.logger.debug("knowledge base created was " + kb!=null?"successful!":"not succesful!");
		return kb;
	}

	@SuppressWarnings("unchecked")
	private void unmarshallRuleBase() throws R2MLException {

		try {
			JAXBContext jc2 = JAXBContext
					.newInstance("de.tu_cottbus.r2ml:de.tu_cottbus.r2ml.r2mlv:de.tu_cottbus.dc");
			Unmarshaller um = jc2.createUnmarshaller();
			rb = ((JAXBElement<RuleBase>) um.unmarshal(reader)).getValue();
		} catch (JAXBException e) {
			throw new R2MLException("XML parsing error", e);
		} catch (ClassCastException cce) {
			cce.printStackTrace();
			throw new R2MLException("Unmarshalled object has wrong type.", cce);
		}

	}

	public void setSlotNameGenerator(NameMapper nameMapper) {
		driver.setNameMapper(nameMapper);
	}

	public void setDatatypeMapper(DatatypeMapper datatypeMapper) {
		driver.setDatatypeMapper(datatypeMapper);
	}

	public boolean addKnowledge(KnowledgeElement e) {
		try {
			getKnowledgeBase().add(e);
		} catch (TakeException e1) {
			return false;
		}
		return true;
	}

	public boolean addKnowledge(List<KnowledgeElement> es) {
		boolean ret = true;
		for (KnowledgeElement e : es)
			if (!addKnowledge(e))
				ret = false;
		return ret;
	}

	public void addQuery(Query query) throws TakeException {
		getKnowledgeBase().add(query);
	}

	public void addQueries(List<Query> querries) throws TakeException {
		for (Query q : querries)
			addQuery(q);
	}

	public boolean addKnowledge(KnowledgeBase extraKnowledge)
			throws TakeException {
		boolean ret = true;
		addQueries(extraKnowledge.getQueries());
		if (!addKnowledge(extraKnowledge.getElements()))
			ret = false;
		try {
			getKnowledgeBase().addAnnotations(extraKnowledge.getAnnotations());
		} catch (TakeException e) {
			ret = false;
		}
		return ret;
	}

	public void setQueryGenerator(QueryGenerator queryGenerator) {
		this.queryGenerator = queryGenerator;
		
	}

	public void setPropertyMode(int propertyMode) {
		driver.setPropertyMode(propertyMode);
	}

}
