package example.nz.org.take.r2ml.eurent.generated;

import nz.org.take.rt.*;


/**
 * Class generated by the take compiler.
 * @version Wed Nov 21 16:25:55 GMT+01:00 2007
 */
@SuppressWarnings("unchecked")
class KBFragement_not_assignedTo_00 {
    /**
     * Method generated for query assignedTo[out,out]
     * @return an iterator for instances of not_assignedTo
    */
    public static ResultSet<not_assignedTo> not_assignedTo_00() {
        DerivationController _derivation = new DefaultDerivationController();
        ResultSet<not_assignedTo> _result = new ResultSet(KBFragement_not_assignedTo_00.not_assignedTo_00(
                    _derivation), _derivation);

        return _result;
    }

    /**
     * Method generated for query assignedTo[out,out]
     * @return an iterator for instances of not_assignedTo
    */
    static ResourceIterator<not_assignedTo> not_assignedTo_00(
        final DerivationController _derivation) {
        final int _derivationlevel = _derivation.getDepth();
        ResourceIterator<not_assignedTo> result = new IteratorChain<not_assignedTo>(0) {
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