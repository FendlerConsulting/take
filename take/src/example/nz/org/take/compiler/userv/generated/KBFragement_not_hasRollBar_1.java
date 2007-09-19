package example.nz.org.take.compiler.userv.generated;

import nz.org.take.rt.*;


/**
 * Class generated by the take compiler.
 * @version Wed Sep 19 15:44:48 NZST 2007
 */
@SuppressWarnings("unchecked")
class KBFragement_not_hasRollBar_1 {
    /**
     * Method generated for query hasRollBar[in]
     * @param slot1 input parameter generated from slot 0
     * @return an iterator for instances of not_hasRollBar
    */
    public static ResultSet<not_hasRollBar> not_hasRollBar_1(
        final example.nz.org.take.compiler.userv.domainmodel.Car slot1) {
        DerivationController _derivation = new DefaultDerivationController();
        ResultSet<not_hasRollBar> _result = new ResultSet(KBFragement_not_hasRollBar_1.not_hasRollBar_1(
                    slot1, _derivation), _derivation);

        return _result;
    }

    /**
     * Method generated for query hasRollBar[in]
     * @param source
     * @param target
     * @return an iterator
     * code generated using velocity template JPredicate_11_neg.vm
    */
    static ResourceIterator<not_hasRollBar> not_hasRollBar_1(
        final example.nz.org.take.compiler.userv.domainmodel.Car slot1,
        final DerivationController _derivation) {
        _derivation.log("public boolean example.nz.org.take.compiler.userv.domainmodel.Car.hasRollBar()",
            DerivationController.JAVA_METHOD);

        if (!slot1.hasRollBar()) {
            not_hasRollBar result = new not_hasRollBar();
            result.slot1 = slot1;

            return new SingletonIterator<not_hasRollBar>(result);
        }

        return EmptyIterator.DEFAULT;
    }
}
