package example.nz.org.take.compiler.userv.generated;

import nz.org.take.rt.*;


/**
 * Class generated by the take compiler.
 * @version Thu Aug 16 11:26:52 NZST 2007
 */
@SuppressWarnings("unchecked")
class KBFragement_hasFrontPassengerAirbag_1 {
    /**
     * Method generated for query hasFrontPassengerAirbag[in]
     * @param slot1 input parameter generated from slot 0
     * @return an iterator for instances of _hasFrontPassengerAirbag
    */
    public static ResultSet<_hasFrontPassengerAirbag> hasFrontPassengerAirbag_1(
        final example.nz.org.take.compiler.userv.domainmodel.Car slot1) {
        DerivationController _derivation = new DefaultDerivationController();
        ResultSet<_hasFrontPassengerAirbag> _result = new ResultSet(KBFragement_hasFrontPassengerAirbag_1.hasFrontPassengerAirbag_1(
                    slot1, _derivation), _derivation);

        return _result;
    }

    /**
     * Method generated for query hasFrontPassengerAirbag[in]
     * @param source
     * @param target
     * @return an iterator
     * code generated using velocity template nz/org/take/compiler/reference/JPredicate_11.vm
    */
    static ResourceIterator<_hasFrontPassengerAirbag> hasFrontPassengerAirbag_1(
        final example.nz.org.take.compiler.userv.domainmodel.Car slot1,
        final DerivationController _derivation) {
        _derivation.log("public boolean example.nz.org.take.compiler.userv.domainmodel.Car.hasFrontPassengerAirbag()",
            DerivationController.JAVA_METHOD);

        if (slot1.hasFrontPassengerAirbag()) {
            _hasFrontPassengerAirbag result = new _hasFrontPassengerAirbag();
            result.slot1 = slot1;

            return new SingletonIterator<_hasFrontPassengerAirbag>(result);
        }

        return EmptyIterator.DEFAULT;
    }
}
