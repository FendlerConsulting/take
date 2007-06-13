package test.nz.org.take.r2ml.scenario3.generated;

import nz.org.take.rt.*;


/**
 * Interface generated by the take compiler.
 * @version Tue Jun 12 22:39:54 NZST 2007
 */
@SuppressWarnings("unchecked")
public interface FamilyKB {
    /**
     * Method generated for query /isFather[in,out]
     * @param son input parameter generated from slot 0
     * @return an iterator for instances of _isFather
    */
    public ResultSet<_isFather> isFather_10(final java.lang.String son);

    /**
     * Method generated for query /isFather[out,in]
     * @param father input parameter generated from slot 1
     * @return an iterator for instances of _isFather
    */
    public ResultSet<_isFather> isFather_01(final java.lang.String father);

    /**
     * Method generated for query /isGrandfather[in,out]
     * @param grandson input parameter generated from slot 0
     * @return an iterator for instances of _isGrandfather
    */
    public ResultSet<_isGrandfather> isGrandfather_10(
        final java.lang.String grandson);

    /**
     * Method generated for query /isGrandfather[out,in]
     * @param grandfather input parameter generated from slot 1
     * @return an iterator for instances of _isGrandfather
    */
    public ResultSet<_isGrandfather> isGrandfather_01(
        final java.lang.String grandfather);
}