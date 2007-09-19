package example.nz.org.take.compiler.userv.generated;

import nz.org.take.rt.*;


/**
 * Class generated by the take compiler.
 * @version Wed Sep 19 21:51:56 NZST 2007
 */
@SuppressWarnings("unchecked")
class KBFragement_greater_than_ii_11 {
    /**
     * Method generated for query greater_than_ii[in,in]
     * @param nz.org.take.compiler.reference.Slot@364641
     * @param nz.org.take.compiler.reference.Slot@13e754f
     * @return an iterator
     * code generated using velocity template Comparison_11.vm
    */
    static ResourceIterator<greater_than_ii> greater_than_ii_11(
        final int slot1, final int slot2, final DerivationController _derivation) {
        _derivation.log(">", DerivationController.COMPARISON);

        if (slot1 > slot2) {
            greater_than_ii result = new greater_than_ii();
            result.slot1 = slot1;
            result.slot2 = slot2;

            return new SingletonIterator<greater_than_ii>(result);
        }

        return EmptyIterator.DEFAULT;
    }
}
