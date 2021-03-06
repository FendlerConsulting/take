package example.nz.org.take.compiler.userv.generated;

import nz.org.take.rt.*;


/**
 * Class generated by the take compiler.
 * @version Mon Feb 11 13:49:17 NZDT 2008
 */
@SuppressWarnings("unchecked")
class KBFragement_not_hasAirbags_1 {
    /**
     * Method generated for query hasAirbags[in]
     * @param slot1 input parameter generated from slot 0
     * @return an iterator for instances of not_hasAirbags
    */
    public static ResultSet<not_hasAirbags> not_hasAirbags_1(
        final example.nz.org.take.compiler.userv.domainmodel.Car slot1) {
        DerivationController _derivation = new DefaultDerivationController();
        ResultSet<not_hasAirbags> _result = new ResultSet(KBFragement_not_hasAirbags_1.not_hasAirbags_1(
                    slot1, _derivation), _derivation);

        return _result;
    }

    /**
     * Method generated for query hasAirbags[in]
     * @param source
     * @param target
     * @return an iterator
     * code generated using velocity template JPredicate_11_neg.vm
    */
    static ResourceIterator<not_hasAirbags> not_hasAirbags_1(
        final example.nz.org.take.compiler.userv.domainmodel.Car slot1,
        final DerivationController _derivation) {
        _derivation.log("public boolean example.nz.org.take.compiler.userv.domainmodel.Car.hasAirbags()",
            DerivationController.JAVA_METHOD);

        if (!slot1.hasAirbags()) {
            not_hasAirbags result = new not_hasAirbags();
            result.slot1 = slot1;

            return new SingletonIterator<not_hasAirbags>(result);
        }

        return EmptyIterator.DEFAULT;
    }
}
