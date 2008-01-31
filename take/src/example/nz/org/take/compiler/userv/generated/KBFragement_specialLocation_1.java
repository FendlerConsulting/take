package example.nz.org.take.compiler.userv.generated;

import nz.org.take.rt.*;


/**
 * Class generated by the take compiler.
 * @version Fri Feb 01 12:12:07 NZDT 2008
 */
@SuppressWarnings("unchecked")
class KBFragement_specialLocation_1 {
    /**
     * Method generated for query /specialLocation[in]
     * @param slot1 input parameter generated from slot 0
     * @return an iterator for instances of specialLocation
    */
    public static ResultSet<specialLocation> specialLocation_1(
        final example.nz.org.take.compiler.userv.domainmodel.Driver slot1) {
        DerivationController _derivation = new DefaultDerivationController();
        ResultSet<specialLocation> _result = new ResultSet(KBFragement_specialLocation_1.specialLocation_1(
                    slot1, _derivation), _derivation);

        return _result;
    }

    /**
     * Method generated for query /specialLocation[in]
     * @param slot1 input parameter generated from slot 0
     * @return an iterator for instances of specialLocation
    */
    static ResourceIterator<specialLocation> specialLocation_1(
        final example.nz.org.take.compiler.userv.domainmodel.Driver slot1,
        final DerivationController _derivation) {
        final int _derivationlevel = _derivation.getDepth();
        ResourceIterator<specialLocation> result = new IteratorChain<specialLocation>(3) {
                public Object getIteratorOrObject(int pos) {
                    switch (pos) {
                    // DP_00a  IF equals(getLocation(<driver>),CA) THEN /specialLocation(<driver>)
                    case 0:
                        return specialLocation_1_0(slot1,
                            _derivation.reset(_derivationlevel));

                    // DP_00b  IF equals(getLocation(<driver>),NY) THEN /specialLocation(<driver>)
                    case 1:
                        return specialLocation_1_1(slot1,
                            _derivation.reset(_derivationlevel));

                    // DP_00c  IF equals(getLocation(<driver>),VA) THEN /specialLocation(<driver>)
                    case 2:
                        return specialLocation_1_2(slot1,
                            _derivation.reset(_derivationlevel));

                    default:
                        return EmptyIterator.DEFAULT;
                    } // switch(pos)
                } // getIterator()

                public String getRuleRef(int pos) {
                    switch (pos) {
                    // DP_00a  IF equals(getLocation(<driver>),CA) THEN /specialLocation(<driver>)
                    case 0:
                        return "DP_00a";

                    // DP_00b  IF equals(getLocation(<driver>),NY) THEN /specialLocation(<driver>)
                    case 1:
                        return "DP_00b";

                    // DP_00c  IF equals(getLocation(<driver>),VA) THEN /specialLocation(<driver>)
                    case 2:
                        return "DP_00c";

                    default:
                        return "";
                    } // switch(pos)
                } // getRuleRef()
            };

        return result;
    }

    /**
     * Method generated for query /specialLocation[in]
     * @param slot1 input parameter generated from slot 0
     * @return an iterator for instances of specialLocation
    */
    private static ResourceIterator<specialLocation> specialLocation_1_0(
        final example.nz.org.take.compiler.userv.domainmodel.Driver slot1,
        final DerivationController _derivation) {
        _derivation.log("DP_00a", DerivationController.RULE, slot1);

        // Variable bindings in rule:  IF equals(getLocation(<driver>),CA) THEN /specialLocation(<driver>)
        class bindingsInRule66 {
            // Property generated for term  "CA"
            java.lang.String p1;

            // Property generated for term  "<driver>"
            example.nz.org.take.compiler.userv.domainmodel.Driver p2;

            // Property generated for term  "getLocation(<driver>)"
            java.lang.String p3;
        }
        ;

        final bindingsInRule66 bindings = new bindingsInRule66();
        bindings.p1 = "CA";
        bindings.p2 = slot1;
        bindings.p3 = slot1.getLocation();

        // code for prereq equals(getLocation(<driver>),CA)
        final ResourceIterator<equals> iterator1 = KBFragement_equals_11.equals_11(bindings.p3,
                "CA", _derivation.increaseDepth());

        // code for prereq /specialLocation(<driver>)
        final ResourceIterator<specialLocation> iterator2 = new NestedIterator<equals, specialLocation>(iterator1) {
                public ResourceIterator<specialLocation> getNextIterator(
                    equals object) {
                    bindings.p3 = object.slot1;
                    bindings.p1 = (java.lang.String) "CA";

                    return new SingletonIterator(new specialLocation(
                            bindings.p2));
                }
            };

        return iterator2;
    }

    /**
     * Method generated for query /specialLocation[in]
     * @param slot1 input parameter generated from slot 0
     * @return an iterator for instances of specialLocation
    */
    private static ResourceIterator<specialLocation> specialLocation_1_1(
        final example.nz.org.take.compiler.userv.domainmodel.Driver slot1,
        final DerivationController _derivation) {
        _derivation.log("DP_00b", DerivationController.RULE, slot1);

        // Variable bindings in rule:  IF equals(getLocation(<driver>),NY) THEN /specialLocation(<driver>)
        class bindingsInRule67 {
            // Property generated for term  "NY"
            java.lang.String p1;

            // Property generated for term  "<driver>"
            example.nz.org.take.compiler.userv.domainmodel.Driver p2;

            // Property generated for term  "getLocation(<driver>)"
            java.lang.String p3;
        }
        ;

        final bindingsInRule67 bindings = new bindingsInRule67();
        bindings.p1 = "NY";
        bindings.p2 = slot1;
        bindings.p3 = slot1.getLocation();

        // code for prereq equals(getLocation(<driver>),NY)
        final ResourceIterator<equals> iterator1 = KBFragement_equals_11.equals_11(bindings.p3,
                "NY", _derivation.increaseDepth());

        // code for prereq /specialLocation(<driver>)
        final ResourceIterator<specialLocation> iterator2 = new NestedIterator<equals, specialLocation>(iterator1) {
                public ResourceIterator<specialLocation> getNextIterator(
                    equals object) {
                    bindings.p3 = object.slot1;
                    bindings.p1 = (java.lang.String) "NY";

                    return new SingletonIterator(new specialLocation(
                            bindings.p2));
                }
            };

        return iterator2;
    }

    /**
     * Method generated for query /specialLocation[in]
     * @param slot1 input parameter generated from slot 0
     * @return an iterator for instances of specialLocation
    */
    private static ResourceIterator<specialLocation> specialLocation_1_2(
        final example.nz.org.take.compiler.userv.domainmodel.Driver slot1,
        final DerivationController _derivation) {
        _derivation.log("DP_00c", DerivationController.RULE, slot1);

        // Variable bindings in rule:  IF equals(getLocation(<driver>),VA) THEN /specialLocation(<driver>)
        class bindingsInRule68 {
            // Property generated for term  "<driver>"
            example.nz.org.take.compiler.userv.domainmodel.Driver p1;

            // Property generated for term  "getLocation(<driver>)"
            java.lang.String p2;

            // Property generated for term  "VA"
            java.lang.String p3;
        }
        ;

        final bindingsInRule68 bindings = new bindingsInRule68();
        bindings.p1 = slot1;
        bindings.p2 = slot1.getLocation();
        bindings.p3 = "VA";

        // code for prereq equals(getLocation(<driver>),VA)
        final ResourceIterator<equals> iterator1 = KBFragement_equals_11.equals_11(bindings.p2,
                "VA", _derivation.increaseDepth());

        // code for prereq /specialLocation(<driver>)
        final ResourceIterator<specialLocation> iterator2 = new NestedIterator<equals, specialLocation>(iterator1) {
                public ResourceIterator<specialLocation> getNextIterator(
                    equals object) {
                    bindings.p2 = object.slot1;
                    bindings.p3 = (java.lang.String) "VA";

                    return new SingletonIterator(new specialLocation(
                            bindings.p1));
                }
            };

        return iterator2;
    }
}
