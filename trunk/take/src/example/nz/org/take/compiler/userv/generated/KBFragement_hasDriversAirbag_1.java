package example.nz.org.take.compiler.userv.generated;

import nz.org.take.rt.*;


/**
 * Class generated by the take compiler.
 * @version Mon Aug 20 21:59:11 NZST 2007
 */
@SuppressWarnings("unchecked")
class KBFragement_hasDriversAirbag_1 {
    /**
     * Method generated for query hasDriversAirbag[in]
     * @param slot1 input parameter generated from slot 0
     * @return an iterator for instances of _hasDriversAirbag
    */
    public static ResultSet<_hasDriversAirbag> hasDriversAirbag_1(
        final example.nz.org.take.compiler.userv.domainmodel.Car slot1) {
        DerivationController _derivation = new DefaultDerivationController();
        ResultSet<_hasDriversAirbag> _result = new ResultSet(KBFragement_hasDriversAirbag_1.hasDriversAirbag_1(
                    slot1, _derivation), _derivation);

        return _result;
    }

    /**
     * Method generated for query hasDriversAirbag[in]
     * @param source
     * @param target
     * @return an iterator
     * code generated using velocity template nz/org/take/compiler/reference/JPredicate_11.vm
    */
    static ResourceIterator<_hasDriversAirbag> hasDriversAirbag_1(
        final example.nz.org.take.compiler.userv.domainmodel.Car slot1,
        final DerivationController _derivation) {
        _derivation.log("public boolean example.nz.org.take.compiler.userv.domainmodel.Car.hasDriversAirbag()",
            DerivationController.JAVA_METHOD);

        if (slot1.hasDriversAirbag()) {
            _hasDriversAirbag result = new _hasDriversAirbag();
            result.slot1 = slot1;

            return new SingletonIterator<_hasDriversAirbag>(result);
        }

        return EmptyIterator.DEFAULT;
    }
}