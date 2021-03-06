package test.nz.org.take.compiler.scenario11.generated;

import nz.org.take.rt.*;


/**
 * Interface generated by the take compiler.
 * @version Fri Feb 01 14:27:23 NZDT 2008
 */
@SuppressWarnings("unchecked")
public interface KB {
    /**
     * Method generated for query /hasCategory[in,out]
     * @param bean input parameter generated from slot 0
     * @return an iterator for instances of HasCategory
    */
    public ResultSet<HasCategory> hasCategory(
        final test.nz.org.take.compiler.scenario11.Bean bean);

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
