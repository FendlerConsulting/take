package test.nz.org.take.r2ml.c.generated;

import nz.org.take.rt.*;


/**
 * Class generated by the take compiler.
 * @version Mon Nov 19 18:15:33 GMT+01:00 2007
 */
@SuppressWarnings("unchecked")
class KBFragement_equals_00 {
    /**
     * Method generated for query equals[out,out]
     * @return an iterator for instances of equals
    */
    public static ResultSet<equals> equals_00() {
        DerivationController _derivation = new DefaultDerivationController();
        ResultSet<equals> _result = new ResultSet(KBFragement_equals_00.equals_00(
                    _derivation), _derivation);

        return _result;
    }

    /**
     * Method generated for query equals[out,out]
     * @return an iterator for instances of equals
    */
    static ResourceIterator<equals> equals_00(
        final DerivationController _derivation) {
        final int _derivationlevel = _derivation.getDepth();
        ResourceIterator<equals> result = new IteratorChain<equals>(0) {
                public Object getIteratorOrObject(int pos) {
                    switch (pos) {
                    default:
                        return EmptyIterator.DEFAULT;
                    } // switch(pos)
                } // getIterator()

                public String getRuleRef(int pos) {
                    switch (pos) {
                    default:
                        return "";
                    } // switch(pos)
                } // getRuleRef()
            };

        return result;
    }
}
