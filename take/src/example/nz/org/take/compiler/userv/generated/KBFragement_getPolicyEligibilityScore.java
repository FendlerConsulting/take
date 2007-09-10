package example.nz.org.take.compiler.userv.generated;

import nz.org.take.rt.*;


/**
 * Class generated by the take compiler.
 * @version Mon Sep 10 16:43:09 NZST 2007
 */
@SuppressWarnings("unchecked")
class KBFragement_getPolicyEligibilityScore {
    /**
     * Method generated for query /policyEligibilityScore[in,in,out]
     * @param car input parameter generated from slot 0
     * @param driver input parameter generated from slot 1
     * @return an iterator for instances of PolicyEligibilityScore
    */
    public static ResultSet<PolicyEligibilityScore> getPolicyEligibilityScore(
        final example.nz.org.take.compiler.userv.domainmodel.Car car,
        final example.nz.org.take.compiler.userv.domainmodel.Driver driver) {
        DerivationController _derivation = new DefaultDerivationController();
        ResultSet<PolicyEligibilityScore> _result = new ResultSet(KBFragement_getPolicyEligibilityScore.getPolicyEligibilityScore(
                    car, driver, _derivation), _derivation);

        return _result;
    }

    /**
     * Method generated for query /policyEligibilityScore[in,in,out]
     * @param car input parameter generated from slot 0
     * @param driver input parameter generated from slot 1
     * @return an iterator for instances of PolicyEligibilityScore
    */
    static ResourceIterator<PolicyEligibilityScore> getPolicyEligibilityScore(
        final example.nz.org.take.compiler.userv.domainmodel.Car car,
        final example.nz.org.take.compiler.userv.domainmodel.Driver driver,
        final DerivationController _derivation) {
        final int _derivationlevel = _derivation.getDepth();
        ResourceIterator<PolicyEligibilityScore> result = new IteratorChain<PolicyEligibilityScore>(7) {
                public Object getIteratorOrObject(int pos) {
                    switch (pos) {
                    //  IF /autoEligibility(<car>,not eligible) THEN /policyEligibilityScore(<car>,<driver>,100)
                    case 0:
                        return getPolicyEligibilityScore_0(car, driver,
                            _derivation.reset(_derivationlevel));

                    //  IF /autoEligibility(<car>,provisional) THEN /policyEligibilityScore(<car>,<driver>,50)
                    case 1:
                        return getPolicyEligibilityScore_1(car, driver,
                            _derivation.reset(_derivationlevel));

                    //  IF /driverCategory(<driver>,young driver) AND /isEligible(<driver>) THEN /policyEligibilityScore(<car>,<driver>,30)
                    case 2:
                        return getPolicyEligibilityScore_2(car, driver,
                            _derivation.reset(_derivationlevel));

                    //  IF /driverCategory(<driver>,senior driver) AND /isEligible(<driver>) THEN /policyEligibilityScore(<car>,<driver>,20)
                    case 3:
                        return getPolicyEligibilityScore_3(car, driver,
                            _derivation.reset(_derivationlevel));

                    //  IF /isHighRiskDriver(<driver>) THEN /policyEligibilityScore(<car>,<driver>,100)
                    case 4:
                        return getPolicyEligibilityScore_4(car, driver,
                            _derivation.reset(_derivationlevel));

                    //  IF isPreferred(<client>) THEN /policyEligibilityScore(<car>,<client>,-50)
                    case 5:
                        return getPolicyEligibilityScore_5(car, driver,
                            _derivation.reset(_derivationlevel));

                    //  IF isElite(<client>) THEN /policyEligibilityScore(<car>,<client>,-100)
                    case 6:
                        return getPolicyEligibilityScore_6(car, driver,
                            _derivation.reset(_derivationlevel));

                    default:
                        return EmptyIterator.DEFAULT;
                    } // switch(pos)
                } // getIterator()

                public String getRuleRef(int pos) {
                    switch (pos) {
                    //  IF /autoEligibility(<car>,not eligible) THEN /policyEligibilityScore(<car>,<driver>,100)
                    case 0:
                        return "ES_01a";

                    //  IF /autoEligibility(<car>,provisional) THEN /policyEligibilityScore(<car>,<driver>,50)
                    case 1:
                        return "ES_01b";

                    //  IF /driverCategory(<driver>,young driver) AND /isEligible(<driver>) THEN /policyEligibilityScore(<car>,<driver>,30)
                    case 2:
                        return "ES_02a";

                    //  IF /driverCategory(<driver>,senior driver) AND /isEligible(<driver>) THEN /policyEligibilityScore(<car>,<driver>,20)
                    case 3:
                        return "ES_02b";

                    //  IF /isHighRiskDriver(<driver>) THEN /policyEligibilityScore(<car>,<driver>,100)
                    case 4:
                        return "ES_02c";

                    //  IF isPreferred(<client>) THEN /policyEligibilityScore(<car>,<client>,-50)
                    case 5:
                        return "ES_03a";

                    //  IF isElite(<client>) THEN /policyEligibilityScore(<car>,<client>,-100)
                    case 6:
                        return "ES_03b";

                    default:
                        return "";
                    } // switch(pos)
                } // getRuleRef()
            };

        return result;
    }

    /**
     * Method generated for query /policyEligibilityScore[in,in,out]
     * @param car input parameter generated from slot 0
     * @param driver input parameter generated from slot 1
     * @return an iterator for instances of PolicyEligibilityScore
    */
    private static ResourceIterator<PolicyEligibilityScore> getPolicyEligibilityScore_0(
        final example.nz.org.take.compiler.userv.domainmodel.Car car,
        final example.nz.org.take.compiler.userv.domainmodel.Driver driver,
        final DerivationController _derivation) {
        _derivation.log("ES_01a", DerivationController.RULE, car, driver,
            DerivationController.NIL);

        // Variable bindings in rule:  IF /autoEligibility(<car>,not eligible) THEN /policyEligibilityScore(<car>,<driver>,100)
        class bindingsInRule27 {
            // Property generated for term  "<car>"
            example.nz.org.take.compiler.userv.domainmodel.Car p1;

            // Property generated for term  "not eligible"
            java.lang.String p2;

            // Property generated for term  "<driver>"
            example.nz.org.take.compiler.userv.domainmodel.Driver p3;

            // Property generated for term  "100"
            java.lang.Integer p4;
        }
        ;

        final bindingsInRule27 bindings = new bindingsInRule27();
        bindings.p4 = 100;
        bindings.p2 = "not eligible";
        bindings.p1 = car;
        bindings.p3 = driver;

        // code for prereq /autoEligibility(<car>,not eligible)
        final ResourceIterator<AutoEligibility> iterator1 = KBFragement_getAutoEligibility.getAutoEligibility(car,
                "not eligible", _derivation.increaseDepth());

        // code for prereq /policyEligibilityScore(<car>,<driver>,100)
        final ResourceIterator<PolicyEligibilityScore> iterator2 = new NestedIterator<AutoEligibility, PolicyEligibilityScore>(iterator1) {
                public ResourceIterator<PolicyEligibilityScore> getNextIterator(
                    AutoEligibility object) {
                    bindings.p1 = object.car;
                    bindings.p2 = "not eligible";

                    return new SingletonIterator(new PolicyEligibilityScore(
                            bindings.p1, bindings.p3, bindings.p4));
                }
            };

        return iterator2;
    }

    /**
     * Method generated for query /policyEligibilityScore[in,in,out]
     * @param car input parameter generated from slot 0
     * @param driver input parameter generated from slot 1
     * @return an iterator for instances of PolicyEligibilityScore
    */
    private static ResourceIterator<PolicyEligibilityScore> getPolicyEligibilityScore_1(
        final example.nz.org.take.compiler.userv.domainmodel.Car car,
        final example.nz.org.take.compiler.userv.domainmodel.Driver driver,
        final DerivationController _derivation) {
        _derivation.log("ES_01b", DerivationController.RULE, car, driver,
            DerivationController.NIL);

        // Variable bindings in rule:  IF /autoEligibility(<car>,provisional) THEN /policyEligibilityScore(<car>,<driver>,50)
        class bindingsInRule28 {
            // Property generated for term  "<car>"
            example.nz.org.take.compiler.userv.domainmodel.Car p1;

            // Property generated for term  "provisional"
            java.lang.String p2;

            // Property generated for term  "<driver>"
            example.nz.org.take.compiler.userv.domainmodel.Driver p3;

            // Property generated for term  "50"
            java.lang.Integer p4;
        }
        ;

        final bindingsInRule28 bindings = new bindingsInRule28();
        bindings.p4 = 50;
        bindings.p1 = car;
        bindings.p2 = "provisional";
        bindings.p3 = driver;

        // code for prereq /autoEligibility(<car>,provisional)
        final ResourceIterator<AutoEligibility> iterator1 = KBFragement_getAutoEligibility.getAutoEligibility(car,
                "provisional", _derivation.increaseDepth());

        // code for prereq /policyEligibilityScore(<car>,<driver>,50)
        final ResourceIterator<PolicyEligibilityScore> iterator2 = new NestedIterator<AutoEligibility, PolicyEligibilityScore>(iterator1) {
                public ResourceIterator<PolicyEligibilityScore> getNextIterator(
                    AutoEligibility object) {
                    bindings.p1 = object.car;
                    bindings.p2 = "provisional";

                    return new SingletonIterator(new PolicyEligibilityScore(
                            bindings.p1, bindings.p3, bindings.p4));
                }
            };

        return iterator2;
    }

    /**
     * Method generated for query /policyEligibilityScore[in,in,out]
     * @param car input parameter generated from slot 0
     * @param driver input parameter generated from slot 1
     * @return an iterator for instances of PolicyEligibilityScore
    */
    private static ResourceIterator<PolicyEligibilityScore> getPolicyEligibilityScore_2(
        final example.nz.org.take.compiler.userv.domainmodel.Car car,
        final example.nz.org.take.compiler.userv.domainmodel.Driver driver,
        final DerivationController _derivation) {
        _derivation.log("ES_02a", DerivationController.RULE, car, driver,
            DerivationController.NIL);

        // Variable bindings in rule:  IF /driverCategory(<driver>,young driver) AND /isEligible(<driver>) THEN /policyEligibilityScore(<car>,<driver>,30)
        class bindingsInRule29 {
            // Property generated for term  "<driver>"
            example.nz.org.take.compiler.userv.domainmodel.Driver p1;

            // Property generated for term  "young driver"
            java.lang.String p2;

            // Property generated for term  "<car>"
            example.nz.org.take.compiler.userv.domainmodel.Car p3;

            // Property generated for term  "30"
            java.lang.Integer p4;
        }
        ;

        final bindingsInRule29 bindings = new bindingsInRule29();
        bindings.p2 = "young driver";
        bindings.p4 = 30;
        bindings.p3 = car;
        bindings.p1 = driver;

        // code for prereq /driverCategory(<driver>,young driver)
        final ResourceIterator<DriverCategory> iterator1 = KBFragement_getDriverCategory.getDriverCategory(driver,
                "young driver", _derivation.increaseDepth());

        // code for prereq /isEligible(<driver>)
        final ResourceIterator<not_DriverEligibility> iterator2 = new NestedIterator<DriverCategory, not_DriverEligibility>(iterator1) {
                public ResourceIterator<not_DriverEligibility> getNextIterator(
                    DriverCategory object) {
                    bindings.p1 = object.driver;
                    bindings.p2 = "young driver";

                    return KBFragement_not_getDriverEligibility.not_getDriverEligibility(bindings.p1,
                        _derivation.increaseDepth());
                }
            };

        // code for prereq /policyEligibilityScore(<car>,<driver>,30)
        final ResourceIterator<PolicyEligibilityScore> iterator3 = new NestedIterator<not_DriverEligibility, PolicyEligibilityScore>(iterator2) {
                public ResourceIterator<PolicyEligibilityScore> getNextIterator(
                    not_DriverEligibility object) {
                    bindings.p1 = object.driver;

                    return new SingletonIterator(new PolicyEligibilityScore(
                            bindings.p3, bindings.p1, bindings.p4));
                }
            };

        return iterator3;
    }

    /**
     * Method generated for query /policyEligibilityScore[in,in,out]
     * @param car input parameter generated from slot 0
     * @param driver input parameter generated from slot 1
     * @return an iterator for instances of PolicyEligibilityScore
    */
    private static ResourceIterator<PolicyEligibilityScore> getPolicyEligibilityScore_3(
        final example.nz.org.take.compiler.userv.domainmodel.Car car,
        final example.nz.org.take.compiler.userv.domainmodel.Driver driver,
        final DerivationController _derivation) {
        _derivation.log("ES_02b", DerivationController.RULE, car, driver,
            DerivationController.NIL);

        // Variable bindings in rule:  IF /driverCategory(<driver>,senior driver) AND /isEligible(<driver>) THEN /policyEligibilityScore(<car>,<driver>,20)
        class bindingsInRule30 {
            // Property generated for term  "<driver>"
            example.nz.org.take.compiler.userv.domainmodel.Driver p1;

            // Property generated for term  "senior driver"
            java.lang.String p2;

            // Property generated for term  "<car>"
            example.nz.org.take.compiler.userv.domainmodel.Car p3;

            // Property generated for term  "20"
            java.lang.Integer p4;
        }
        ;

        final bindingsInRule30 bindings = new bindingsInRule30();
        bindings.p4 = 20;
        bindings.p3 = car;
        bindings.p2 = "senior driver";
        bindings.p1 = driver;

        // code for prereq /driverCategory(<driver>,senior driver)
        final ResourceIterator<DriverCategory> iterator1 = KBFragement_getDriverCategory.getDriverCategory(driver,
                "senior driver", _derivation.increaseDepth());

        // code for prereq /isEligible(<driver>)
        final ResourceIterator<not_DriverEligibility> iterator2 = new NestedIterator<DriverCategory, not_DriverEligibility>(iterator1) {
                public ResourceIterator<not_DriverEligibility> getNextIterator(
                    DriverCategory object) {
                    bindings.p1 = object.driver;
                    bindings.p2 = "senior driver";

                    return KBFragement_not_getDriverEligibility.not_getDriverEligibility(bindings.p1,
                        _derivation.increaseDepth());
                }
            };

        // code for prereq /policyEligibilityScore(<car>,<driver>,20)
        final ResourceIterator<PolicyEligibilityScore> iterator3 = new NestedIterator<not_DriverEligibility, PolicyEligibilityScore>(iterator2) {
                public ResourceIterator<PolicyEligibilityScore> getNextIterator(
                    not_DriverEligibility object) {
                    bindings.p1 = object.driver;

                    return new SingletonIterator(new PolicyEligibilityScore(
                            bindings.p3, bindings.p1, bindings.p4));
                }
            };

        return iterator3;
    }

    /**
     * Method generated for query /policyEligibilityScore[in,in,out]
     * @param car input parameter generated from slot 0
     * @param driver input parameter generated from slot 1
     * @return an iterator for instances of PolicyEligibilityScore
    */
    private static ResourceIterator<PolicyEligibilityScore> getPolicyEligibilityScore_4(
        final example.nz.org.take.compiler.userv.domainmodel.Car car,
        final example.nz.org.take.compiler.userv.domainmodel.Driver driver,
        final DerivationController _derivation) {
        _derivation.log("ES_02c", DerivationController.RULE, car, driver,
            DerivationController.NIL);

        // Variable bindings in rule:  IF /isHighRiskDriver(<driver>) THEN /policyEligibilityScore(<car>,<driver>,100)
        class bindingsInRule31 {
            // Property generated for term  "<driver>"
            example.nz.org.take.compiler.userv.domainmodel.Driver p1;

            // Property generated for term  "<car>"
            example.nz.org.take.compiler.userv.domainmodel.Car p2;

            // Property generated for term  "100"
            java.lang.Integer p3;
        }
        ;

        final bindingsInRule31 bindings = new bindingsInRule31();
        bindings.p3 = 100;
        bindings.p2 = car;
        bindings.p1 = driver;

        // code for prereq /isHighRiskDriver(<driver>)
        final ResourceIterator<HighRiskDriver> iterator1 = KBFragement_isHighRiskDriver.isHighRiskDriver(driver,
                _derivation.increaseDepth());

        // code for prereq /policyEligibilityScore(<car>,<driver>,100)
        final ResourceIterator<PolicyEligibilityScore> iterator2 = new NestedIterator<HighRiskDriver, PolicyEligibilityScore>(iterator1) {
                public ResourceIterator<PolicyEligibilityScore> getNextIterator(
                    HighRiskDriver object) {
                    bindings.p1 = object.driver;

                    return new SingletonIterator(new PolicyEligibilityScore(
                            bindings.p2, bindings.p1, bindings.p3));
                }
            };

        return iterator2;
    }

    /**
     * Method generated for query /policyEligibilityScore[in,in,out]
     * @param car input parameter generated from slot 0
     * @param driver input parameter generated from slot 1
     * @return an iterator for instances of PolicyEligibilityScore
    */
    private static ResourceIterator<PolicyEligibilityScore> getPolicyEligibilityScore_5(
        final example.nz.org.take.compiler.userv.domainmodel.Car car,
        final example.nz.org.take.compiler.userv.domainmodel.Driver driver,
        final DerivationController _derivation) {
        _derivation.log("ES_03a", DerivationController.RULE, car, driver,
            DerivationController.NIL);

        // Variable bindings in rule:  IF isPreferred(<client>) THEN /policyEligibilityScore(<car>,<client>,-50)
        class bindingsInRule32 {
            // Property generated for term  "<client>"
            example.nz.org.take.compiler.userv.domainmodel.Driver p1;

            // Property generated for term  "<car>"
            example.nz.org.take.compiler.userv.domainmodel.Car p2;

            // Property generated for term  "-50"
            java.lang.Integer p3;
        }
        ;

        final bindingsInRule32 bindings = new bindingsInRule32();
        bindings.p3 = -50;
        bindings.p1 = driver;
        bindings.p2 = car;

        // code for prereq isPreferred(<client>)
        final ResourceIterator<isPreferred> iterator1 = KBFragement_isPreferred_1.isPreferred_1(driver,
                _derivation.increaseDepth());

        // code for prereq /policyEligibilityScore(<car>,<client>,-50)
        final ResourceIterator<PolicyEligibilityScore> iterator2 = new NestedIterator<isPreferred, PolicyEligibilityScore>(iterator1) {
                public ResourceIterator<PolicyEligibilityScore> getNextIterator(
                    isPreferred object) {
                    bindings.p1 = object.slot1;

                    return new SingletonIterator(new PolicyEligibilityScore(
                            bindings.p2, bindings.p1, bindings.p3));
                }
            };

        return iterator2;
    }

    /**
     * Method generated for query /policyEligibilityScore[in,in,out]
     * @param car input parameter generated from slot 0
     * @param driver input parameter generated from slot 1
     * @return an iterator for instances of PolicyEligibilityScore
    */
    private static ResourceIterator<PolicyEligibilityScore> getPolicyEligibilityScore_6(
        final example.nz.org.take.compiler.userv.domainmodel.Car car,
        final example.nz.org.take.compiler.userv.domainmodel.Driver driver,
        final DerivationController _derivation) {
        _derivation.log("ES_03b", DerivationController.RULE, car, driver,
            DerivationController.NIL);

        // Variable bindings in rule:  IF isElite(<client>) THEN /policyEligibilityScore(<car>,<client>,-100)
        class bindingsInRule33 {
            // Property generated for term  "<client>"
            example.nz.org.take.compiler.userv.domainmodel.Driver p1;

            // Property generated for term  "<car>"
            example.nz.org.take.compiler.userv.domainmodel.Car p2;

            // Property generated for term  "-100"
            java.lang.Integer p3;
        }
        ;

        final bindingsInRule33 bindings = new bindingsInRule33();
        bindings.p1 = driver;
        bindings.p3 = -100;
        bindings.p2 = car;

        // code for prereq isElite(<client>)
        final ResourceIterator<isElite> iterator1 = KBFragement_isElite_1.isElite_1(driver,
                _derivation.increaseDepth());

        // code for prereq /policyEligibilityScore(<car>,<client>,-100)
        final ResourceIterator<PolicyEligibilityScore> iterator2 = new NestedIterator<isElite, PolicyEligibilityScore>(iterator1) {
                public ResourceIterator<PolicyEligibilityScore> getNextIterator(
                    isElite object) {
                    bindings.p1 = object.slot1;

                    return new SingletonIterator(new PolicyEligibilityScore(
                            bindings.p2, bindings.p1, bindings.p3));
                }
            };

        return iterator2;
    }
}
