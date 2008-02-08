/*
 * Copyright (C) 2007 <A href="http://www-ist.massey.ac.nz/JBDietrich" target="_top">Jens Dietrich</a>
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

package nz.org.take.script;

/**
 * Declaration of an object reference.
 * @author <a href="http://www-ist.massey.ac.nz/JBDietrich/">Jens Dietrich</a>
 */

public class RefDeclaration extends Declaration  {
	public String toString() {
		StringBuffer b = new StringBuffer();
		b.append("var ");
		b.append(this.getType());
		b.append(" ");
		boolean f = true;
		for (String n:this.getNames()) {
			if (f)
				f = false;
			else 
				b.append(',');
			b.append(n);	
		}
		return b.toString();
	}

	
}