package example.nz.org.take.compiler.userv.generated;

import nz.org.take.rt.*;


/**
 * Class generated by the take compiler.
 * @version Thu Aug 16 11:26:52 NZST 2007
 */
@SuppressWarnings("unchecked")
class KBFragement_less_than_ii_11 {
    /**
     * Method generated for query less_than_ii[in,in]
     * @param nz.org.take.compiler.reference.Slot@74c3aa
     * @param nz.org.take.compiler.reference.Slot@1d9fd51
     * @return an iterator
     * code generated using velocity template nz/org/take/compiler/reference/Comparison_11.vm
    */
    static ResourceIterator<_less_than_ii> less_than_ii_11(final int slot1,
        final int slot2, final DerivationController _derivation) {
        _derivation.log("<", DerivationController.COMPARISON);

        if (slot1 < slot2) {
            _less_than_ii result = new _less_than_ii();
            result.slot1 = slot1;
            result.slot2 = slot2;

            return new SingletonIterator<_less_than_ii>(result);
        }

        return EmptyIterator.DEFAULT;
    }
}
