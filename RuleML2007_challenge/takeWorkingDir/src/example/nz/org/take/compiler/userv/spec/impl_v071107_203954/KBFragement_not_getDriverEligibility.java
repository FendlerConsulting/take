package example.nz.org.take.compiler.userv.spec.impl_v071107_203954;

import example.nz.org.take.compiler.userv.spec.*;

import nz.org.take.rt.*;


/**
 * Class generated by the take compiler.
 * @version Wed Nov 07 20:39:56 NZDT 2007
 */
@SuppressWarnings("unchecked")
class KBFragement_not_getDriverEligibility {
    /**
     * Method generated for query /isEligible[in]
     * @param driver input parameter generated from slot 0
     * @return an iterator for instances of not_DriverEligibility
    */
    public static ResultSet<not_DriverEligibility> not_getDriverEligibility(
        final example.nz.org.take.compiler.userv.domainmodel.Driver driver) {
        DerivationController _derivation = new DefaultDerivationController();
        ResultSet<not_DriverEligibility> _result = new ResultSet(KBFragement_not_getDriverEligibility.not_getDriverEligibility(
                    driver, _derivation), _derivation);

        return _result;
    }

    /**
     * Method generated for negated simple predicates.
     * Negation is interpreted as negation as failure (NAF).
     * Code generated using velocity template NAFNegatedSimplePredicate.vm
    */
    static ResourceIterator<not_DriverEligibility> not_getDriverEligibility(
        example.nz.org.take.compiler.userv.domainmodel.Driver driver,
        DerivationController _derivation) {
        _derivation.log("negated prerequisite", DerivationController.NAF, driver);

        boolean _exist = false;
        boolean _hasNoResult = true;
        nz.org.take.rt.ResultSet<DriverEligibility> _result = KBFragement_getDriverEligibility.getDriverEligibility(driver);

        if (_result.hasNext()) {
            _hasNoResult = false;
        }

        _result.close();

        if (_hasNoResult) {
            not_DriverEligibility _record = new not_DriverEligibility();
            _record.driver = driver;

            return new nz.org.take.rt.SingletonIterator<not_DriverEligibility>(_record);
        } else {
            return nz.org.take.rt.EmptyIterator.DEFAULT;
        }
    }
}
