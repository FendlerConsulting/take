package example.nz.org.take.compiler.userv.generated;

import nz.org.take.rt.*;


/**
 * Class generated by the take compiler.
 * @version Mon Feb 11 13:49:17 NZDT 2008
 */
@SuppressWarnings("unchecked")
class KBFragement_includesUninsuredMotoristCoverage_1 {
    /**
     * Method generated for query includesUninsuredMotoristCoverage[in]
     * @param slot1 input parameter generated from slot 0
     * @return an iterator for instances of includesUninsuredMotoristCoverage
    */
    public static ResultSet<includesUninsuredMotoristCoverage> includesUninsuredMotoristCoverage_1(
        final example.nz.org.take.compiler.userv.domainmodel.Policy slot1) {
        DerivationController _derivation = new DefaultDerivationController();
        ResultSet<includesUninsuredMotoristCoverage> _result = new ResultSet(KBFragement_includesUninsuredMotoristCoverage_1.includesUninsuredMotoristCoverage_1(
                    slot1, _derivation), _derivation);

        return _result;
    }

    /**
     * Method generated for query includesUninsuredMotoristCoverage[in]
     * @param source
     * @param target
     * @return an iterator
     * code generated using velocity template JPredicate_11.vm
    */
    static ResourceIterator<includesUninsuredMotoristCoverage> includesUninsuredMotoristCoverage_1(
        final example.nz.org.take.compiler.userv.domainmodel.Policy slot1,
        final DerivationController _derivation) {
        _derivation.log("public boolean example.nz.org.take.compiler.userv.domainmodel.Policy.includesUninsuredMotoristCoverage()",
            DerivationController.JAVA_METHOD);

        if (slot1.includesUninsuredMotoristCoverage()) {
            includesUninsuredMotoristCoverage result = new includesUninsuredMotoristCoverage();
            result.slot1 = slot1;

            return new SingletonIterator<includesUninsuredMotoristCoverage>(result);
        }

        return EmptyIterator.DEFAULT;
    }
}
