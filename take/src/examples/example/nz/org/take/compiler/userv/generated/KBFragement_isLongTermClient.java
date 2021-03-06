package example.nz.org.take.compiler.userv.generated;

import nz.org.take.rt.*;


/**
 * Class generated by the take compiler.
 * @version Mon Feb 11 13:49:16 NZDT 2008
 */
@SuppressWarnings("unchecked")
class KBFragement_isLongTermClient {
    /**
     * Method generated for query /isLongTermClient[in]
     * @param driver input parameter generated from slot 0
     * @return an iterator for instances of LongTermClient
    */
    public static ResultSet<LongTermClient> isLongTermClient(
        final example.nz.org.take.compiler.userv.domainmodel.Driver driver) {
        DerivationController _derivation = new DefaultDerivationController();
        ResultSet<LongTermClient> _result = new ResultSet(KBFragement_isLongTermClient.isLongTermClient(
                    driver, _derivation), _derivation);

        return _result;
    }

    /**
     * Method generated for query /isLongTermClient[in]
     * @param driver input parameter generated from slot 0
     * @return an iterator for instances of LongTermClient
    */
    static ResourceIterator<LongTermClient> isLongTermClient(
        final example.nz.org.take.compiler.userv.domainmodel.Driver driver,
        final DerivationController _derivation) {
        final int _derivationlevel = _derivation.getDepth();
        ResourceIterator<LongTermClient> result = new IteratorChain<LongTermClient>(1) {
                public Object getIteratorOrObject(int pos) {
                    switch (pos) {
                    // ES_08  IF greater_than_or_equal(getNumberOfYearsWithUServ(<client>),15) THEN /isLongTermClient(<client>)
                    case 0:
                        return isLongTermClient_0(driver,
                            _derivation.reset(_derivationlevel));

                    default:
                        return EmptyIterator.DEFAULT;
                    } // switch(pos)
                } // getIterator()

                public String getRuleRef(int pos) {
                    switch (pos) {
                    // ES_08  IF greater_than_or_equal(getNumberOfYearsWithUServ(<client>),15) THEN /isLongTermClient(<client>)
                    case 0:
                        return "ES_08";

                    default:
                        return "";
                    } // switch(pos)
                } // getRuleRef()
            };

        return result;
    }

    /**
     * Method generated for query /isLongTermClient[in]
     * @param driver input parameter generated from slot 0
     * @return an iterator for instances of LongTermClient
    */
    private static ResourceIterator<LongTermClient> isLongTermClient_0(
        final example.nz.org.take.compiler.userv.domainmodel.Driver driver,
        final DerivationController _derivation) {
        _derivation.log("ES_08", DerivationController.RULE, driver);

        // Variable bindings in rule:  IF greater_than_or_equal(getNumberOfYearsWithUServ(<client>),15) THEN /isLongTermClient(<client>)
        class bindingsInRule38 {
            // Property generated for term  "<client>"
            example.nz.org.take.compiler.userv.domainmodel.Driver p1;

            // Property generated for term  "15"
            long p2;

            // Property generated for term  "getNumberOfYearsWithUServ(<client>)"
            long p3;
        }
        ;

        final bindingsInRule38 bindings = new bindingsInRule38();
        bindings.p1 = driver;
        bindings.p2 = 15;
        bindings.p3 = driver.getNumberOfYearsWithUServ();

        // code for prereq greater_than_or_equal(getNumberOfYearsWithUServ(<client>),15)
        final ResourceIterator<greater_than_or_equal> iterator1 = KBFragement_greater_than_or_equal_11.greater_than_or_equal_11(bindings.p3,
                15, _derivation.increaseDepth());

        // code for prereq /isLongTermClient(<client>)
        final ResourceIterator<LongTermClient> iterator2 = new NestedIterator<greater_than_or_equal, LongTermClient>(iterator1) {
                public ResourceIterator<LongTermClient> getNextIterator(
                    greater_than_or_equal object) {
                    bindings.p3 = (long) object.slot1;
                    bindings.p2 = (long) 15;

                    return new SingletonIterator(new LongTermClient(bindings.p1));
                }
            };

        return iterator2;
    }
}
