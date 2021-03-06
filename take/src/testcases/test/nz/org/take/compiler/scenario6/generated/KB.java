package test.nz.org.take.compiler.scenario6.generated;

import nz.org.take.rt.*;


/**
 * Interface generated by the take compiler.
 * @version Fri Feb 01 11:31:56 NZDT 2008
 */
@SuppressWarnings("unchecked")
public interface KB {
    /**
     * Method generated for query /is_father_of[in,out]
     * @param son input parameter generated from slot 0
     * @return an iterator for instances of IsFatherOf
    */
    public ResultSet<IsFatherOf> getFather(
        final test.nz.org.take.compiler.scenario6.Person son);

    /**
     * Method generated for query /is_father_of[out,in]
     * @param father input parameter generated from slot 1
     * @return an iterator for instances of IsFatherOf
    */
    public ResultSet<IsFatherOf> getSons(
        final test.nz.org.take.compiler.scenario6.Person father);

    /**
     * Method generated for query /is_grandfather_of[in,out]
     * @param grandson input parameter generated from slot 0
     * @return an iterator for instances of IsGrandfatherOf
    */
    public ResultSet<IsGrandfatherOf> getGrandfather(
        final test.nz.org.take.compiler.scenario6.Person grandson);

    /**
     * Method generated for query /is_grandfather_of[out,in]
     * @param grandfather input parameter generated from slot 1
     * @return an iterator for instances of IsGrandfatherOf
    */
    public ResultSet<IsGrandfatherOf> getGrandchildren(
        final test.nz.org.take.compiler.scenario6.Person grandfather);

    /**
    * Method that can be used to query annotations at runtime.
    * @param id the id of the rule (or other knowledge element)
    * @return a map of annotations (string-string mappings)
    * code generated using velocity template LocalAnnotationMethod.vm
    */
    public java.util.Map<String, String> getAnnotations(String id);

    /**
     * Method that can be used to query global annotations at runtime.
     * Global annotations are attached to the knowledge base, not to
     * a particular element (rule,..).
     * @return a map of annotations (string-string mappings)
     * code generated using velocity template GlobalAnnotationMethod.vm
    */
    public java.util.Map<String, String> getAnnotations();
}
