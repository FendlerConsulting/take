package example.nz.org.take.compiler.userv.generated;

import nz.org.take.rt.*;


/**
 * Class generated by the take compiler.
 * @version Thu Sep 13 12:50:58 NZST 2007
 */
@SuppressWarnings("unchecked")
class KBFragement_includesMedicalCoverage_1 {
    /**
     * Method generated for query includesMedicalCoverage[in]
     * @param slot1 input parameter generated from slot 0
     * @return an iterator for instances of includesMedicalCoverage
    */
    public static ResultSet<includesMedicalCoverage> includesMedicalCoverage_1(
        final example.nz.org.take.compiler.userv.domainmodel.Policy slot1) {
        DerivationController _derivation = new DefaultDerivationController();
        ResultSet<includesMedicalCoverage> _result = new ResultSet(KBFragement_includesMedicalCoverage_1.includesMedicalCoverage_1(
                    slot1, _derivation), _derivation);

        return _result;
    }

    /**
     * Method generated for query includesMedicalCoverage[in]
     * @param source
     * @param target
     * @return an iterator
     * code generated using velocity template JPredicate_11.vm
    */
    static ResourceIterator<includesMedicalCoverage> includesMedicalCoverage_1(
        final example.nz.org.take.compiler.userv.domainmodel.Policy slot1,
        final DerivationController _derivation) {
        _derivation.log("public boolean example.nz.org.take.compiler.userv.domainmodel.Policy.includesMedicalCoverage()",
            DerivationController.JAVA_METHOD);

        if (slot1.includesMedicalCoverage()) {
            includesMedicalCoverage result = new includesMedicalCoverage();
            result.slot1 = slot1;

            return new SingletonIterator<includesMedicalCoverage>(result);
        }

        return EmptyIterator.DEFAULT;
    }
}