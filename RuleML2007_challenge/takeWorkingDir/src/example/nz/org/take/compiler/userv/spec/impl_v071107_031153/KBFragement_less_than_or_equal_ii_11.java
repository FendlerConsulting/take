package example.nz.org.take.compiler.userv.spec.impl_v071107_031153;

import example.nz.org.take.compiler.userv.spec.*;

import nz.org.take.rt.*;


/**
 * Class generated by the take compiler.
 * @version Wed Nov 07 03:11:56 GMT 2007
 */
@SuppressWarnings("unchecked")
class KBFragement_less_than_or_equal_ii_11 {
    /**
     * Method generated for query less_than_or_equal_ii[in,in]
     * @param nz.org.take.compiler.reference.Slot@775121
     * @param nz.org.take.compiler.reference.Slot@16f70a4
     * @return an iterator
     * code generated using velocity template Comparison_11.vm
    */
    static ResourceIterator<less_than_or_equal_ii> less_than_or_equal_ii_11(
        final int slot1, final int slot2, final DerivationController _derivation) {
        _derivation.log("<=", DerivationController.COMPARISON);

        if (slot1 <= slot2) {
            less_than_or_equal_ii result = new less_than_or_equal_ii();
            result.slot1 = slot1;
            result.slot2 = slot2;

            return new SingletonIterator<less_than_or_equal_ii>(result);
        }

        return EmptyIterator.DEFAULT;
    }
}
