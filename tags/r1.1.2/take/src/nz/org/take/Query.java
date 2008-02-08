/*
 * Copyright (C) 2006 <A href="http://www-ist.massey.ac.nz/JBDietrich" target="_top">Jens Dietrich</a>
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


package nz.org.take;

import java.util.Arrays;

/**
 * Query interface. A query consists of a predicate and flags classifying 
 * the terms as input or output slots. 
 * For input slots, values are supplied by the application, and therefore 
 * they will be turned into method parameters in the code generated.
 * @author <a href="http://www-ist.massey.ac.nz/JBDietrich/">Jens Dietrich</a>
 */
public class Query extends AbstractAnnotatable implements Visitable {

	private Predicate predicate = null;
	private boolean[] inputParams = null;
	// whether this is a top level public query
	// or a query generated by a compiler
	// these queries can be treated differently
	private boolean isPublic = false;

	public Query() {
		super();
	}
	
	public Query(Predicate predicate,boolean[] params) {
		super();
		assert(params!=null && params.length==predicate.getSlotTypes().length);
		inputParams = params;
		this.predicate = predicate;
	}


	/**
	 * @return Returns the predicate.
	 */
	public Predicate getPredicate() {
		return predicate;
	}


	/**
	 * @return the param input flags.
	 */
	public boolean[] getInputParams() {
		return inputParams;
	}


	/**
	 * @param inputParams The params input flags to set.
	 */
	public void setInputParams(boolean[] inputParams) {
		this.inputParams = inputParams;
	}
	



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(inputParams);
		result = prime * result
				+ ((predicate == null) ? 0 : predicate.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		// careful: do not compare classes with ==
		// one might be an instance of a subclass
		// this is used when the compiler maintains the agenda and
		// instances of (the subclass) QueryRef are used
		if (!(obj instanceof Query))
			return false;
		final Query other = (Query) obj;
		if (!Arrays.equals(inputParams, other.inputParams))
			return false;
		if (predicate == null) {
			if (other.predicate != null)
				return false;
		} else if (!predicate.equals(other.predicate))
			return false;
		return true;
	}

	public void setPredicate(Predicate predicate) {
		this.predicate = predicate;
	}
	
	public String toString() {
		StringBuffer b = new StringBuffer();
		boolean f = true;
		b.append(predicate);
		b.append('[');
		for (boolean io:inputParams) {
			if (f)
				f = false;
			else 
				b.append(',');
			b.append(io?"in":"out");
		}
		b.append(']');
		return b.toString();
	}
	public void accept(KnowledgeBaseVisitor visitor) {
		visitor.visit(this);
		visitor.endVisit(this);
	}
	// get the io signature (input/output params) as string
	public String getIOSignatureAsString () {
		StringBuffer b = new StringBuffer();
		b.append('[');
		boolean f = true;
		for (boolean v:this.inputParams) {
			if (f)
				f=false;
			else 
				b.append(',');
			b.append(v?"in":"out");
			
		}
		b.append(']');
		return b.toString();
		
	}

	public boolean isPublic() {
		return isPublic;
	}

	public void setPublic(boolean isPublic) {
		this.isPublic = isPublic;
	}

}