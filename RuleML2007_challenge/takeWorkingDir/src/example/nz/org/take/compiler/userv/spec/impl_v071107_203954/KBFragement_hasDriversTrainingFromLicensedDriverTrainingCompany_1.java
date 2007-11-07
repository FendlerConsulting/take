package example.nz.org.take.compiler.userv.spec.impl_v071107_203954;

import example.nz.org.take.compiler.userv.spec.*;

import nz.org.take.rt.*;


/**
 * Class generated by the take compiler.
 * @version Wed Nov 07 20:39:56 NZDT 2007
 */
@SuppressWarnings("unchecked")
class KBFragement_hasDriversTrainingFromLicensedDriverTrainingCompany_1 {
    /**
     * Method generated for query hasDriversTrainingFromLicensedDriverTrainingCompany[in]
     * @param slot1 input parameter generated from slot 0
     * @return an iterator for instances of hasDriversTrainingFromLicensedDriverTrainingCompany
    */
    public static ResultSet<hasDriversTrainingFromLicensedDriverTrainingCompany> hasDriversTrainingFromLicensedDriverTrainingCompany_1(
        final example.nz.org.take.compiler.userv.domainmodel.Driver slot1) {
        DerivationController _derivation = new DefaultDerivationController();
        ResultSet<hasDriversTrainingFromLicensedDriverTrainingCompany> _result = new ResultSet(KBFragement_hasDriversTrainingFromLicensedDriverTrainingCompany_1.hasDriversTrainingFromLicensedDriverTrainingCompany_1(
                    slot1, _derivation), _derivation);

        return _result;
    }

    /**
     * Method generated for query hasDriversTrainingFromLicensedDriverTrainingCompany[in]
     * @param source
     * @param target
     * @return an iterator
     * code generated using velocity template JPredicate_11.vm
    */
    static ResourceIterator<hasDriversTrainingFromLicensedDriverTrainingCompany> hasDriversTrainingFromLicensedDriverTrainingCompany_1(
        final example.nz.org.take.compiler.userv.domainmodel.Driver slot1,
        final DerivationController _derivation) {
        _derivation.log("public boolean example.nz.org.take.compiler.userv.domainmodel.Driver.hasDriversTrainingFromLicensedDriverTrainingCompany()",
            DerivationController.JAVA_METHOD);

        if (slot1.hasDriversTrainingFromLicensedDriverTrainingCompany()) {
            hasDriversTrainingFromLicensedDriverTrainingCompany result = new hasDriversTrainingFromLicensedDriverTrainingCompany();
            result.slot1 = slot1;

            return new SingletonIterator<hasDriversTrainingFromLicensedDriverTrainingCompany>(result);
        }

        return EmptyIterator.DEFAULT;
    }
}