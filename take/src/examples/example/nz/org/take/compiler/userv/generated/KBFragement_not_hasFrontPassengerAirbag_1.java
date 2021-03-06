package example.nz.org.take.compiler.userv.generated;

import nz.org.take.rt.*;


/**
 * Class generated by the take compiler.
 * @version Mon Feb 11 13:49:17 NZDT 2008
 */
@SuppressWarnings("unchecked")
class KBFragement_not_hasFrontPassengerAirbag_1 {
    /**
     * Method generated for query hasFrontPassengerAirbag[in]
     * @param slot1 input parameter generated from slot 0
     * @return an iterator for instances of not_hasFrontPassengerAirbag
    */
    public static ResultSet<not_hasFrontPassengerAirbag> not_hasFrontPassengerAirbag_1(
        final example.nz.org.take.compiler.userv.domainmodel.Car slot1) {
        DerivationController _derivation = new DefaultDerivationController();
        ResultSet<not_hasFrontPassengerAirbag> _result = new ResultSet(KBFragement_not_hasFrontPassengerAirbag_1.not_hasFrontPassengerAirbag_1(
                    slot1, _derivation), _derivation);

        return _result;
    }

    /**
     * Method generated for query hasFrontPassengerAirbag[in]
     * @param source
     * @param target
     * @return an iterator
     * code generated using velocity template JPredicate_11_neg.vm
    */
    static ResourceIterator<not_hasFrontPassengerAirbag> not_hasFrontPassengerAirbag_1(
        final example.nz.org.take.compiler.userv.domainmodel.Car slot1,
        final DerivationController _derivation) {
        _derivation.log("public boolean example.nz.org.take.compiler.userv.domainmodel.Car.hasFrontPassengerAirbag()",
            DerivationController.JAVA_METHOD);

        if (!slot1.hasFrontPassengerAirbag()) {
            not_hasFrontPassengerAirbag result = new not_hasFrontPassengerAirbag();
            result.slot1 = slot1;

            return new SingletonIterator<not_hasFrontPassengerAirbag>(result);
        }

        return EmptyIterator.DEFAULT;
    }
}
