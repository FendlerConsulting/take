package example.nz.org.take.compiler.userv.generated;

import nz.org.take.rt.*;


/**
 * Class generated by the take compiler.
 * @version Fri Feb 01 12:12:07 NZDT 2008
 */
@SuppressWarnings("unchecked")
class KBFragement_hasDriversAirbag_1 {
    /**
     * Method generated for query hasDriversAirbag[in]
     * @param slot1 input parameter generated from slot 0
     * @return an iterator for instances of hasDriversAirbag
    */
    public static ResultSet<hasDriversAirbag> hasDriversAirbag_1(
        final example.nz.org.take.compiler.userv.domainmodel.Car slot1) {
        DerivationController _derivation = new DefaultDerivationController();
        ResultSet<hasDriversAirbag> _result = new ResultSet(KBFragement_hasDriversAirbag_1.hasDriversAirbag_1(
                    slot1, _derivation), _derivation);

        return _result;
    }

    /**
     * Method generated for query hasDriversAirbag[in]
     * @param source
     * @param target
     * @return an iterator
     * code generated using velocity template JPredicate_11.vm
    */
    static ResourceIterator<hasDriversAirbag> hasDriversAirbag_1(
        final example.nz.org.take.compiler.userv.domainmodel.Car slot1,
        final DerivationController _derivation) {
        _derivation.log("public boolean example.nz.org.take.compiler.userv.domainmodel.Car.hasDriversAirbag()",
            DerivationController.JAVA_METHOD);

        if (slot1.hasDriversAirbag()) {
            hasDriversAirbag result = new hasDriversAirbag();
            result.slot1 = slot1;

            return new SingletonIterator<hasDriversAirbag>(result);
        }

        return EmptyIterator.DEFAULT;
    }
}
