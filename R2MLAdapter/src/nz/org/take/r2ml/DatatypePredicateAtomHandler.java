/*
 * Copyright (C) 2007 Bastian Schenke (bastian.schenke(at)gmail.com) and 
 * <a href="http://www-ist.massey.ac.nz/JBDietrich" target="_top">Jens Dietrich</a>
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 */
package nz.org.take.r2ml;

import de.tu_cottbus.r2ml.DatatypePredicateAtom;

/**
 * @author Bastian Schenke (bastian.schenke@googlemail.com)
 * TODO implement this Handler
 */
class DatatypePredicateAtomHandler implements XmlTypeHandler {

	/**
	 * Map a 
	 * 
	 * TODO implement protected DataArguments dataArguments;
	 * TODO implement protected QName datatypePredicateID;
	 * TODO implement protected Boolean isNegated;
	 * 
	 * @param obj
	 *            a 
	 * @return a 
	 * 
	 * @see nz.org.take.r2ml.XmlTypeHandler#importObject(java.lang.Object,
	 *      nz.org.take.r2ml.R2MLDriver)
	 */
	public Object importObject(Object obj)
			throws R2MLException {
		DatatypePredicateAtom atom = (DatatypePredicateAtom)obj;
		return null;
	}

}
