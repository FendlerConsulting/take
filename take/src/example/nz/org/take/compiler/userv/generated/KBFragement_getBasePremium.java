package example.nz.org.take.compiler.userv.generated;

import nz.org.take.rt.*;


/**
 * Class generated by the take compiler.
 * @version Tue Feb 05 13:19:25 NZDT 2008
 */
@SuppressWarnings("unchecked")
class KBFragement_getBasePremium {
    /**
     * Method generated for query /basePremium[in,out]
     * @param car input parameter generated from slot 0
     * @return an iterator for instances of BasePremium
    */
    public static ResultSet<BasePremium> getBasePremium(
        final example.nz.org.take.compiler.userv.domainmodel.Car car) {
        DerivationController _derivation = new DefaultDerivationController();
        ResultSet<BasePremium> _result = new ResultSet(KBFragement_getBasePremium.getBasePremium(
                    car, _derivation), _derivation);

        return _result;
    }

    /**
     * Method generated for query /basePremium[in,out]
     * @param car input parameter generated from slot 0
     * @return an iterator for instances of BasePremium
    */
    static ResourceIterator<BasePremium> getBasePremium(
        final example.nz.org.take.compiler.userv.domainmodel.Car car,
        final DerivationController _derivation) {
        final int _derivationlevel = _derivation.getDepth();
        ResourceIterator<BasePremium> result = new IteratorChain<BasePremium>(3) {
                public Object getIteratorOrObject(int pos) {
                    switch (pos) {
                    // AP_01  IF isCompact(<car>) THEN /basePremium(<car>,250)
                    case 0:
                        return getBasePremium_0(car,
                            _derivation.reset(_derivationlevel));

                    // AP_02  IF isSedan(<car>) THEN /basePremium(<car>,400)
                    case 1:
                        return getBasePremium_1(car,
                            _derivation.reset(_derivationlevel));

                    // AP_03  IF isLuxury(<car>) THEN /basePremium(<car>,500)
                    case 2:
                        return getBasePremium_2(car,
                            _derivation.reset(_derivationlevel));

                    default:
                        return EmptyIterator.DEFAULT;
                    } // switch(pos)
                } // getIterator()

                public String getRuleRef(int pos) {
                    switch (pos) {
                    // AP_01  IF isCompact(<car>) THEN /basePremium(<car>,250)
                    case 0:
                        return "AP_01";

                    // AP_02  IF isSedan(<car>) THEN /basePremium(<car>,400)
                    case 1:
                        return "AP_02";

                    // AP_03  IF isLuxury(<car>) THEN /basePremium(<car>,500)
                    case 2:
                        return "AP_03";

                    default:
                        return "";
                    } // switch(pos)
                } // getRuleRef()
            };

        return result;
    }

    /**
     * Method generated for query /basePremium[in,out]
     * @param car input parameter generated from slot 0
     * @return an iterator for instances of BasePremium
    */
    private static ResourceIterator<BasePremium> getBasePremium_0(
        final example.nz.org.take.compiler.userv.domainmodel.Car car,
        final DerivationController _derivation) {
        _derivation.log("AP_01", DerivationController.RULE, car,
            DerivationController.NIL);

        // Variable bindings in rule:  IF isCompact(<car>) THEN /basePremium(<car>,250)
        class bindingsInRule39 {
            // Property generated for term  "<car>"
            example.nz.org.take.compiler.userv.domainmodel.Car p1;

            // Property generated for term  "250"
            long p2;
        }
        ;

        final bindingsInRule39 bindings = new bindingsInRule39();
        bindings.p1 = car;
        bindings.p2 = 250;

        // code for prereq isCompact(<car>)
        final ResourceIterator<isCompact> iterator1 = KBFragement_isCompact_1.isCompact_1(car,
                _derivation.increaseDepth());

        // code for prereq /basePremium(<car>,250)
        final ResourceIterator<BasePremium> iterator2 = new NestedIterator<isCompact, BasePremium>(iterator1) {
                public ResourceIterator<BasePremium> getNextIterator(
                    isCompact object) {
                    bindings.p1 = object.slot1;

                    return new SingletonIterator(new BasePremium(bindings.p1,
                            bindings.p2));
                }
            };

        return iterator2;
    }

    /**
     * Method generated for query /basePremium[in,out]
     * @param car input parameter generated from slot 0
     * @return an iterator for instances of BasePremium
    */
    private static ResourceIterator<BasePremium> getBasePremium_1(
        final example.nz.org.take.compiler.userv.domainmodel.Car car,
        final DerivationController _derivation) {
        _derivation.log("AP_02", DerivationController.RULE, car,
            DerivationController.NIL);

        // Variable bindings in rule:  IF isSedan(<car>) THEN /basePremium(<car>,400)
        class bindingsInRule40 {
            // Property generated for term  "400"
            long p1;

            // Property generated for term  "<car>"
            example.nz.org.take.compiler.userv.domainmodel.Car p2;
        }
        ;

        final bindingsInRule40 bindings = new bindingsInRule40();
        bindings.p1 = 400;
        bindings.p2 = car;

        // code for prereq isSedan(<car>)
        final ResourceIterator<isSedan> iterator1 = KBFragement_isSedan_1.isSedan_1(car,
                _derivation.increaseDepth());

        // code for prereq /basePremium(<car>,400)
        final ResourceIterator<BasePremium> iterator2 = new NestedIterator<isSedan, BasePremium>(iterator1) {
                public ResourceIterator<BasePremium> getNextIterator(
                    isSedan object) {
                    bindings.p2 = object.slot1;

                    return new SingletonIterator(new BasePremium(bindings.p2,
                            bindings.p1));
                }
            };

        return iterator2;
    }

    /**
     * Method generated for query /basePremium[in,out]
     * @param car input parameter generated from slot 0
     * @return an iterator for instances of BasePremium
    */
    private static ResourceIterator<BasePremium> getBasePremium_2(
        final example.nz.org.take.compiler.userv.domainmodel.Car car,
        final DerivationController _derivation) {
        _derivation.log("AP_03", DerivationController.RULE, car,
            DerivationController.NIL);

        // Variable bindings in rule:  IF isLuxury(<car>) THEN /basePremium(<car>,500)
        class bindingsInRule41 {
            // Property generated for term  "<car>"
            example.nz.org.take.compiler.userv.domainmodel.Car p1;

            // Property generated for term  "500"
            long p2;
        }
        ;

        final bindingsInRule41 bindings = new bindingsInRule41();
        bindings.p1 = car;
        bindings.p2 = 500;

        // code for prereq isLuxury(<car>)
        final ResourceIterator<isLuxury> iterator1 = KBFragement_isLuxury_1.isLuxury_1(car,
                _derivation.increaseDepth());

        // code for prereq /basePremium(<car>,500)
        final ResourceIterator<BasePremium> iterator2 = new NestedIterator<isLuxury, BasePremium>(iterator1) {
                public ResourceIterator<BasePremium> getNextIterator(
                    isLuxury object) {
                    bindings.p1 = object.slot1;

                    return new SingletonIterator(new BasePremium(bindings.p1,
                            bindings.p2));
                }
            };

        return iterator2;
    }
}
