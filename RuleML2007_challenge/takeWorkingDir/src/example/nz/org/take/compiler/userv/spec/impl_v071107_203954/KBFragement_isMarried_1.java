package example.nz.org.take.compiler.userv.spec.impl_v071107_203954;

import example.nz.org.take.compiler.userv.spec.*;

import nz.org.take.rt.*;


/**
 * Class generated by the take compiler.
 * @version Wed Nov 07 20:39:56 NZDT 2007
 */
@SuppressWarnings("unchecked")
class KBFragement_isMarried_1 {
    /**
     * Method generated for query isMarried[in]
     * @param slot1 input parameter generated from slot 0
     * @return an iterator for instances of isMarried
    */
    public static ResultSet<isMarried> isMarried_1(
        final example.nz.org.take.compiler.userv.domainmodel.Driver slot1) {
        DerivationController _derivation = new DefaultDerivationController();
        ResultSet<isMarried> _result = new ResultSet(KBFragement_isMarried_1.isMarried_1(
                    slot1, _derivation), _derivation);

        return _result;
    }

    /**
     * Method generated for query isMarried[in]
     * @param source
     * @param target
     * @return an iterator
     * code generated using velocity template JPredicate_11.vm
    */
    static ResourceIterator<isMarried> isMarried_1(
        final example.nz.org.take.compiler.userv.domainmodel.Driver slot1,
        final DerivationController _derivation) {
        _derivation.log("public boolean example.nz.org.take.compiler.userv.domainmodel.Driver.isMarried()",
            DerivationController.JAVA_METHOD);

        if (slot1.isMarried()) {
            isMarried result = new isMarried();
            result.slot1 = slot1;

            return new SingletonIterator<isMarried>(result);
        }

        return EmptyIterator.DEFAULT;
    }
}
