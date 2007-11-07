package example.nz.org.take.compiler.userv.spec.impl_v071107_203954;

import example.nz.org.take.compiler.userv.spec.*;

import nz.org.take.rt.*;


/**
 * Class generated by the take compiler.
 * @version Wed Nov 07 20:39:56 NZDT 2007
 */
@SuppressWarnings("unchecked")
class KBFragement_not_getDriverCategory {
    /**
     * Method generated for query /driverCategory[in,in]
     * @param driver input parameter generated from slot 0
     * @param category input parameter generated from slot 1
     * @return an iterator for instances of not_DriverCategory
    */
    public static ResultSet<not_DriverCategory> not_getDriverCategory(
        final example.nz.org.take.compiler.userv.domainmodel.Driver driver,
        final java.lang.String category) {
        DerivationController _derivation = new DefaultDerivationController();
        ResultSet<not_DriverCategory> _result = new ResultSet(KBFragement_not_getDriverCategory.not_getDriverCategory(
                    driver, category, _derivation), _derivation);

        return _result;
    }

    /**
     * Method generated for negated simple predicates.
     * Negation is interpreted as negation as failure (NAF).
     * Code generated using velocity template NAFNegatedSimplePredicate.vm
    */
    static ResourceIterator<not_DriverCategory> not_getDriverCategory(
        example.nz.org.take.compiler.userv.domainmodel.Driver driver,
        java.lang.String category, DerivationController _derivation) {
        _derivation.log("negated prerequisite", DerivationController.NAF,
            driver, category);

        boolean _exist = false;
        boolean _hasNoResult = true;
        nz.org.take.rt.ResultSet<DriverCategory> _result = KBFragement_getDriverCategory.getDriverCategory(driver,
                category);

        if (_result.hasNext()) {
            _hasNoResult = false;
        }

        _result.close();

        if (_hasNoResult) {
            not_DriverCategory _record = new not_DriverCategory();
            _record.driver = driver;
            _record.category = category;

            return new nz.org.take.rt.SingletonIterator<not_DriverCategory>(_record);
        } else {
            return nz.org.take.rt.EmptyIterator.DEFAULT;
        }
    }
}