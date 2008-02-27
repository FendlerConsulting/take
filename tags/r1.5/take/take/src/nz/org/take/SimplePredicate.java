/**
 * Copyright 2007 Jens Dietrich Licensed under the Apache License, Version 2.0 (the "License"); 
 * you may not use this file except in compliance with the License. 
 * You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0 
 * Unless required by applicable law or agreed to in writing, software distributed under the 
 * License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, 
 * either express or implied. See the License for the specific language governing permissions 
 * and limitations under the License.
 */

package nz.org.take;

import java.util.Arrays;

/**
 * Simple explicit predicate. The semantics of this predicate is given by explicit facts and rules.
 * @author <a href="http://www-ist.massey.ac.nz/JBDietrich/">Jens Dietrich</a>
 */

public class SimplePredicate extends AbstractPredicate {

	private String name;
	private Class[] slotTypes;
	@Override
	public int hashCode() {
		final int PRIME = 31;
		int result = 1;
		result = PRIME * result + ((name == null) ? 0 : name.hashCode());
		result = PRIME * result + (negated ? 1231 : 1237);
		result = PRIME * result + Arrays.hashCode(slotTypes);
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final SimplePredicate other = (SimplePredicate) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (negated != other.negated)
			return false;
		if (!Arrays.equals(slotTypes, other.slotTypes))
			return false;
		return true;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Class[] getSlotTypes() {
		return slotTypes;
	}
	public void setSlotTypes(Class[] slotTypes) {
		this.slotTypes = slotTypes;
	}

	
	public String toString() {
		// use UML syntax for derivated properties
		return "/"+name;
	}
	/**
	 * Get a copy of this predicate.
	 * @return
	 */
	public SimplePredicate copy() {
		SimplePredicate copy = new SimplePredicate();
		copy.slotTypes = this.getSlotTypes();
		copy.slotNames = this.getSlotNames();
		copy.name = this.getName();
		// copy.annotations = this.getAnnotations();
		copy.negated = this.isNegated();
		return copy;
	}
	
}