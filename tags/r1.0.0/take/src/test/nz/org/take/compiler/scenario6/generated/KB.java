package test.nz.org.take.compiler.scenario6.generated;
import nz.org.take.rt.*;
/**
 * Interface generated by the take compiler. 
 * @version Fri Jun 01 21:18:31 NZST 2007
 */
@SuppressWarnings("unchecked")
public interface KB{
/**
 * Method generated for query /is_father_of[in,out]
 * @param son input parameter generated from slot 0
 * @return an iterator for instances of IsFatherOf
*/
public ResultSet<IsFatherOf> getFather(final test.nz.org.take.compiler.scenario6.Person son)
;
/**
 * Method generated for query /is_father_of[out,in]
 * @param father input parameter generated from slot 1
 * @return an iterator for instances of IsFatherOf
*/
public ResultSet<IsFatherOf> getSons(final test.nz.org.take.compiler.scenario6.Person father)
;
/**
 * Method generated for query /is_grandfather_of[in,out]
 * @param grandson input parameter generated from slot 0
 * @return an iterator for instances of IsGrandfatherOf
*/
public ResultSet<IsGrandfatherOf> getGrandfather(final test.nz.org.take.compiler.scenario6.Person grandson)
;
/**
 * Method generated for query /is_grandfather_of[out,in]
 * @param grandfather input parameter generated from slot 1
 * @return an iterator for instances of IsGrandfatherOf
*/
public ResultSet<IsGrandfatherOf> getGrandchildren(final test.nz.org.take.compiler.scenario6.Person grandfather)
;
}