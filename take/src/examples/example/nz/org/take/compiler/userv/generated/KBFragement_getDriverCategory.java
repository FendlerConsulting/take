package example.nz.org.take.compiler.userv.generated;

import nz.org.take.rt.*;


/**
 * Class generated by the take compiler.
 * @version Mon Feb 11 13:49:16 NZDT 2008
 */
@SuppressWarnings("unchecked")
class KBFragement_getDriverCategory {
    /**
     * Method generated for query /driverCategory[in,out]
     * @param driver input parameter generated from slot 0
     * @return an iterator for instances of DriverCategory
    */
    public static ResultSet<DriverCategory> getDriverCategory(
        final example.nz.org.take.compiler.userv.domainmodel.Driver driver) {
        DerivationController _derivation = new DefaultDerivationController();
        ResultSet<DriverCategory> _result = new ResultSet(KBFragement_getDriverCategory.getDriverCategory(
                    driver, _derivation), _derivation);

        return _result;
    }

    /**
     * Method generated for query /driverCategory[in,out]
     * @param driver input parameter generated from slot 0
     * @return an iterator for instances of DriverCategory
    */
    static ResourceIterator<DriverCategory> getDriverCategory(
        final example.nz.org.take.compiler.userv.domainmodel.Driver driver,
        final DerivationController _derivation) {
        final int _derivationlevel = _derivation.getDepth();
        ResourceIterator<DriverCategory> result = new IteratorChain<DriverCategory>(4) {
                public Object getIteratorOrObject(int pos) {
                    switch (pos) {
                    // DE_DAC01  IF isMale(<driver>) AND less_than(getAge(<driver>),25) THEN /driverCategory(<driver>,young driver)
                    case 0:
                        return getDriverCategory_0(driver,
                            _derivation.reset(_derivationlevel));

                    // DE_DAC02  IF isMale(<driver>) AND less_than(getAge(<driver>),20) THEN /driverCategory(<driver>,young driver)
                    case 1:
                        return getDriverCategory_1(driver,
                            _derivation.reset(_derivationlevel));

                    // DE_DAC04  IF greater_than(getAge(<driver>),70) THEN /driverCategory(<driver>,senior driver)
                    case 2:
                        return getDriverCategory_2(driver,
                            _derivation.reset(_derivationlevel));

                    // DP_07  IF /driverCategory(<driver>,young driver) AND /driverCategory(<driver>,senior driver) THEN /driverCategory(<driver>,typical driver)
                    case 3:
                        return getDriverCategory_3(driver,
                            _derivation.reset(_derivationlevel));

                    default:
                        return EmptyIterator.DEFAULT;
                    } // switch(pos)
                } // getIterator()

                public String getRuleRef(int pos) {
                    switch (pos) {
                    // DE_DAC01  IF isMale(<driver>) AND less_than(getAge(<driver>),25) THEN /driverCategory(<driver>,young driver)
                    case 0:
                        return "DE_DAC01";

                    // DE_DAC02  IF isMale(<driver>) AND less_than(getAge(<driver>),20) THEN /driverCategory(<driver>,young driver)
                    case 1:
                        return "DE_DAC02";

                    // DE_DAC04  IF greater_than(getAge(<driver>),70) THEN /driverCategory(<driver>,senior driver)
                    case 2:
                        return "DE_DAC04";

                    // DP_07  IF /driverCategory(<driver>,young driver) AND /driverCategory(<driver>,senior driver) THEN /driverCategory(<driver>,typical driver)
                    case 3:
                        return "DP_07";

                    default:
                        return "";
                    } // switch(pos)
                } // getRuleRef()
            };

        return result;
    }

    /**
     * Method generated for query /driverCategory[in,out]
     * @param driver input parameter generated from slot 0
     * @return an iterator for instances of DriverCategory
    */
    private static ResourceIterator<DriverCategory> getDriverCategory_0(
        final example.nz.org.take.compiler.userv.domainmodel.Driver driver,
        final DerivationController _derivation) {
        _derivation.log("DE_DAC01", DerivationController.RULE, driver,
            DerivationController.NIL);

        // Variable bindings in rule:  IF isMale(<driver>) AND less_than(getAge(<driver>),25) THEN /driverCategory(<driver>,young driver)
        class bindingsInRule14 {
            // Property generated for term  "young driver"
            java.lang.String p1;

            // Property generated for term  "<driver>"
            example.nz.org.take.compiler.userv.domainmodel.Driver p2;

            // Property generated for term  "25"
            long p3;

            // Property generated for term  "getAge(<driver>)"
            long p4;
        }
        ;

        final bindingsInRule14 bindings = new bindingsInRule14();
        bindings.p1 = "young driver";
        bindings.p2 = driver;
        bindings.p3 = 25;
        bindings.p4 = driver.getAge();

        // code for prereq isMale(<driver>)
        final ResourceIterator<isMale> iterator1 = KBFragement_isMale_1.isMale_1(driver,
                _derivation.increaseDepth());

        // code for prereq less_than(getAge(<driver>),25)
        final ResourceIterator<less_than> iterator2 = new NestedIterator<isMale, less_than>(iterator1) {
                public ResourceIterator<less_than> getNextIterator(
                    isMale object) {
                    bindings.p2 = object.slot1;

                    return KBFragement_less_than_11.less_than_11(bindings.p4,
                        bindings.p3, _derivation.increaseDepth());
                }
            };

        // code for prereq /driverCategory(<driver>,young driver)
        final ResourceIterator<DriverCategory> iterator3 = new NestedIterator<less_than, DriverCategory>(iterator2) {
                public ResourceIterator<DriverCategory> getNextIterator(
                    less_than object) {
                    bindings.p4 = (long) object.slot1;
                    bindings.p3 = (long) 25;

                    return new SingletonIterator(new DriverCategory(
                            bindings.p2, bindings.p1));
                }
            };

        return iterator3;
    }

    /**
     * Method generated for query /driverCategory[in,out]
     * @param driver input parameter generated from slot 0
     * @return an iterator for instances of DriverCategory
    */
    private static ResourceIterator<DriverCategory> getDriverCategory_1(
        final example.nz.org.take.compiler.userv.domainmodel.Driver driver,
        final DerivationController _derivation) {
        _derivation.log("DE_DAC02", DerivationController.RULE, driver,
            DerivationController.NIL);

        // Variable bindings in rule:  IF isMale(<driver>) AND less_than(getAge(<driver>),20) THEN /driverCategory(<driver>,young driver)
        class bindingsInRule15 {
            // Property generated for term  "young driver"
            java.lang.String p1;

            // Property generated for term  "20"
            long p2;

            // Property generated for term  "<driver>"
            example.nz.org.take.compiler.userv.domainmodel.Driver p3;

            // Property generated for term  "getAge(<driver>)"
            long p4;
        }
        ;

        final bindingsInRule15 bindings = new bindingsInRule15();
        bindings.p1 = "young driver";
        bindings.p3 = driver;
        bindings.p2 = 20;
        bindings.p4 = driver.getAge();

        // code for prereq isMale(<driver>)
        final ResourceIterator<not_isMale> iterator1 = KBFragement_not_isMale_1.not_isMale_1(driver,
                _derivation.increaseDepth());

        // code for prereq less_than(getAge(<driver>),20)
        final ResourceIterator<less_than> iterator2 = new NestedIterator<not_isMale, less_than>(iterator1) {
                public ResourceIterator<less_than> getNextIterator(
                    not_isMale object) {
                    bindings.p3 = object.slot1;

                    return KBFragement_less_than_11.less_than_11(bindings.p4,
                        bindings.p2, _derivation.increaseDepth());
                }
            };

        // code for prereq /driverCategory(<driver>,young driver)
        final ResourceIterator<DriverCategory> iterator3 = new NestedIterator<less_than, DriverCategory>(iterator2) {
                public ResourceIterator<DriverCategory> getNextIterator(
                    less_than object) {
                    bindings.p4 = (long) object.slot1;
                    bindings.p2 = (long) 20;

                    return new SingletonIterator(new DriverCategory(
                            bindings.p3, bindings.p1));
                }
            };

        return iterator3;
    }

    /**
     * Method generated for query /driverCategory[in,out]
     * @param driver input parameter generated from slot 0
     * @return an iterator for instances of DriverCategory
    */
    private static ResourceIterator<DriverCategory> getDriverCategory_2(
        final example.nz.org.take.compiler.userv.domainmodel.Driver driver,
        final DerivationController _derivation) {
        _derivation.log("DE_DAC04", DerivationController.RULE, driver,
            DerivationController.NIL);

        // Variable bindings in rule:  IF greater_than(getAge(<driver>),70) THEN /driverCategory(<driver>,senior driver)
        class bindingsInRule16 {
            // Property generated for term  "<driver>"
            example.nz.org.take.compiler.userv.domainmodel.Driver p1;

            // Property generated for term  "70"
            long p2;

            // Property generated for term  "getAge(<driver>)"
            long p3;

            // Property generated for term  "senior driver"
            java.lang.String p4;
        }
        ;

        final bindingsInRule16 bindings = new bindingsInRule16();
        bindings.p1 = driver;
        bindings.p2 = 70;
        bindings.p3 = driver.getAge();
        bindings.p4 = "senior driver";

        // code for prereq greater_than(getAge(<driver>),70)
        final ResourceIterator<greater_than> iterator1 = KBFragement_greater_than_11.greater_than_11(bindings.p3,
                70, _derivation.increaseDepth());

        // code for prereq /driverCategory(<driver>,senior driver)
        final ResourceIterator<DriverCategory> iterator2 = new NestedIterator<greater_than, DriverCategory>(iterator1) {
                public ResourceIterator<DriverCategory> getNextIterator(
                    greater_than object) {
                    bindings.p3 = (long) object.slot1;
                    bindings.p2 = (long) 70;

                    return new SingletonIterator(new DriverCategory(
                            bindings.p1, bindings.p4));
                }
            };

        return iterator2;
    }

    /**
     * Method generated for query /driverCategory[in,out]
     * @param driver input parameter generated from slot 0
     * @return an iterator for instances of DriverCategory
    */
    private static ResourceIterator<DriverCategory> getDriverCategory_3(
        final example.nz.org.take.compiler.userv.domainmodel.Driver driver,
        final DerivationController _derivation) {
        _derivation.log("DP_07", DerivationController.RULE, driver,
            DerivationController.NIL);

        // Variable bindings in rule:  IF /driverCategory(<driver>,young driver) AND /driverCategory(<driver>,senior driver) THEN /driverCategory(<driver>,typical driver)
        class bindingsInRule17 {
            // Property generated for term  "young driver"
            java.lang.String p1;

            // Property generated for term  "<driver>"
            example.nz.org.take.compiler.userv.domainmodel.Driver p2;

            // Property generated for term  "typical driver"
            java.lang.String p3;

            // Property generated for term  "senior driver"
            java.lang.String p4;
        }
        ;

        final bindingsInRule17 bindings = new bindingsInRule17();
        bindings.p1 = "young driver";
        bindings.p2 = driver;
        bindings.p4 = "senior driver";
        bindings.p3 = "typical driver";

        // code for prereq /driverCategory(<driver>,young driver)
        final ResourceIterator<not_DriverCategory> iterator1 = KBFragement_not_getDriverCategory.not_getDriverCategory(driver,
                "young driver", _derivation.increaseDepth());

        // code for prereq /driverCategory(<driver>,senior driver)
        final ResourceIterator<not_DriverCategory> iterator2 = new NestedIterator<not_DriverCategory, not_DriverCategory>(iterator1) {
                public ResourceIterator<not_DriverCategory> getNextIterator(
                    not_DriverCategory object) {
                    bindings.p2 = object.driver;
                    bindings.p1 = "young driver";

                    return KBFragement_not_getDriverCategory.not_getDriverCategory(bindings.p2,
                        bindings.p4, _derivation.increaseDepth());
                }
            };

        // code for prereq /driverCategory(<driver>,typical driver)
        final ResourceIterator<DriverCategory> iterator3 = new NestedIterator<not_DriverCategory, DriverCategory>(iterator2) {
                public ResourceIterator<DriverCategory> getNextIterator(
                    not_DriverCategory object) {
                    bindings.p2 = object.driver;
                    bindings.p4 = "senior driver";

                    return new SingletonIterator(new DriverCategory(
                            bindings.p2, bindings.p3));
                }
            };

        return iterator3;
    }

    /**
     * Method generated for query /driverCategory[in,in]
     * @param driver input parameter generated from slot 0
     * @param category input parameter generated from slot 1
     * @return an iterator for instances of DriverCategory
    */
    public static ResultSet<DriverCategory> getDriverCategory(
        final example.nz.org.take.compiler.userv.domainmodel.Driver driver,
        final java.lang.String category) {
        DerivationController _derivation = new DefaultDerivationController();
        ResultSet<DriverCategory> _result = new ResultSet(KBFragement_getDriverCategory.getDriverCategory(
                    driver, category, _derivation), _derivation);

        return _result;
    }

    /**
     * Method generated for query /driverCategory[in,in]
     * @param driver input parameter generated from slot 0
     * @param category input parameter generated from slot 1
     * @return an iterator for instances of DriverCategory
    */
    static ResourceIterator<DriverCategory> getDriverCategory(
        final example.nz.org.take.compiler.userv.domainmodel.Driver driver,
        final java.lang.String category, final DerivationController _derivation) {
        final int _derivationlevel = _derivation.getDepth();
        ResourceIterator<DriverCategory> result = new IteratorChain<DriverCategory>(4) {
                public Object getIteratorOrObject(int pos) {
                    switch (pos) {
                    // DE_DAC01  IF isMale(<driver>) AND less_than(getAge(<driver>),25) THEN /driverCategory(<driver>,young driver)
                    case 0:
                        return getDriverCategory_0(driver, category,
                            _derivation.reset(_derivationlevel));

                    // DE_DAC02  IF isMale(<driver>) AND less_than(getAge(<driver>),20) THEN /driverCategory(<driver>,young driver)
                    case 1:
                        return getDriverCategory_1(driver, category,
                            _derivation.reset(_derivationlevel));

                    // DE_DAC04  IF greater_than(getAge(<driver>),70) THEN /driverCategory(<driver>,senior driver)
                    case 2:
                        return getDriverCategory_2(driver, category,
                            _derivation.reset(_derivationlevel));

                    // DP_07  IF /driverCategory(<driver>,young driver) AND /driverCategory(<driver>,senior driver) THEN /driverCategory(<driver>,typical driver)
                    case 3:
                        return getDriverCategory_3(driver, category,
                            _derivation.reset(_derivationlevel));

                    default:
                        return EmptyIterator.DEFAULT;
                    } // switch(pos)
                } // getIterator()

                public String getRuleRef(int pos) {
                    switch (pos) {
                    // DE_DAC01  IF isMale(<driver>) AND less_than(getAge(<driver>),25) THEN /driverCategory(<driver>,young driver)
                    case 0:
                        return "DE_DAC01";

                    // DE_DAC02  IF isMale(<driver>) AND less_than(getAge(<driver>),20) THEN /driverCategory(<driver>,young driver)
                    case 1:
                        return "DE_DAC02";

                    // DE_DAC04  IF greater_than(getAge(<driver>),70) THEN /driverCategory(<driver>,senior driver)
                    case 2:
                        return "DE_DAC04";

                    // DP_07  IF /driverCategory(<driver>,young driver) AND /driverCategory(<driver>,senior driver) THEN /driverCategory(<driver>,typical driver)
                    case 3:
                        return "DP_07";

                    default:
                        return "";
                    } // switch(pos)
                } // getRuleRef()
            };

        return result;
    }

    /**
     * Method generated for query /driverCategory[in,in]
     * @param driver input parameter generated from slot 0
     * @param category input parameter generated from slot 1
     * @return an iterator for instances of DriverCategory
    */
    private static ResourceIterator<DriverCategory> getDriverCategory_0(
        final example.nz.org.take.compiler.userv.domainmodel.Driver driver,
        final java.lang.String category, final DerivationController _derivation) {
        _derivation.log("DE_DAC01", DerivationController.RULE, driver, category);

        // comparing constants in rule head with parameters
        if (!"young driver".equals(category)) {
            return EmptyIterator.DEFAULT;
        }

        // Variable bindings in rule:  IF isMale(<driver>) AND less_than(getAge(<driver>),25) THEN /driverCategory(<driver>,young driver)
        class bindingsInRule14 {
            // Property generated for term  "young driver"
            java.lang.String p1;

            // Property generated for term  "<driver>"
            example.nz.org.take.compiler.userv.domainmodel.Driver p2;

            // Property generated for term  "25"
            long p3;

            // Property generated for term  "getAge(<driver>)"
            long p4;
        }
        ;

        final bindingsInRule14 bindings = new bindingsInRule14();
        bindings.p1 = "young driver";
        bindings.p2 = driver;
        bindings.p3 = 25;
        bindings.p4 = driver.getAge();

        // code for prereq isMale(<driver>)
        final ResourceIterator<isMale> iterator1 = KBFragement_isMale_1.isMale_1(driver,
                _derivation.increaseDepth());

        // code for prereq less_than(getAge(<driver>),25)
        final ResourceIterator<less_than> iterator2 = new NestedIterator<isMale, less_than>(iterator1) {
                public ResourceIterator<less_than> getNextIterator(
                    isMale object) {
                    bindings.p2 = object.slot1;

                    return KBFragement_less_than_11.less_than_11(bindings.p4,
                        bindings.p3, _derivation.increaseDepth());
                }
            };

        // code for prereq /driverCategory(<driver>,young driver)
        final ResourceIterator<DriverCategory> iterator3 = new NestedIterator<less_than, DriverCategory>(iterator2) {
                public ResourceIterator<DriverCategory> getNextIterator(
                    less_than object) {
                    bindings.p4 = (long) object.slot1;
                    bindings.p3 = (long) 25;

                    return new SingletonIterator(new DriverCategory(
                            bindings.p2, bindings.p1));
                }
            };

        return iterator3;
    }

    /**
     * Method generated for query /driverCategory[in,in]
     * @param driver input parameter generated from slot 0
     * @param category input parameter generated from slot 1
     * @return an iterator for instances of DriverCategory
    */
    private static ResourceIterator<DriverCategory> getDriverCategory_1(
        final example.nz.org.take.compiler.userv.domainmodel.Driver driver,
        final java.lang.String category, final DerivationController _derivation) {
        _derivation.log("DE_DAC02", DerivationController.RULE, driver, category);

        // comparing constants in rule head with parameters
        if (!"young driver".equals(category)) {
            return EmptyIterator.DEFAULT;
        }

        // Variable bindings in rule:  IF isMale(<driver>) AND less_than(getAge(<driver>),20) THEN /driverCategory(<driver>,young driver)
        class bindingsInRule15 {
            // Property generated for term  "young driver"
            java.lang.String p1;

            // Property generated for term  "20"
            long p2;

            // Property generated for term  "<driver>"
            example.nz.org.take.compiler.userv.domainmodel.Driver p3;

            // Property generated for term  "getAge(<driver>)"
            long p4;
        }
        ;

        final bindingsInRule15 bindings = new bindingsInRule15();
        bindings.p1 = "young driver";
        bindings.p3 = driver;
        bindings.p2 = 20;
        bindings.p4 = driver.getAge();

        // code for prereq isMale(<driver>)
        final ResourceIterator<not_isMale> iterator1 = KBFragement_not_isMale_1.not_isMale_1(driver,
                _derivation.increaseDepth());

        // code for prereq less_than(getAge(<driver>),20)
        final ResourceIterator<less_than> iterator2 = new NestedIterator<not_isMale, less_than>(iterator1) {
                public ResourceIterator<less_than> getNextIterator(
                    not_isMale object) {
                    bindings.p3 = object.slot1;

                    return KBFragement_less_than_11.less_than_11(bindings.p4,
                        bindings.p2, _derivation.increaseDepth());
                }
            };

        // code for prereq /driverCategory(<driver>,young driver)
        final ResourceIterator<DriverCategory> iterator3 = new NestedIterator<less_than, DriverCategory>(iterator2) {
                public ResourceIterator<DriverCategory> getNextIterator(
                    less_than object) {
                    bindings.p4 = (long) object.slot1;
                    bindings.p2 = (long) 20;

                    return new SingletonIterator(new DriverCategory(
                            bindings.p3, bindings.p1));
                }
            };

        return iterator3;
    }

    /**
     * Method generated for query /driverCategory[in,in]
     * @param driver input parameter generated from slot 0
     * @param category input parameter generated from slot 1
     * @return an iterator for instances of DriverCategory
    */
    private static ResourceIterator<DriverCategory> getDriverCategory_2(
        final example.nz.org.take.compiler.userv.domainmodel.Driver driver,
        final java.lang.String category, final DerivationController _derivation) {
        _derivation.log("DE_DAC04", DerivationController.RULE, driver, category);

        // comparing constants in rule head with parameters
        if (!"senior driver".equals(category)) {
            return EmptyIterator.DEFAULT;
        }

        // Variable bindings in rule:  IF greater_than(getAge(<driver>),70) THEN /driverCategory(<driver>,senior driver)
        class bindingsInRule16 {
            // Property generated for term  "<driver>"
            example.nz.org.take.compiler.userv.domainmodel.Driver p1;

            // Property generated for term  "70"
            long p2;

            // Property generated for term  "getAge(<driver>)"
            long p3;

            // Property generated for term  "senior driver"
            java.lang.String p4;
        }
        ;

        final bindingsInRule16 bindings = new bindingsInRule16();
        bindings.p1 = driver;
        bindings.p2 = 70;
        bindings.p3 = driver.getAge();
        bindings.p4 = "senior driver";

        // code for prereq greater_than(getAge(<driver>),70)
        final ResourceIterator<greater_than> iterator1 = KBFragement_greater_than_11.greater_than_11(bindings.p3,
                70, _derivation.increaseDepth());

        // code for prereq /driverCategory(<driver>,senior driver)
        final ResourceIterator<DriverCategory> iterator2 = new NestedIterator<greater_than, DriverCategory>(iterator1) {
                public ResourceIterator<DriverCategory> getNextIterator(
                    greater_than object) {
                    bindings.p3 = (long) object.slot1;
                    bindings.p2 = (long) 70;

                    return new SingletonIterator(new DriverCategory(
                            bindings.p1, bindings.p4));
                }
            };

        return iterator2;
    }

    /**
     * Method generated for query /driverCategory[in,in]
     * @param driver input parameter generated from slot 0
     * @param category input parameter generated from slot 1
     * @return an iterator for instances of DriverCategory
    */
    private static ResourceIterator<DriverCategory> getDriverCategory_3(
        final example.nz.org.take.compiler.userv.domainmodel.Driver driver,
        final java.lang.String category, final DerivationController _derivation) {
        _derivation.log("DP_07", DerivationController.RULE, driver, category);

        // comparing constants in rule head with parameters
        if (!"typical driver".equals(category)) {
            return EmptyIterator.DEFAULT;
        }

        // Variable bindings in rule:  IF /driverCategory(<driver>,young driver) AND /driverCategory(<driver>,senior driver) THEN /driverCategory(<driver>,typical driver)
        class bindingsInRule17 {
            // Property generated for term  "young driver"
            java.lang.String p1;

            // Property generated for term  "<driver>"
            example.nz.org.take.compiler.userv.domainmodel.Driver p2;

            // Property generated for term  "typical driver"
            java.lang.String p3;

            // Property generated for term  "senior driver"
            java.lang.String p4;
        }
        ;

        final bindingsInRule17 bindings = new bindingsInRule17();
        bindings.p1 = "young driver";
        bindings.p2 = driver;
        bindings.p4 = "senior driver";
        bindings.p3 = "typical driver";

        // code for prereq /driverCategory(<driver>,young driver)
        final ResourceIterator<not_DriverCategory> iterator1 = KBFragement_not_getDriverCategory.not_getDriverCategory(driver,
                "young driver", _derivation.increaseDepth());

        // code for prereq /driverCategory(<driver>,senior driver)
        final ResourceIterator<not_DriverCategory> iterator2 = new NestedIterator<not_DriverCategory, not_DriverCategory>(iterator1) {
                public ResourceIterator<not_DriverCategory> getNextIterator(
                    not_DriverCategory object) {
                    bindings.p2 = object.driver;
                    bindings.p1 = "young driver";

                    return KBFragement_not_getDriverCategory.not_getDriverCategory(bindings.p2,
                        bindings.p4, _derivation.increaseDepth());
                }
            };

        // code for prereq /driverCategory(<driver>,typical driver)
        final ResourceIterator<DriverCategory> iterator3 = new NestedIterator<not_DriverCategory, DriverCategory>(iterator2) {
                public ResourceIterator<DriverCategory> getNextIterator(
                    not_DriverCategory object) {
                    bindings.p2 = object.driver;
                    bindings.p4 = "senior driver";

                    return new SingletonIterator(new DriverCategory(
                            bindings.p2, bindings.p3));
                }
            };

        return iterator3;
    }
}
