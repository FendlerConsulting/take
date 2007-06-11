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

import de.tu_cottbus.r2ml.ObjectVariable;
import nz.org.take.Variable;

class ObjectVariableHandler implements XmlTypeHandler {

	public Object importObject(Object obj, MappingContext context,
			R2MLDriver driver) throws R2MLException {
		ObjectVariable oVar = (ObjectVariable)obj;
		Variable var = context.getVariable(oVar.getName());
		if (var != null)
			return var;
		Class type = driver.getDatatypeMapper().getType(oVar.getClassID());
		try {
			if (driver.logger.isInfoEnabled()) {
				driver.logger.info("Create new Variable ("
						+ oVar.getName() + ":"
						+ type.getSimpleName() + ").");
			}
			var = new Variable();
			var.setName(oVar.getName());
			var.setType(type);
		} catch (NullPointerException e) {
			String msg = "No Class specified for " + oVar.getClassID().toString() + ".";
			throw new R2MLException(msg, e);			
		}
		context.addVariable(oVar.getName(), var);
		return var;
	}

}