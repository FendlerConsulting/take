package test.nz.org.take.r2ml.c.generated;

import nz.org.take.rt.*;


/**
 * Class generated by the take compiler.
 * @version Tue Nov 20 16:02:05 GMT+01:00 2007
 */
@SuppressWarnings("unchecked")
class KBFragement_equals_11 {
    /**
     * Method generated for query equals[in,in]
     * @param slot1 input parameter generated from slot 0
     * @param slot2 input parameter generated from slot 1
     * @return an iterator for instances of equals
    */
    public static ResultSet<equals> equals_11(final java.lang.String slot1,
        final java.lang.Object slot2) {
        DerivationController _derivation = new DefaultDerivationController();
        ResultSet<equals> _result = new ResultSet(KBFragement_equals_11.equals_11(
                    slot1, slot2, _derivation), _derivation);

        return _result;
    }

    /**
     * Method generated for query equals[in,in]
     * @param source
     * @param target
     * @return an iterator
     * code generated using velocity template JPredicate_11.vm
    */
    static ResourceIterator<equals> equals_11(final java.lang.String slot1,
        final java.lang.Object slot2, final DerivationController _derivation) {
        _derivation.log("public boolean java.lang.String.equals(java.lang.Object)",
            DerivationController.JAVA_METHOD);

        if (slot1.equals(slot2)) {
            equals result = new equals();
            result.slot1 = slot1;
            result.slot2 = slot2;

            return new SingletonIterator<equals>(result);
        }

        return EmptyIterator.DEFAULT;
    }
}
