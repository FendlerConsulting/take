package test.nz.org.take.r2ml.scenario1.generated;

import nz.org.take.rt.*;


/**
 * Interface generated by the take compiler.
 * @version Wed Jun 13 10:43:05 NZST 2007
 */
@SuppressWarnings("unchecked")
public interface FamilyKB {
    /**
     * Method generated for query /isFather[in,in]
     * @param son input parameter generated from slot 0
     * @param father input parameter generated from slot 1
     * @return an iterator for instances of _isFather
    */
    public ResultSet<_isFather> isFather_11(
        final test.nz.org.take.r2ml.scenario1.Person son,
        final test.nz.org.take.r2ml.scenario1.Person father);
}
