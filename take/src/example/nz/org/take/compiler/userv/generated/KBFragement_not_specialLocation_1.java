package example.nz.org.take.compiler.userv.generated;

import nz.org.take.rt.*;


/**
 * Class generated by the take compiler.
 * @version Tue Feb 05 13:19:25 NZDT 2008
 */
@SuppressWarnings("unchecked")
class KBFragement_not_specialLocation_1 {
    /**
     * Method generated for query /specialLocation[in]
     * @param slot1 input parameter generated from slot 0
     * @return an iterator for instances of not_specialLocation
    */
    public static ResultSet<not_specialLocation> not_specialLocation_1(
        final example.nz.org.take.compiler.userv.domainmodel.Driver slot1) {
        DerivationController _derivation = new DefaultDerivationController();
        ResultSet<not_specialLocation> _result = new ResultSet(KBFragement_not_specialLocation_1.not_specialLocation_1(
                    slot1, _derivation), _derivation);

        return _result;
    }

    /**
     * Method generated for negated simple predicates.
     * Negation is interpreted as negation as failure (NAF).
     * Code generated using velocity template NAFNegatedSimplePredicate.vm
    */
    static ResourceIterator<not_specialLocation> not_specialLocation_1(
        example.nz.org.take.compiler.userv.domainmodel.Driver slot1,
        DerivationController _derivation) {
        _derivation.log("negated prerequisite", DerivationController.NAF, slot1);

        boolean _exist = false;
        boolean _hasNoResult = true;
        nz.org.take.rt.ResultSet<specialLocation> _result = KBFragement_specialLocation_1.specialLocation_1(slot1);

        if (_result.hasNext()) {
            _hasNoResult = false;
        }

        _result.close();

        if (_hasNoResult) {
            not_specialLocation _record = new not_specialLocation();
            _record.slot1 = slot1;

            return new nz.org.take.rt.SingletonIterator<not_specialLocation>(_record);
        } else {
            return nz.org.take.rt.EmptyIterator.DEFAULT;
        }
    }
}
