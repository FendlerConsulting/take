package example.nz.org.take.compiler.userv.spec.impl_v071107_031153;

import example.nz.org.take.compiler.userv.spec.*;

import nz.org.take.rt.*;


/**
 * Class generated by the take compiler.
 * @version Wed Nov 07 03:11:56 GMT 2007
 */
@SuppressWarnings("unchecked")
class KBFragement_not_isNew_1 {
    /**
     * Method generated for query /isNew[in]
     * @param slot1 input parameter generated from slot 0
     * @return an iterator for instances of not_isNew
    */
    public static ResultSet<not_isNew> not_isNew_1(
        final example.nz.org.take.compiler.userv.domainmodel.Car slot1) {
        DerivationController _derivation = new DefaultDerivationController();
        ResultSet<not_isNew> _result = new ResultSet(KBFragement_not_isNew_1.not_isNew_1(
                    slot1, _derivation), _derivation);

        return _result;
    }

    /**
     * Method generated for negated simple predicates.
     * Negation is interpreted as negation as failure (NAF).
     * Code generated using velocity template NAFNegatedSimplePredicate.vm
    */
    static ResourceIterator<not_isNew> not_isNew_1(
        example.nz.org.take.compiler.userv.domainmodel.Car slot1,
        DerivationController _derivation) {
        _derivation.log("negated prerequisite", DerivationController.NAF, slot1);

        boolean _exist = false;
        boolean _hasNoResult = true;
        nz.org.take.rt.ResultSet<isNew> _result = KBFragement_isNew_1.isNew_1(slot1);

        if (_result.hasNext()) {
            _hasNoResult = false;
        }

        _result.close();

        if (_hasNoResult) {
            not_isNew _record = new not_isNew();
            _record.slot1 = slot1;

            return new nz.org.take.rt.SingletonIterator<not_isNew>(_record);
        } else {
            return nz.org.take.rt.EmptyIterator.DEFAULT;
        }
    }
}
