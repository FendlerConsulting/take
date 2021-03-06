package example.nz.org.take.compiler.userv.generated;

import nz.org.take.rt.*;


/**
 * Class generated by the take compiler.
 * @version Mon Feb 11 13:49:16 NZDT 2008
 */
@SuppressWarnings("unchecked")
class KBFragement_getDriverEligibility {
    /**
     * Method generated for query /isEligible[in]
     * @param driver input parameter generated from slot 0
     * @return an iterator for instances of DriverEligibility
    */
    public static ResultSet<DriverEligibility> getDriverEligibility(
        final example.nz.org.take.compiler.userv.domainmodel.Driver driver) {
        DerivationController _derivation = new DefaultDerivationController();
        ResultSet<DriverEligibility> _result = new ResultSet(KBFragement_getDriverEligibility.getDriverEligibility(
                    driver, _derivation), _derivation);

        return _result;
    }

    /**
     * Method generated for query /isEligible[in]
     * @param driver input parameter generated from slot 0
     * @return an iterator for instances of DriverEligibility
    */
    static ResourceIterator<DriverEligibility> getDriverEligibility(
        final example.nz.org.take.compiler.userv.domainmodel.Driver driver,
        final DerivationController _derivation) {
        final int _derivationlevel = _derivation.getDepth();
        ResourceIterator<DriverEligibility> result = new IteratorChain<DriverEligibility>(3) {
                public Object getIteratorOrObject(int pos) {
                    switch (pos) {
                    // DE_DAC03  IF /driverCategory(<driver>,young driver) AND /hasTrainingCertification(<driver>) THEN /isEligible(<driver>)
                    case 0:
                        return getDriverEligibility_0(driver,
                            _derivation.reset(_derivationlevel));

                    // DE_DAC05  IF /driverCategory(<driver>,senior driver) AND /hasTrainingCertification(<driver>) THEN /isEligible(<driver>)
                    case 1:
                        return getDriverEligibility_1(driver,
                            _derivation.reset(_derivationlevel));

                    // DE_DAC06  IF /driverCategory(<driver>,senior driver) AND /driverCategory(<driver>,young driver) THEN /isEligible(<driver>)
                    case 2:
                        return getDriverEligibility_2(driver,
                            _derivation.reset(_derivationlevel));

                    default:
                        return EmptyIterator.DEFAULT;
                    } // switch(pos)
                } // getIterator()

                public String getRuleRef(int pos) {
                    switch (pos) {
                    // DE_DAC03  IF /driverCategory(<driver>,young driver) AND /hasTrainingCertification(<driver>) THEN /isEligible(<driver>)
                    case 0:
                        return "DE_DAC03";

                    // DE_DAC05  IF /driverCategory(<driver>,senior driver) AND /hasTrainingCertification(<driver>) THEN /isEligible(<driver>)
                    case 1:
                        return "DE_DAC05";

                    // DE_DAC06  IF /driverCategory(<driver>,senior driver) AND /driverCategory(<driver>,young driver) THEN /isEligible(<driver>)
                    case 2:
                        return "DE_DAC06";

                    default:
                        return "";
                    } // switch(pos)
                } // getRuleRef()
            };

        return result;
    }

    /**
     * Method generated for query /isEligible[in]
     * @param driver input parameter generated from slot 0
     * @return an iterator for instances of DriverEligibility
    */
    private static ResourceIterator<DriverEligibility> getDriverEligibility_0(
        final example.nz.org.take.compiler.userv.domainmodel.Driver driver,
        final DerivationController _derivation) {
        _derivation.log("DE_DAC03", DerivationController.RULE, driver);

        // Variable bindings in rule:  IF /driverCategory(<driver>,young driver) AND /hasTrainingCertification(<driver>) THEN /isEligible(<driver>)
        class bindingsInRule18 {
            // Property generated for term  "young driver"
            java.lang.String p1;

            // Property generated for term  "<driver>"
            example.nz.org.take.compiler.userv.domainmodel.Driver p2;
        }
        ;

        final bindingsInRule18 bindings = new bindingsInRule18();
        bindings.p1 = "young driver";
        bindings.p2 = driver;

        // code for prereq /driverCategory(<driver>,young driver)
        final ResourceIterator<DriverCategory> iterator1 = KBFragement_getDriverCategory.getDriverCategory(driver,
                "young driver", _derivation.increaseDepth());

        // code for prereq /hasTrainingCertification(<driver>)
        final ResourceIterator<TrainedDriver> iterator2 = new NestedIterator<DriverCategory, TrainedDriver>(iterator1) {
                public ResourceIterator<TrainedDriver> getNextIterator(
                    DriverCategory object) {
                    bindings.p2 = object.driver;
                    bindings.p1 = "young driver";

                    return KBFragement_hasTrainingCertification.hasTrainingCertification(bindings.p2,
                        _derivation.increaseDepth());
                }
            };

        // code for prereq /isEligible(<driver>)
        final ResourceIterator<DriverEligibility> iterator3 = new NestedIterator<TrainedDriver, DriverEligibility>(iterator2) {
                public ResourceIterator<DriverEligibility> getNextIterator(
                    TrainedDriver object) {
                    bindings.p2 = object.driver;

                    return new SingletonIterator(new DriverEligibility(
                            bindings.p2));
                }
            };

        return iterator3;
    }

    /**
     * Method generated for query /isEligible[in]
     * @param driver input parameter generated from slot 0
     * @return an iterator for instances of DriverEligibility
    */
    private static ResourceIterator<DriverEligibility> getDriverEligibility_1(
        final example.nz.org.take.compiler.userv.domainmodel.Driver driver,
        final DerivationController _derivation) {
        _derivation.log("DE_DAC05", DerivationController.RULE, driver);

        // Variable bindings in rule:  IF /driverCategory(<driver>,senior driver) AND /hasTrainingCertification(<driver>) THEN /isEligible(<driver>)
        class bindingsInRule19 {
            // Property generated for term  "<driver>"
            example.nz.org.take.compiler.userv.domainmodel.Driver p1;

            // Property generated for term  "senior driver"
            java.lang.String p2;
        }
        ;

        final bindingsInRule19 bindings = new bindingsInRule19();
        bindings.p1 = driver;
        bindings.p2 = "senior driver";

        // code for prereq /driverCategory(<driver>,senior driver)
        final ResourceIterator<DriverCategory> iterator1 = KBFragement_getDriverCategory.getDriverCategory(driver,
                "senior driver", _derivation.increaseDepth());

        // code for prereq /hasTrainingCertification(<driver>)
        final ResourceIterator<TrainedDriver> iterator2 = new NestedIterator<DriverCategory, TrainedDriver>(iterator1) {
                public ResourceIterator<TrainedDriver> getNextIterator(
                    DriverCategory object) {
                    bindings.p1 = object.driver;
                    bindings.p2 = "senior driver";

                    return KBFragement_hasTrainingCertification.hasTrainingCertification(bindings.p1,
                        _derivation.increaseDepth());
                }
            };

        // code for prereq /isEligible(<driver>)
        final ResourceIterator<DriverEligibility> iterator3 = new NestedIterator<TrainedDriver, DriverEligibility>(iterator2) {
                public ResourceIterator<DriverEligibility> getNextIterator(
                    TrainedDriver object) {
                    bindings.p1 = object.driver;

                    return new SingletonIterator(new DriverEligibility(
                            bindings.p1));
                }
            };

        return iterator3;
    }

    /**
     * Method generated for query /isEligible[in]
     * @param driver input parameter generated from slot 0
     * @return an iterator for instances of DriverEligibility
    */
    private static ResourceIterator<DriverEligibility> getDriverEligibility_2(
        final example.nz.org.take.compiler.userv.domainmodel.Driver driver,
        final DerivationController _derivation) {
        _derivation.log("DE_DAC06", DerivationController.RULE, driver);

        // Variable bindings in rule:  IF /driverCategory(<driver>,senior driver) AND /driverCategory(<driver>,young driver) THEN /isEligible(<driver>)
        class bindingsInRule20 {
            // Property generated for term  "young driver"
            java.lang.String p1;

            // Property generated for term  "<driver>"
            example.nz.org.take.compiler.userv.domainmodel.Driver p2;

            // Property generated for term  "senior driver"
            java.lang.String p3;
        }
        ;

        final bindingsInRule20 bindings = new bindingsInRule20();
        bindings.p1 = "young driver";
        bindings.p2 = driver;
        bindings.p3 = "senior driver";

        // code for prereq /driverCategory(<driver>,senior driver)
        final ResourceIterator<not_DriverCategory> iterator1 = KBFragement_not_getDriverCategory.not_getDriverCategory(driver,
                "senior driver", _derivation.increaseDepth());

        // code for prereq /driverCategory(<driver>,young driver)
        final ResourceIterator<not_DriverCategory> iterator2 = new NestedIterator<not_DriverCategory, not_DriverCategory>(iterator1) {
                public ResourceIterator<not_DriverCategory> getNextIterator(
                    not_DriverCategory object) {
                    bindings.p2 = object.driver;
                    bindings.p3 = "senior driver";

                    return KBFragement_not_getDriverCategory.not_getDriverCategory(bindings.p2,
                        bindings.p1, _derivation.increaseDepth());
                }
            };

        // code for prereq /isEligible(<driver>)
        final ResourceIterator<DriverEligibility> iterator3 = new NestedIterator<not_DriverCategory, DriverEligibility>(iterator2) {
                public ResourceIterator<DriverEligibility> getNextIterator(
                    not_DriverCategory object) {
                    bindings.p2 = object.driver;
                    bindings.p1 = "young driver";

                    return new SingletonIterator(new DriverEligibility(
                            bindings.p2));
                }
            };

        return iterator3;
    }
}
