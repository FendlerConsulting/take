package example.nz.org.take.compiler.userv.generated;

import nz.org.take.rt.*;


/**
 * Class generated by the take compiler.
 * @version Mon Feb 11 13:49:17 NZDT 2008
 */
@SuppressWarnings("unchecked")
class KBFragement_isMale_1 {
    /**
     * Method generated for query isMale[in]
     * @param slot1 input parameter generated from slot 0
     * @return an iterator for instances of isMale
    */
    public static ResultSet<isMale> isMale_1(
        final example.nz.org.take.compiler.userv.domainmodel.Driver slot1) {
        DerivationController _derivation = new DefaultDerivationController();
        ResultSet<isMale> _result = new ResultSet(KBFragement_isMale_1.isMale_1(
                    slot1, _derivation), _derivation);

        return _result;
    }

    /**
     * Method generated for query isMale[in]
     * @param source
     * @param target
     * @return an iterator
     * code generated using velocity template JPredicate_11.vm
    */
    static ResourceIterator<isMale> isMale_1(
        final example.nz.org.take.compiler.userv.domainmodel.Driver slot1,
        final DerivationController _derivation) {
        _derivation.log("public boolean example.nz.org.take.compiler.userv.domainmodel.Driver.isMale()",
            DerivationController.JAVA_METHOD);

        if (slot1.isMale()) {
            isMale result = new isMale();
            result.slot1 = slot1;

            return new SingletonIterator<isMale>(result);
        }

        return EmptyIterator.DEFAULT;
    }
}
