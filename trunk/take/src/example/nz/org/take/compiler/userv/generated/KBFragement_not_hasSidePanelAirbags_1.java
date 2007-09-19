package example.nz.org.take.compiler.userv.generated;

import nz.org.take.rt.*;


/**
 * Class generated by the take compiler.
 * @version Wed Sep 19 21:51:56 NZST 2007
 */
@SuppressWarnings("unchecked")
class KBFragement_not_hasSidePanelAirbags_1 {
    /**
     * Method generated for query hasSidePanelAirbags[in]
     * @param slot1 input parameter generated from slot 0
     * @return an iterator for instances of not_hasSidePanelAirbags
    */
    public static ResultSet<not_hasSidePanelAirbags> not_hasSidePanelAirbags_1(
        final example.nz.org.take.compiler.userv.domainmodel.Car slot1) {
        DerivationController _derivation = new DefaultDerivationController();
        ResultSet<not_hasSidePanelAirbags> _result = new ResultSet(KBFragement_not_hasSidePanelAirbags_1.not_hasSidePanelAirbags_1(
                    slot1, _derivation), _derivation);

        return _result;
    }

    /**
     * Method generated for query hasSidePanelAirbags[in]
     * @param source
     * @param target
     * @return an iterator
     * code generated using velocity template JPredicate_11_neg.vm
    */
    static ResourceIterator<not_hasSidePanelAirbags> not_hasSidePanelAirbags_1(
        final example.nz.org.take.compiler.userv.domainmodel.Car slot1,
        final DerivationController _derivation) {
        _derivation.log("public boolean example.nz.org.take.compiler.userv.domainmodel.Car.hasSidePanelAirbags()",
            DerivationController.JAVA_METHOD);

        if (!slot1.hasSidePanelAirbags()) {
            not_hasSidePanelAirbags result = new not_hasSidePanelAirbags();
            result.slot1 = slot1;

            return new SingletonIterator<not_hasSidePanelAirbags>(result);
        }

        return EmptyIterator.DEFAULT;
    }
}
