package example.nz.org.take.compiler.userv.generated;

import nz.org.take.rt.*;


/**
 * Class generated by the take compiler.
 * @version Thu Sep 06 16:23:42 NZST 2007
 */
@SuppressWarnings("unchecked")
class KBFragement_getPotenialTheftRating {
    /**
     * Method generated for query /potentialTheftRating[in,out]
     * @param car input parameter generated from slot 0
     * @return an iterator for instances of PotentialTheftRating
    */
    public static ResultSet<PotentialTheftRating> getPotenialTheftRating(
        final example.nz.org.take.compiler.userv.domainmodel.Car car) {
        DerivationController _derivation = new DefaultDerivationController();
        ResultSet<PotentialTheftRating> _result = new ResultSet(KBFragement_getPotenialTheftRating.getPotenialTheftRating(
                    car, _derivation), _derivation);

        return _result;
    }

    /**
     * Method generated for query /potentialTheftRating[in,out]
     * @param car input parameter generated from slot 0
     * @return an iterator for instances of PotentialTheftRating
    */
    static ResourceIterator<PotentialTheftRating> getPotenialTheftRating(
        final example.nz.org.take.compiler.userv.domainmodel.Car car,
        final DerivationController _derivation) {
        final int _derivationlevel = _derivation.getDepth();
        ResourceIterator<PotentialTheftRating> result = new IteratorChain<PotentialTheftRating>(5) {
                public Object getIteratorOrObject(int pos) {
                    switch (pos) {
                    //  IF isConvertible(<car>) THEN /potentialTheftRating(<car>,high)
                    case 0:
                        return getPotenialTheftRating_0(car,
                            _derivation.reset(_derivationlevel));

                    //  IF greater_than_ii(getPrice(<car>),45000) THEN /potentialTheftRating(<car>,high)
                    case 1:
                        return getPotenialTheftRating_1(car,
                            _derivation.reset(_derivationlevel));

                    //  IF contains([HighTheftProbabilityAutoList],getType(<car>)) THEN /potentialTheftRating(<car>,high)
                    case 2:
                        return getPotenialTheftRating_2(car,
                            _derivation.reset(_derivationlevel));

                    //  IF greater_than_ii(getPrice(<car>),20000) AND less_than_ii(getPrice(<car>),45000) AND contains([HighTheftProbabilityAutoList],getType(<car>)) THEN /potentialTheftRating(<car>,moderate)
                    case 3:
                        return getPotenialTheftRating_3(car,
                            _derivation.reset(_derivationlevel));

                    //  IF less_than_ii(getPrice(<car>),20000) AND contains([HighTheftProbabilityAutoList],getType(<car>)) THEN /potentialTheftRating(<car>,low)
                    case 4:
                        return getPotenialTheftRating_4(car,
                            _derivation.reset(_derivationlevel));

                    default:
                        return EmptyIterator.DEFAULT;
                    } // switch(pos)
                } // getIterator()

                public String getRuleRef(int pos) {
                    switch (pos) {
                    //  IF isConvertible(<car>) THEN /potentialTheftRating(<car>,high)
                    case 0:
                        return "AE_PTC01";

                    //  IF greater_than_ii(getPrice(<car>),45000) THEN /potentialTheftRating(<car>,high)
                    case 1:
                        return "AE_PTC02";

                    //  IF contains([HighTheftProbabilityAutoList],getType(<car>)) THEN /potentialTheftRating(<car>,high)
                    case 2:
                        return "AE_PTC03";

                    //  IF greater_than_ii(getPrice(<car>),20000) AND less_than_ii(getPrice(<car>),45000) AND contains([HighTheftProbabilityAutoList],getType(<car>)) THEN /potentialTheftRating(<car>,moderate)
                    case 3:
                        return "AE_PTC04";

                    //  IF less_than_ii(getPrice(<car>),20000) AND contains([HighTheftProbabilityAutoList],getType(<car>)) THEN /potentialTheftRating(<car>,low)
                    case 4:
                        return "AE_PTC05";

                    default:
                        return "";
                    } // switch(pos)
                } // getRuleRef()
            };

        return result;
    }

    /**
     * Method generated for query /potentialTheftRating[in,out]
     * @param car input parameter generated from slot 0
     * @return an iterator for instances of PotentialTheftRating
    */
    private static ResourceIterator<PotentialTheftRating> getPotenialTheftRating_0(
        final example.nz.org.take.compiler.userv.domainmodel.Car car,
        final DerivationController _derivation) {
        _derivation.log("AE_PTC01", DerivationController.RULE, car,
            DerivationController.NIL);

        // Variable bindings in rule:  IF isConvertible(<car>) THEN /potentialTheftRating(<car>,high)
        class bindingsInRule1 {
            // Property generated for term  "<car>"
            example.nz.org.take.compiler.userv.domainmodel.Car p1;

            // Property generated for term  "high"
            java.lang.String p2;
        }
        ;

        final bindingsInRule1 bindings = new bindingsInRule1();
        bindings.p2 = "high";
        bindings.p1 = car;

        // code for prereq isConvertible(<car>)
        final ResourceIterator<isConvertible> iterator1 = KBFragement_isConvertible_1.isConvertible_1(car,
                _derivation.increaseDepth());

        // code for prereq /potentialTheftRating(<car>,high)
        final ResourceIterator<PotentialTheftRating> iterator2 = new NestedIterator<isConvertible, PotentialTheftRating>(iterator1) {
                public ResourceIterator<PotentialTheftRating> getNextIterator(
                    isConvertible object) {
                    bindings.p1 = object.slot1;

                    return new SingletonIterator(new PotentialTheftRating(
                            bindings.p1, bindings.p2));
                }
            };

        return iterator2;
    }

    /**
     * Method generated for query /potentialTheftRating[in,out]
     * @param car input parameter generated from slot 0
     * @return an iterator for instances of PotentialTheftRating
    */
    private static ResourceIterator<PotentialTheftRating> getPotenialTheftRating_1(
        final example.nz.org.take.compiler.userv.domainmodel.Car car,
        final DerivationController _derivation) {
        _derivation.log("AE_PTC02", DerivationController.RULE, car,
            DerivationController.NIL);

        // Variable bindings in rule:  IF greater_than_ii(getPrice(<car>),45000) THEN /potentialTheftRating(<car>,high)
        class bindingsInRule2 {
            // Property generated for term  "getPrice(<car>)"
            int p1;

            // Property generated for term  "<car>"
            example.nz.org.take.compiler.userv.domainmodel.Car p2;

            // Property generated for term  "45000"
            java.lang.Integer p3;

            // Property generated for term  "high"
            java.lang.String p4;
        }
        ;

        final bindingsInRule2 bindings = new bindingsInRule2();
        bindings.p4 = "high";
        bindings.p2 = car;
        bindings.p3 = 45000;
        bindings.p1 = car.getPrice();

        // code for prereq greater_than_ii(getPrice(<car>),45000)
        final ResourceIterator<greater_than_ii> iterator1 = KBFragement_greater_than_ii_11.greater_than_ii_11(car.getPrice(),
                45000, _derivation.increaseDepth());

        // code for prereq /potentialTheftRating(<car>,high)
        final ResourceIterator<PotentialTheftRating> iterator2 = new NestedIterator<greater_than_ii, PotentialTheftRating>(iterator1) {
                public ResourceIterator<PotentialTheftRating> getNextIterator(
                    greater_than_ii object) {
                    bindings.p1 = object.slot1;
                    bindings.p3 = 45000;

                    return new SingletonIterator(new PotentialTheftRating(
                            bindings.p2, bindings.p4));
                }
            };

        return iterator2;
    }

    /**
     * Method generated for query /potentialTheftRating[in,out]
     * @param car input parameter generated from slot 0
     * @return an iterator for instances of PotentialTheftRating
    */
    private static ResourceIterator<PotentialTheftRating> getPotenialTheftRating_2(
        final example.nz.org.take.compiler.userv.domainmodel.Car car,
        final DerivationController _derivation) {
        _derivation.log("AE_PTC03", DerivationController.RULE, car,
            DerivationController.NIL);

        // Variable bindings in rule:  IF contains([HighTheftProbabilityAutoList],getType(<car>)) THEN /potentialTheftRating(<car>,high)
        class bindingsInRule3 {
            // Property generated for term  "[HighTheftProbabilityAutoList]"
            java.util.Collection p1;

            // Property generated for term  "getType(<car>)"
            java.lang.String p2;

            // Property generated for term  "<car>"
            example.nz.org.take.compiler.userv.domainmodel.Car p3;

            // Property generated for term  "high"
            java.lang.String p4;
        }
        ;

        final bindingsInRule3 bindings = new bindingsInRule3();
        bindings.p1 = Constants.HighTheftProbabilityAutoList;
        bindings.p4 = "high";
        bindings.p3 = car;
        bindings.p2 = car.getType();

        // code for prereq contains([HighTheftProbabilityAutoList],getType(<car>))
        final ResourceIterator<contains> iterator1 = KBFragement_contains_11.contains_11(Constants.HighTheftProbabilityAutoList,
                car.getType(), _derivation.increaseDepth());

        // code for prereq /potentialTheftRating(<car>,high)
        final ResourceIterator<PotentialTheftRating> iterator2 = new NestedIterator<contains, PotentialTheftRating>(iterator1) {
                public ResourceIterator<PotentialTheftRating> getNextIterator(
                    contains object) {
                    bindings.p1 = Constants.HighTheftProbabilityAutoList;
                    bindings.p2 = (java.lang.String) object.slot2;

                    return new SingletonIterator(new PotentialTheftRating(
                            bindings.p3, bindings.p4));
                }
            };

        return iterator2;
    }

    /**
     * Method generated for query /potentialTheftRating[in,out]
     * @param car input parameter generated from slot 0
     * @return an iterator for instances of PotentialTheftRating
    */
    private static ResourceIterator<PotentialTheftRating> getPotenialTheftRating_3(
        final example.nz.org.take.compiler.userv.domainmodel.Car car,
        final DerivationController _derivation) {
        _derivation.log("AE_PTC04", DerivationController.RULE, car,
            DerivationController.NIL);

        // Variable bindings in rule:  IF greater_than_ii(getPrice(<car>),20000) AND less_than_ii(getPrice(<car>),45000) AND contains([HighTheftProbabilityAutoList],getType(<car>)) THEN /potentialTheftRating(<car>,moderate)
        class bindingsInRule4 {
            // Property generated for term  "getPrice(<car>)"
            int p1;

            // Property generated for term  "<car>"
            example.nz.org.take.compiler.userv.domainmodel.Car p2;

            // Property generated for term  "20000"
            java.lang.Integer p3;

            // Property generated for term  "getPrice(<car>)"
            int p4;

            // Property generated for term  "45000"
            java.lang.Integer p5;

            // Property generated for term  "[HighTheftProbabilityAutoList]"
            java.util.Collection p6;

            // Property generated for term  "getType(<car>)"
            java.lang.String p7;

            // Property generated for term  "moderate"
            java.lang.String p8;
        }
        ;

        final bindingsInRule4 bindings = new bindingsInRule4();
        bindings.p8 = "moderate";
        bindings.p6 = Constants.HighTheftProbabilityAutoList;
        bindings.p4 = car.getPrice();
        bindings.p3 = 20000;
        bindings.p2 = car;
        bindings.p5 = 45000;
        bindings.p7 = car.getType();
        bindings.p1 = car.getPrice();

        // code for prereq greater_than_ii(getPrice(<car>),20000)
        final ResourceIterator<greater_than_ii> iterator1 = KBFragement_greater_than_ii_11.greater_than_ii_11(car.getPrice(),
                20000, _derivation.increaseDepth());

        // code for prereq less_than_ii(getPrice(<car>),45000)
        final ResourceIterator<less_than_ii> iterator2 = new NestedIterator<greater_than_ii, less_than_ii>(iterator1) {
                public ResourceIterator<less_than_ii> getNextIterator(
                    greater_than_ii object) {
                    bindings.p1 = object.slot1;
                    bindings.p3 = 20000;

                    return KBFragement_less_than_ii_11.less_than_ii_11(bindings.p4,
                        bindings.p5, _derivation.increaseDepth());
                }
            };

        // code for prereq contains([HighTheftProbabilityAutoList],getType(<car>))
        final ResourceIterator<not_contains> iterator3 = new NestedIterator<less_than_ii, not_contains>(iterator2) {
                public ResourceIterator<not_contains> getNextIterator(
                    less_than_ii object) {
                    bindings.p4 = object.slot1;
                    bindings.p5 = 45000;

                    return KBFragement_not_contains_11.not_contains_11(bindings.p6,
                        bindings.p7, _derivation.increaseDepth());
                }
            };

        // code for prereq /potentialTheftRating(<car>,moderate)
        final ResourceIterator<PotentialTheftRating> iterator4 = new NestedIterator<not_contains, PotentialTheftRating>(iterator3) {
                public ResourceIterator<PotentialTheftRating> getNextIterator(
                    not_contains object) {
                    bindings.p6 = Constants.HighTheftProbabilityAutoList;
                    bindings.p7 = (java.lang.String) object.slot2;

                    return new SingletonIterator(new PotentialTheftRating(
                            bindings.p2, bindings.p8));
                }
            };

        return iterator4;
    }

    /**
     * Method generated for query /potentialTheftRating[in,out]
     * @param car input parameter generated from slot 0
     * @return an iterator for instances of PotentialTheftRating
    */
    private static ResourceIterator<PotentialTheftRating> getPotenialTheftRating_4(
        final example.nz.org.take.compiler.userv.domainmodel.Car car,
        final DerivationController _derivation) {
        _derivation.log("AE_PTC05", DerivationController.RULE, car,
            DerivationController.NIL);

        // Variable bindings in rule:  IF less_than_ii(getPrice(<car>),20000) AND contains([HighTheftProbabilityAutoList],getType(<car>)) THEN /potentialTheftRating(<car>,low)
        class bindingsInRule5 {
            // Property generated for term  "getPrice(<car>)"
            int p1;

            // Property generated for term  "<car>"
            example.nz.org.take.compiler.userv.domainmodel.Car p2;

            // Property generated for term  "20000"
            java.lang.Integer p3;

            // Property generated for term  "[HighTheftProbabilityAutoList]"
            java.util.Collection p4;

            // Property generated for term  "getType(<car>)"
            java.lang.String p5;

            // Property generated for term  "low"
            java.lang.String p6;
        }
        ;

        final bindingsInRule5 bindings = new bindingsInRule5();
        bindings.p6 = "low";
        bindings.p5 = car.getType();
        bindings.p4 = Constants.HighTheftProbabilityAutoList;
        bindings.p3 = 20000;
        bindings.p2 = car;
        bindings.p1 = car.getPrice();

        // code for prereq less_than_ii(getPrice(<car>),20000)
        final ResourceIterator<less_than_ii> iterator1 = KBFragement_less_than_ii_11.less_than_ii_11(car.getPrice(),
                20000, _derivation.increaseDepth());

        // code for prereq contains([HighTheftProbabilityAutoList],getType(<car>))
        final ResourceIterator<not_contains> iterator2 = new NestedIterator<less_than_ii, not_contains>(iterator1) {
                public ResourceIterator<not_contains> getNextIterator(
                    less_than_ii object) {
                    bindings.p1 = object.slot1;
                    bindings.p3 = 20000;

                    return KBFragement_not_contains_11.not_contains_11(bindings.p4,
                        bindings.p5, _derivation.increaseDepth());
                }
            };

        // code for prereq /potentialTheftRating(<car>,low)
        final ResourceIterator<PotentialTheftRating> iterator3 = new NestedIterator<not_contains, PotentialTheftRating>(iterator2) {
                public ResourceIterator<PotentialTheftRating> getNextIterator(
                    not_contains object) {
                    bindings.p4 = Constants.HighTheftProbabilityAutoList;
                    bindings.p5 = (java.lang.String) object.slot2;

                    return new SingletonIterator(new PotentialTheftRating(
                            bindings.p2, bindings.p6));
                }
            };

        return iterator3;
    }

    /**
     * Method generated for query /potentialTheftRating[in,in]
     * @param car input parameter generated from slot 0
     * @param rating input parameter generated from slot 1
     * @return an iterator for instances of PotentialTheftRating
    */
    public static ResultSet<PotentialTheftRating> getPotenialTheftRating(
        final example.nz.org.take.compiler.userv.domainmodel.Car car,
        final java.lang.String rating) {
        DerivationController _derivation = new DefaultDerivationController();
        ResultSet<PotentialTheftRating> _result = new ResultSet(KBFragement_getPotenialTheftRating.getPotenialTheftRating(
                    car, rating, _derivation), _derivation);

        return _result;
    }

    /**
     * Method generated for query /potentialTheftRating[in,in]
     * @param car input parameter generated from slot 0
     * @param rating input parameter generated from slot 1
     * @return an iterator for instances of PotentialTheftRating
    */
    static ResourceIterator<PotentialTheftRating> getPotenialTheftRating(
        final example.nz.org.take.compiler.userv.domainmodel.Car car,
        final java.lang.String rating, final DerivationController _derivation) {
        final int _derivationlevel = _derivation.getDepth();
        ResourceIterator<PotentialTheftRating> result = new IteratorChain<PotentialTheftRating>(5) {
                public Object getIteratorOrObject(int pos) {
                    switch (pos) {
                    //  IF isConvertible(<car>) THEN /potentialTheftRating(<car>,high)
                    case 0:
                        return getPotenialTheftRating_0(car, rating,
                            _derivation.reset(_derivationlevel));

                    //  IF greater_than_ii(getPrice(<car>),45000) THEN /potentialTheftRating(<car>,high)
                    case 1:
                        return getPotenialTheftRating_1(car, rating,
                            _derivation.reset(_derivationlevel));

                    //  IF contains([HighTheftProbabilityAutoList],getType(<car>)) THEN /potentialTheftRating(<car>,high)
                    case 2:
                        return getPotenialTheftRating_2(car, rating,
                            _derivation.reset(_derivationlevel));

                    //  IF greater_than_ii(getPrice(<car>),20000) AND less_than_ii(getPrice(<car>),45000) AND contains([HighTheftProbabilityAutoList],getType(<car>)) THEN /potentialTheftRating(<car>,moderate)
                    case 3:
                        return getPotenialTheftRating_3(car, rating,
                            _derivation.reset(_derivationlevel));

                    //  IF less_than_ii(getPrice(<car>),20000) AND contains([HighTheftProbabilityAutoList],getType(<car>)) THEN /potentialTheftRating(<car>,low)
                    case 4:
                        return getPotenialTheftRating_4(car, rating,
                            _derivation.reset(_derivationlevel));

                    default:
                        return EmptyIterator.DEFAULT;
                    } // switch(pos)
                } // getIterator()

                public String getRuleRef(int pos) {
                    switch (pos) {
                    //  IF isConvertible(<car>) THEN /potentialTheftRating(<car>,high)
                    case 0:
                        return "AE_PTC01";

                    //  IF greater_than_ii(getPrice(<car>),45000) THEN /potentialTheftRating(<car>,high)
                    case 1:
                        return "AE_PTC02";

                    //  IF contains([HighTheftProbabilityAutoList],getType(<car>)) THEN /potentialTheftRating(<car>,high)
                    case 2:
                        return "AE_PTC03";

                    //  IF greater_than_ii(getPrice(<car>),20000) AND less_than_ii(getPrice(<car>),45000) AND contains([HighTheftProbabilityAutoList],getType(<car>)) THEN /potentialTheftRating(<car>,moderate)
                    case 3:
                        return "AE_PTC04";

                    //  IF less_than_ii(getPrice(<car>),20000) AND contains([HighTheftProbabilityAutoList],getType(<car>)) THEN /potentialTheftRating(<car>,low)
                    case 4:
                        return "AE_PTC05";

                    default:
                        return "";
                    } // switch(pos)
                } // getRuleRef()
            };

        return result;
    }

    /**
     * Method generated for query /potentialTheftRating[in,in]
     * @param car input parameter generated from slot 0
     * @param rating input parameter generated from slot 1
     * @return an iterator for instances of PotentialTheftRating
    */
    private static ResourceIterator<PotentialTheftRating> getPotenialTheftRating_0(
        final example.nz.org.take.compiler.userv.domainmodel.Car car,
        final java.lang.String rating, final DerivationController _derivation) {
        _derivation.log("AE_PTC01", DerivationController.RULE, car, rating);

        // comparing constants in rule head with parameters
        if (!"high".equals(rating)) {
            return EmptyIterator.DEFAULT;
        }

        // Variable bindings in rule:  IF isConvertible(<car>) THEN /potentialTheftRating(<car>,high)
        class bindingsInRule1 {
            // Property generated for term  "<car>"
            example.nz.org.take.compiler.userv.domainmodel.Car p1;

            // Property generated for term  "high"
            java.lang.String p2;
        }
        ;

        final bindingsInRule1 bindings = new bindingsInRule1();
        bindings.p2 = "high";
        bindings.p1 = car;

        // code for prereq isConvertible(<car>)
        final ResourceIterator<isConvertible> iterator1 = KBFragement_isConvertible_1.isConvertible_1(car,
                _derivation.increaseDepth());

        // code for prereq /potentialTheftRating(<car>,high)
        final ResourceIterator<PotentialTheftRating> iterator2 = new NestedIterator<isConvertible, PotentialTheftRating>(iterator1) {
                public ResourceIterator<PotentialTheftRating> getNextIterator(
                    isConvertible object) {
                    bindings.p1 = object.slot1;

                    return new SingletonIterator(new PotentialTheftRating(
                            bindings.p1, bindings.p2));
                }
            };

        return iterator2;
    }

    /**
     * Method generated for query /potentialTheftRating[in,in]
     * @param car input parameter generated from slot 0
     * @param rating input parameter generated from slot 1
     * @return an iterator for instances of PotentialTheftRating
    */
    private static ResourceIterator<PotentialTheftRating> getPotenialTheftRating_1(
        final example.nz.org.take.compiler.userv.domainmodel.Car car,
        final java.lang.String rating, final DerivationController _derivation) {
        _derivation.log("AE_PTC02", DerivationController.RULE, car, rating);

        // comparing constants in rule head with parameters
        if (!"high".equals(rating)) {
            return EmptyIterator.DEFAULT;
        }

        // Variable bindings in rule:  IF greater_than_ii(getPrice(<car>),45000) THEN /potentialTheftRating(<car>,high)
        class bindingsInRule2 {
            // Property generated for term  "getPrice(<car>)"
            int p1;

            // Property generated for term  "<car>"
            example.nz.org.take.compiler.userv.domainmodel.Car p2;

            // Property generated for term  "45000"
            java.lang.Integer p3;

            // Property generated for term  "high"
            java.lang.String p4;
        }
        ;

        final bindingsInRule2 bindings = new bindingsInRule2();
        bindings.p4 = "high";
        bindings.p2 = car;
        bindings.p3 = 45000;
        bindings.p1 = car.getPrice();

        // code for prereq greater_than_ii(getPrice(<car>),45000)
        final ResourceIterator<greater_than_ii> iterator1 = KBFragement_greater_than_ii_11.greater_than_ii_11(car.getPrice(),
                45000, _derivation.increaseDepth());

        // code for prereq /potentialTheftRating(<car>,high)
        final ResourceIterator<PotentialTheftRating> iterator2 = new NestedIterator<greater_than_ii, PotentialTheftRating>(iterator1) {
                public ResourceIterator<PotentialTheftRating> getNextIterator(
                    greater_than_ii object) {
                    bindings.p1 = object.slot1;
                    bindings.p3 = 45000;

                    return new SingletonIterator(new PotentialTheftRating(
                            bindings.p2, bindings.p4));
                }
            };

        return iterator2;
    }

    /**
     * Method generated for query /potentialTheftRating[in,in]
     * @param car input parameter generated from slot 0
     * @param rating input parameter generated from slot 1
     * @return an iterator for instances of PotentialTheftRating
    */
    private static ResourceIterator<PotentialTheftRating> getPotenialTheftRating_2(
        final example.nz.org.take.compiler.userv.domainmodel.Car car,
        final java.lang.String rating, final DerivationController _derivation) {
        _derivation.log("AE_PTC03", DerivationController.RULE, car, rating);

        // comparing constants in rule head with parameters
        if (!"high".equals(rating)) {
            return EmptyIterator.DEFAULT;
        }

        // Variable bindings in rule:  IF contains([HighTheftProbabilityAutoList],getType(<car>)) THEN /potentialTheftRating(<car>,high)
        class bindingsInRule3 {
            // Property generated for term  "[HighTheftProbabilityAutoList]"
            java.util.Collection p1;

            // Property generated for term  "getType(<car>)"
            java.lang.String p2;

            // Property generated for term  "<car>"
            example.nz.org.take.compiler.userv.domainmodel.Car p3;

            // Property generated for term  "high"
            java.lang.String p4;
        }
        ;

        final bindingsInRule3 bindings = new bindingsInRule3();
        bindings.p1 = Constants.HighTheftProbabilityAutoList;
        bindings.p4 = "high";
        bindings.p3 = car;
        bindings.p2 = car.getType();

        // code for prereq contains([HighTheftProbabilityAutoList],getType(<car>))
        final ResourceIterator<contains> iterator1 = KBFragement_contains_11.contains_11(Constants.HighTheftProbabilityAutoList,
                car.getType(), _derivation.increaseDepth());

        // code for prereq /potentialTheftRating(<car>,high)
        final ResourceIterator<PotentialTheftRating> iterator2 = new NestedIterator<contains, PotentialTheftRating>(iterator1) {
                public ResourceIterator<PotentialTheftRating> getNextIterator(
                    contains object) {
                    bindings.p1 = Constants.HighTheftProbabilityAutoList;
                    bindings.p2 = (java.lang.String) object.slot2;

                    return new SingletonIterator(new PotentialTheftRating(
                            bindings.p3, bindings.p4));
                }
            };

        return iterator2;
    }

    /**
     * Method generated for query /potentialTheftRating[in,in]
     * @param car input parameter generated from slot 0
     * @param rating input parameter generated from slot 1
     * @return an iterator for instances of PotentialTheftRating
    */
    private static ResourceIterator<PotentialTheftRating> getPotenialTheftRating_3(
        final example.nz.org.take.compiler.userv.domainmodel.Car car,
        final java.lang.String rating, final DerivationController _derivation) {
        _derivation.log("AE_PTC04", DerivationController.RULE, car, rating);

        // comparing constants in rule head with parameters
        if (!"moderate".equals(rating)) {
            return EmptyIterator.DEFAULT;
        }

        // Variable bindings in rule:  IF greater_than_ii(getPrice(<car>),20000) AND less_than_ii(getPrice(<car>),45000) AND contains([HighTheftProbabilityAutoList],getType(<car>)) THEN /potentialTheftRating(<car>,moderate)
        class bindingsInRule4 {
            // Property generated for term  "getPrice(<car>)"
            int p1;

            // Property generated for term  "<car>"
            example.nz.org.take.compiler.userv.domainmodel.Car p2;

            // Property generated for term  "20000"
            java.lang.Integer p3;

            // Property generated for term  "getPrice(<car>)"
            int p4;

            // Property generated for term  "45000"
            java.lang.Integer p5;

            // Property generated for term  "[HighTheftProbabilityAutoList]"
            java.util.Collection p6;

            // Property generated for term  "getType(<car>)"
            java.lang.String p7;

            // Property generated for term  "moderate"
            java.lang.String p8;
        }
        ;

        final bindingsInRule4 bindings = new bindingsInRule4();
        bindings.p8 = "moderate";
        bindings.p6 = Constants.HighTheftProbabilityAutoList;
        bindings.p4 = car.getPrice();
        bindings.p3 = 20000;
        bindings.p2 = car;
        bindings.p5 = 45000;
        bindings.p7 = car.getType();
        bindings.p1 = car.getPrice();

        // code for prereq greater_than_ii(getPrice(<car>),20000)
        final ResourceIterator<greater_than_ii> iterator1 = KBFragement_greater_than_ii_11.greater_than_ii_11(car.getPrice(),
                20000, _derivation.increaseDepth());

        // code for prereq less_than_ii(getPrice(<car>),45000)
        final ResourceIterator<less_than_ii> iterator2 = new NestedIterator<greater_than_ii, less_than_ii>(iterator1) {
                public ResourceIterator<less_than_ii> getNextIterator(
                    greater_than_ii object) {
                    bindings.p1 = object.slot1;
                    bindings.p3 = 20000;

                    return KBFragement_less_than_ii_11.less_than_ii_11(bindings.p4,
                        bindings.p5, _derivation.increaseDepth());
                }
            };

        // code for prereq contains([HighTheftProbabilityAutoList],getType(<car>))
        final ResourceIterator<not_contains> iterator3 = new NestedIterator<less_than_ii, not_contains>(iterator2) {
                public ResourceIterator<not_contains> getNextIterator(
                    less_than_ii object) {
                    bindings.p4 = object.slot1;
                    bindings.p5 = 45000;

                    return KBFragement_not_contains_11.not_contains_11(bindings.p6,
                        bindings.p7, _derivation.increaseDepth());
                }
            };

        // code for prereq /potentialTheftRating(<car>,moderate)
        final ResourceIterator<PotentialTheftRating> iterator4 = new NestedIterator<not_contains, PotentialTheftRating>(iterator3) {
                public ResourceIterator<PotentialTheftRating> getNextIterator(
                    not_contains object) {
                    bindings.p6 = Constants.HighTheftProbabilityAutoList;
                    bindings.p7 = (java.lang.String) object.slot2;

                    return new SingletonIterator(new PotentialTheftRating(
                            bindings.p2, bindings.p8));
                }
            };

        return iterator4;
    }

    /**
     * Method generated for query /potentialTheftRating[in,in]
     * @param car input parameter generated from slot 0
     * @param rating input parameter generated from slot 1
     * @return an iterator for instances of PotentialTheftRating
    */
    private static ResourceIterator<PotentialTheftRating> getPotenialTheftRating_4(
        final example.nz.org.take.compiler.userv.domainmodel.Car car,
        final java.lang.String rating, final DerivationController _derivation) {
        _derivation.log("AE_PTC05", DerivationController.RULE, car, rating);

        // comparing constants in rule head with parameters
        if (!"low".equals(rating)) {
            return EmptyIterator.DEFAULT;
        }

        // Variable bindings in rule:  IF less_than_ii(getPrice(<car>),20000) AND contains([HighTheftProbabilityAutoList],getType(<car>)) THEN /potentialTheftRating(<car>,low)
        class bindingsInRule5 {
            // Property generated for term  "getPrice(<car>)"
            int p1;

            // Property generated for term  "<car>"
            example.nz.org.take.compiler.userv.domainmodel.Car p2;

            // Property generated for term  "20000"
            java.lang.Integer p3;

            // Property generated for term  "[HighTheftProbabilityAutoList]"
            java.util.Collection p4;

            // Property generated for term  "getType(<car>)"
            java.lang.String p5;

            // Property generated for term  "low"
            java.lang.String p6;
        }
        ;

        final bindingsInRule5 bindings = new bindingsInRule5();
        bindings.p6 = "low";
        bindings.p5 = car.getType();
        bindings.p4 = Constants.HighTheftProbabilityAutoList;
        bindings.p3 = 20000;
        bindings.p2 = car;
        bindings.p1 = car.getPrice();

        // code for prereq less_than_ii(getPrice(<car>),20000)
        final ResourceIterator<less_than_ii> iterator1 = KBFragement_less_than_ii_11.less_than_ii_11(car.getPrice(),
                20000, _derivation.increaseDepth());

        // code for prereq contains([HighTheftProbabilityAutoList],getType(<car>))
        final ResourceIterator<not_contains> iterator2 = new NestedIterator<less_than_ii, not_contains>(iterator1) {
                public ResourceIterator<not_contains> getNextIterator(
                    less_than_ii object) {
                    bindings.p1 = object.slot1;
                    bindings.p3 = 20000;

                    return KBFragement_not_contains_11.not_contains_11(bindings.p4,
                        bindings.p5, _derivation.increaseDepth());
                }
            };

        // code for prereq /potentialTheftRating(<car>,low)
        final ResourceIterator<PotentialTheftRating> iterator3 = new NestedIterator<not_contains, PotentialTheftRating>(iterator2) {
                public ResourceIterator<PotentialTheftRating> getNextIterator(
                    not_contains object) {
                    bindings.p4 = Constants.HighTheftProbabilityAutoList;
                    bindings.p5 = (java.lang.String) object.slot2;

                    return new SingletonIterator(new PotentialTheftRating(
                            bindings.p2, bindings.p6));
                }
            };

        return iterator3;
    }
}
