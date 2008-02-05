package example.nz.org.take.compiler.userv.generated;

import nz.org.take.rt.*;


/**
 * Class generated by the take compiler.
 * @version Tue Feb 05 13:19:25 NZDT 2008
 */
@SuppressWarnings("unchecked")
class KBFragement_isLuxury_1 {
    /**
     * Method generated for query isLuxury[in]
     * @param slot1 input parameter generated from slot 0
     * @return an iterator for instances of isLuxury
    */
    public static ResultSet<isLuxury> isLuxury_1(
        final example.nz.org.take.compiler.userv.domainmodel.Car slot1) {
        DerivationController _derivation = new DefaultDerivationController();
        ResultSet<isLuxury> _result = new ResultSet(KBFragement_isLuxury_1.isLuxury_1(
                    slot1, _derivation), _derivation);

        return _result;
    }

    /**
     * Method generated for query isLuxury[in]
     * @param source
     * @param target
     * @return an iterator
     * code generated using velocity template JPredicate_11.vm
    */
    static ResourceIterator<isLuxury> isLuxury_1(
        final example.nz.org.take.compiler.userv.domainmodel.Car slot1,
        final DerivationController _derivation) {
        _derivation.log("public boolean example.nz.org.take.compiler.userv.domainmodel.Car.isLuxury()",
            DerivationController.JAVA_METHOD);

        if (slot1.isLuxury()) {
            isLuxury result = new isLuxury();
            result.slot1 = slot1;

            return new SingletonIterator<isLuxury>(result);
        }

        return EmptyIterator.DEFAULT;
    }
}
