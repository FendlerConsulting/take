package example.nz.org.take.compiler.userv.generated;

import nz.org.take.rt.*;


/**
 * Class generated by the take compiler.
 * @version Thu Sep 06 16:23:42 NZST 2007
 */
@SuppressWarnings("unchecked")
class KBFragement_hasBeenConvictedOfaDUI_1 {
    /**
     * Method generated for query hasBeenConvictedOfaDUI[in]
     * @param slot1 input parameter generated from slot 0
     * @return an iterator for instances of hasBeenConvictedOfaDUI
    */
    public static ResultSet<hasBeenConvictedOfaDUI> hasBeenConvictedOfaDUI_1(
        final example.nz.org.take.compiler.userv.domainmodel.Driver slot1) {
        DerivationController _derivation = new DefaultDerivationController();
        ResultSet<hasBeenConvictedOfaDUI> _result = new ResultSet(KBFragement_hasBeenConvictedOfaDUI_1.hasBeenConvictedOfaDUI_1(
                    slot1, _derivation), _derivation);

        return _result;
    }

    /**
     * Method generated for query hasBeenConvictedOfaDUI[in]
     * @param source
     * @param target
     * @return an iterator
     * code generated using velocity template JPredicate_11.vm
    */
    static ResourceIterator<hasBeenConvictedOfaDUI> hasBeenConvictedOfaDUI_1(
        final example.nz.org.take.compiler.userv.domainmodel.Driver slot1,
        final DerivationController _derivation) {
        _derivation.log("public boolean example.nz.org.take.compiler.userv.domainmodel.Driver.hasBeenConvictedOfaDUI()",
            DerivationController.JAVA_METHOD);

        if (slot1.hasBeenConvictedOfaDUI()) {
            hasBeenConvictedOfaDUI result = new hasBeenConvictedOfaDUI();
            result.slot1 = slot1;

            return new SingletonIterator<hasBeenConvictedOfaDUI>(result);
        }

        return EmptyIterator.DEFAULT;
    }
}
