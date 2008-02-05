package example.nz.org.take.compiler.userv.generated;

import nz.org.take.rt.*;


/**
 * Class generated by the take compiler.
 * @version Tue Feb 05 13:19:25 NZDT 2008
 */
@SuppressWarnings("unchecked")
class KBFragement_getPotentialOccupantInjuryRating {
    /**
     * Method generated for query /potentialOccupantInjuryRating[in,out]
     * @param car input parameter generated from slot 0
     * @return an iterator for instances of PotentialOccupantInjuryRating
    */
    public static ResultSet<PotentialOccupantInjuryRating> getPotentialOccupantInjuryRating(
        final example.nz.org.take.compiler.userv.domainmodel.Car car) {
        DerivationController _derivation = new DefaultDerivationController();
        ResultSet<PotentialOccupantInjuryRating> _result = new ResultSet(KBFragement_getPotentialOccupantInjuryRating.getPotentialOccupantInjuryRating(
                    car, _derivation), _derivation);

        return _result;
    }

    /**
     * Method generated for query /potentialOccupantInjuryRating[in,out]
     * @param car input parameter generated from slot 0
     * @return an iterator for instances of PotentialOccupantInjuryRating
    */
    static ResourceIterator<PotentialOccupantInjuryRating> getPotentialOccupantInjuryRating(
        final example.nz.org.take.compiler.userv.domainmodel.Car car,
        final DerivationController _derivation) {
        final int _derivationlevel = _derivation.getDepth();
        ResourceIterator<PotentialOccupantInjuryRating> result = new IteratorChain<PotentialOccupantInjuryRating>(5) {
                public Object getIteratorOrObject(int pos) {
                    switch (pos) {
                    // AE_POIC01  IF hasAirbags(<car>) THEN /potentialOccupantInjuryRating(<car>,extremely high)
                    case 0:
                        return getPotentialOccupantInjuryRating_0(car,
                            _derivation.reset(_derivationlevel));

                    // AE_POIC02  IF hasDriversAirbag(<car>) AND hasFrontPassengerAirbag(<car>) AND hasSidePanelAirbags(<car>) THEN /potentialOccupantInjuryRating(<car>,high)
                    case 1:
                        return getPotentialOccupantInjuryRating_1(car,
                            _derivation.reset(_derivationlevel));

                    // AE_POIC03  IF hasDriversAirbag(<car>) AND hasFrontPassengerAirbag(<car>) AND hasSidePanelAirbags(<car>) THEN /potentialOccupantInjuryRating(<car>,moderate)
                    case 2:
                        return getPotentialOccupantInjuryRating_2(car,
                            _derivation.reset(_derivationlevel));

                    // AE_POIC04  IF hasDriversAirbag(<car>) AND hasFrontPassengerAirbag(<car>) AND hasSidePanelAirbags(<car>) THEN /potentialOccupantInjuryRating(<car>,low)
                    case 3:
                        return getPotentialOccupantInjuryRating_3(car,
                            _derivation.reset(_derivationlevel));

                    // AE_POIC05  IF isConvertible(<car>) AND hasRollBar(<car>) THEN /potentialOccupantInjuryRating(<car>,extremely high)
                    case 4:
                        return getPotentialOccupantInjuryRating_4(car,
                            _derivation.reset(_derivationlevel));

                    default:
                        return EmptyIterator.DEFAULT;
                    } // switch(pos)
                } // getIterator()

                public String getRuleRef(int pos) {
                    switch (pos) {
                    // AE_POIC01  IF hasAirbags(<car>) THEN /potentialOccupantInjuryRating(<car>,extremely high)
                    case 0:
                        return "AE_POIC01";

                    // AE_POIC02  IF hasDriversAirbag(<car>) AND hasFrontPassengerAirbag(<car>) AND hasSidePanelAirbags(<car>) THEN /potentialOccupantInjuryRating(<car>,high)
                    case 1:
                        return "AE_POIC02";

                    // AE_POIC03  IF hasDriversAirbag(<car>) AND hasFrontPassengerAirbag(<car>) AND hasSidePanelAirbags(<car>) THEN /potentialOccupantInjuryRating(<car>,moderate)
                    case 2:
                        return "AE_POIC03";

                    // AE_POIC04  IF hasDriversAirbag(<car>) AND hasFrontPassengerAirbag(<car>) AND hasSidePanelAirbags(<car>) THEN /potentialOccupantInjuryRating(<car>,low)
                    case 3:
                        return "AE_POIC04";

                    // AE_POIC05  IF isConvertible(<car>) AND hasRollBar(<car>) THEN /potentialOccupantInjuryRating(<car>,extremely high)
                    case 4:
                        return "AE_POIC05";

                    default:
                        return "";
                    } // switch(pos)
                } // getRuleRef()
            };

        return result;
    }

    /**
     * Method generated for query /potentialOccupantInjuryRating[in,out]
     * @param car input parameter generated from slot 0
     * @return an iterator for instances of PotentialOccupantInjuryRating
    */
    private static ResourceIterator<PotentialOccupantInjuryRating> getPotentialOccupantInjuryRating_0(
        final example.nz.org.take.compiler.userv.domainmodel.Car car,
        final DerivationController _derivation) {
        _derivation.log("AE_POIC01", DerivationController.RULE, car,
            DerivationController.NIL);

        // Variable bindings in rule:  IF hasAirbags(<car>) THEN /potentialOccupantInjuryRating(<car>,extremely high)
        class bindingsInRule6 {
            // Property generated for term  "extremely high"
            java.lang.String p1;

            // Property generated for term  "<car>"
            example.nz.org.take.compiler.userv.domainmodel.Car p2;
        }
        ;

        final bindingsInRule6 bindings = new bindingsInRule6();
        bindings.p1 = "extremely high";
        bindings.p2 = car;

        // code for prereq hasAirbags(<car>)
        final ResourceIterator<not_hasAirbags> iterator1 = KBFragement_not_hasAirbags_1.not_hasAirbags_1(car,
                _derivation.increaseDepth());

        // code for prereq /potentialOccupantInjuryRating(<car>,extremely high)
        final ResourceIterator<PotentialOccupantInjuryRating> iterator2 = new NestedIterator<not_hasAirbags, PotentialOccupantInjuryRating>(iterator1) {
                public ResourceIterator<PotentialOccupantInjuryRating> getNextIterator(
                    not_hasAirbags object) {
                    bindings.p2 = object.slot1;

                    return new SingletonIterator(new PotentialOccupantInjuryRating(
                            bindings.p2, bindings.p1));
                }
            };

        return iterator2;
    }

    /**
     * Method generated for query /potentialOccupantInjuryRating[in,out]
     * @param car input parameter generated from slot 0
     * @return an iterator for instances of PotentialOccupantInjuryRating
    */
    private static ResourceIterator<PotentialOccupantInjuryRating> getPotentialOccupantInjuryRating_1(
        final example.nz.org.take.compiler.userv.domainmodel.Car car,
        final DerivationController _derivation) {
        _derivation.log("AE_POIC02", DerivationController.RULE, car,
            DerivationController.NIL);

        // Variable bindings in rule:  IF hasDriversAirbag(<car>) AND hasFrontPassengerAirbag(<car>) AND hasSidePanelAirbags(<car>) THEN /potentialOccupantInjuryRating(<car>,high)
        class bindingsInRule7 {
            // Property generated for term  "high"
            java.lang.String p1;

            // Property generated for term  "<car>"
            example.nz.org.take.compiler.userv.domainmodel.Car p2;
        }
        ;

        final bindingsInRule7 bindings = new bindingsInRule7();
        bindings.p1 = "high";
        bindings.p2 = car;

        // code for prereq hasDriversAirbag(<car>)
        final ResourceIterator<hasDriversAirbag> iterator1 = KBFragement_hasDriversAirbag_1.hasDriversAirbag_1(car,
                _derivation.increaseDepth());

        // code for prereq hasFrontPassengerAirbag(<car>)
        final ResourceIterator<not_hasFrontPassengerAirbag> iterator2 = new NestedIterator<hasDriversAirbag, not_hasFrontPassengerAirbag>(iterator1) {
                public ResourceIterator<not_hasFrontPassengerAirbag> getNextIterator(
                    hasDriversAirbag object) {
                    bindings.p2 = object.slot1;

                    return KBFragement_not_hasFrontPassengerAirbag_1.not_hasFrontPassengerAirbag_1(bindings.p2,
                        _derivation.increaseDepth());
                }
            };

        // code for prereq hasSidePanelAirbags(<car>)
        final ResourceIterator<not_hasSidePanelAirbags> iterator3 = new NestedIterator<not_hasFrontPassengerAirbag, not_hasSidePanelAirbags>(iterator2) {
                public ResourceIterator<not_hasSidePanelAirbags> getNextIterator(
                    not_hasFrontPassengerAirbag object) {
                    bindings.p2 = object.slot1;

                    return KBFragement_not_hasSidePanelAirbags_1.not_hasSidePanelAirbags_1(bindings.p2,
                        _derivation.increaseDepth());
                }
            };

        // code for prereq /potentialOccupantInjuryRating(<car>,high)
        final ResourceIterator<PotentialOccupantInjuryRating> iterator4 = new NestedIterator<not_hasSidePanelAirbags, PotentialOccupantInjuryRating>(iterator3) {
                public ResourceIterator<PotentialOccupantInjuryRating> getNextIterator(
                    not_hasSidePanelAirbags object) {
                    bindings.p2 = object.slot1;

                    return new SingletonIterator(new PotentialOccupantInjuryRating(
                            bindings.p2, bindings.p1));
                }
            };

        return iterator4;
    }

    /**
     * Method generated for query /potentialOccupantInjuryRating[in,out]
     * @param car input parameter generated from slot 0
     * @return an iterator for instances of PotentialOccupantInjuryRating
    */
    private static ResourceIterator<PotentialOccupantInjuryRating> getPotentialOccupantInjuryRating_2(
        final example.nz.org.take.compiler.userv.domainmodel.Car car,
        final DerivationController _derivation) {
        _derivation.log("AE_POIC03", DerivationController.RULE, car,
            DerivationController.NIL);

        // Variable bindings in rule:  IF hasDriversAirbag(<car>) AND hasFrontPassengerAirbag(<car>) AND hasSidePanelAirbags(<car>) THEN /potentialOccupantInjuryRating(<car>,moderate)
        class bindingsInRule8 {
            // Property generated for term  "moderate"
            java.lang.String p1;

            // Property generated for term  "<car>"
            example.nz.org.take.compiler.userv.domainmodel.Car p2;
        }
        ;

        final bindingsInRule8 bindings = new bindingsInRule8();
        bindings.p1 = "moderate";
        bindings.p2 = car;

        // code for prereq hasDriversAirbag(<car>)
        final ResourceIterator<hasDriversAirbag> iterator1 = KBFragement_hasDriversAirbag_1.hasDriversAirbag_1(car,
                _derivation.increaseDepth());

        // code for prereq hasFrontPassengerAirbag(<car>)
        final ResourceIterator<hasFrontPassengerAirbag> iterator2 = new NestedIterator<hasDriversAirbag, hasFrontPassengerAirbag>(iterator1) {
                public ResourceIterator<hasFrontPassengerAirbag> getNextIterator(
                    hasDriversAirbag object) {
                    bindings.p2 = object.slot1;

                    return KBFragement_hasFrontPassengerAirbag_1.hasFrontPassengerAirbag_1(bindings.p2,
                        _derivation.increaseDepth());
                }
            };

        // code for prereq hasSidePanelAirbags(<car>)
        final ResourceIterator<not_hasSidePanelAirbags> iterator3 = new NestedIterator<hasFrontPassengerAirbag, not_hasSidePanelAirbags>(iterator2) {
                public ResourceIterator<not_hasSidePanelAirbags> getNextIterator(
                    hasFrontPassengerAirbag object) {
                    bindings.p2 = object.slot1;

                    return KBFragement_not_hasSidePanelAirbags_1.not_hasSidePanelAirbags_1(bindings.p2,
                        _derivation.increaseDepth());
                }
            };

        // code for prereq /potentialOccupantInjuryRating(<car>,moderate)
        final ResourceIterator<PotentialOccupantInjuryRating> iterator4 = new NestedIterator<not_hasSidePanelAirbags, PotentialOccupantInjuryRating>(iterator3) {
                public ResourceIterator<PotentialOccupantInjuryRating> getNextIterator(
                    not_hasSidePanelAirbags object) {
                    bindings.p2 = object.slot1;

                    return new SingletonIterator(new PotentialOccupantInjuryRating(
                            bindings.p2, bindings.p1));
                }
            };

        return iterator4;
    }

    /**
     * Method generated for query /potentialOccupantInjuryRating[in,out]
     * @param car input parameter generated from slot 0
     * @return an iterator for instances of PotentialOccupantInjuryRating
    */
    private static ResourceIterator<PotentialOccupantInjuryRating> getPotentialOccupantInjuryRating_3(
        final example.nz.org.take.compiler.userv.domainmodel.Car car,
        final DerivationController _derivation) {
        _derivation.log("AE_POIC04", DerivationController.RULE, car,
            DerivationController.NIL);

        // Variable bindings in rule:  IF hasDriversAirbag(<car>) AND hasFrontPassengerAirbag(<car>) AND hasSidePanelAirbags(<car>) THEN /potentialOccupantInjuryRating(<car>,low)
        class bindingsInRule9 {
            // Property generated for term  "low"
            java.lang.String p1;

            // Property generated for term  "<car>"
            example.nz.org.take.compiler.userv.domainmodel.Car p2;
        }
        ;

        final bindingsInRule9 bindings = new bindingsInRule9();
        bindings.p1 = "low";
        bindings.p2 = car;

        // code for prereq hasDriversAirbag(<car>)
        final ResourceIterator<hasDriversAirbag> iterator1 = KBFragement_hasDriversAirbag_1.hasDriversAirbag_1(car,
                _derivation.increaseDepth());

        // code for prereq hasFrontPassengerAirbag(<car>)
        final ResourceIterator<hasFrontPassengerAirbag> iterator2 = new NestedIterator<hasDriversAirbag, hasFrontPassengerAirbag>(iterator1) {
                public ResourceIterator<hasFrontPassengerAirbag> getNextIterator(
                    hasDriversAirbag object) {
                    bindings.p2 = object.slot1;

                    return KBFragement_hasFrontPassengerAirbag_1.hasFrontPassengerAirbag_1(bindings.p2,
                        _derivation.increaseDepth());
                }
            };

        // code for prereq hasSidePanelAirbags(<car>)
        final ResourceIterator<hasSidePanelAirbags> iterator3 = new NestedIterator<hasFrontPassengerAirbag, hasSidePanelAirbags>(iterator2) {
                public ResourceIterator<hasSidePanelAirbags> getNextIterator(
                    hasFrontPassengerAirbag object) {
                    bindings.p2 = object.slot1;

                    return KBFragement_hasSidePanelAirbags_1.hasSidePanelAirbags_1(bindings.p2,
                        _derivation.increaseDepth());
                }
            };

        // code for prereq /potentialOccupantInjuryRating(<car>,low)
        final ResourceIterator<PotentialOccupantInjuryRating> iterator4 = new NestedIterator<hasSidePanelAirbags, PotentialOccupantInjuryRating>(iterator3) {
                public ResourceIterator<PotentialOccupantInjuryRating> getNextIterator(
                    hasSidePanelAirbags object) {
                    bindings.p2 = object.slot1;

                    return new SingletonIterator(new PotentialOccupantInjuryRating(
                            bindings.p2, bindings.p1));
                }
            };

        return iterator4;
    }

    /**
     * Method generated for query /potentialOccupantInjuryRating[in,out]
     * @param car input parameter generated from slot 0
     * @return an iterator for instances of PotentialOccupantInjuryRating
    */
    private static ResourceIterator<PotentialOccupantInjuryRating> getPotentialOccupantInjuryRating_4(
        final example.nz.org.take.compiler.userv.domainmodel.Car car,
        final DerivationController _derivation) {
        _derivation.log("AE_POIC05", DerivationController.RULE, car,
            DerivationController.NIL);

        // Variable bindings in rule:  IF isConvertible(<car>) AND hasRollBar(<car>) THEN /potentialOccupantInjuryRating(<car>,extremely high)
        class bindingsInRule10 {
            // Property generated for term  "extremely high"
            java.lang.String p1;

            // Property generated for term  "<car>"
            example.nz.org.take.compiler.userv.domainmodel.Car p2;
        }
        ;

        final bindingsInRule10 bindings = new bindingsInRule10();
        bindings.p1 = "extremely high";
        bindings.p2 = car;

        // code for prereq isConvertible(<car>)
        final ResourceIterator<isConvertible> iterator1 = KBFragement_isConvertible_1.isConvertible_1(car,
                _derivation.increaseDepth());

        // code for prereq hasRollBar(<car>)
        final ResourceIterator<not_hasRollBar> iterator2 = new NestedIterator<isConvertible, not_hasRollBar>(iterator1) {
                public ResourceIterator<not_hasRollBar> getNextIterator(
                    isConvertible object) {
                    bindings.p2 = object.slot1;

                    return KBFragement_not_hasRollBar_1.not_hasRollBar_1(bindings.p2,
                        _derivation.increaseDepth());
                }
            };

        // code for prereq /potentialOccupantInjuryRating(<car>,extremely high)
        final ResourceIterator<PotentialOccupantInjuryRating> iterator3 = new NestedIterator<not_hasRollBar, PotentialOccupantInjuryRating>(iterator2) {
                public ResourceIterator<PotentialOccupantInjuryRating> getNextIterator(
                    not_hasRollBar object) {
                    bindings.p2 = object.slot1;

                    return new SingletonIterator(new PotentialOccupantInjuryRating(
                            bindings.p2, bindings.p1));
                }
            };

        return iterator3;
    }

    /**
     * Method generated for query /potentialOccupantInjuryRating[in,in]
     * @param car input parameter generated from slot 0
     * @param rating input parameter generated from slot 1
     * @return an iterator for instances of PotentialOccupantInjuryRating
    */
    public static ResultSet<PotentialOccupantInjuryRating> getPotentialOccupantInjuryRating(
        final example.nz.org.take.compiler.userv.domainmodel.Car car,
        final java.lang.String rating) {
        DerivationController _derivation = new DefaultDerivationController();
        ResultSet<PotentialOccupantInjuryRating> _result = new ResultSet(KBFragement_getPotentialOccupantInjuryRating.getPotentialOccupantInjuryRating(
                    car, rating, _derivation), _derivation);

        return _result;
    }

    /**
     * Method generated for query /potentialOccupantInjuryRating[in,in]
     * @param car input parameter generated from slot 0
     * @param rating input parameter generated from slot 1
     * @return an iterator for instances of PotentialOccupantInjuryRating
    */
    static ResourceIterator<PotentialOccupantInjuryRating> getPotentialOccupantInjuryRating(
        final example.nz.org.take.compiler.userv.domainmodel.Car car,
        final java.lang.String rating, final DerivationController _derivation) {
        final int _derivationlevel = _derivation.getDepth();
        ResourceIterator<PotentialOccupantInjuryRating> result = new IteratorChain<PotentialOccupantInjuryRating>(5) {
                public Object getIteratorOrObject(int pos) {
                    switch (pos) {
                    // AE_POIC01  IF hasAirbags(<car>) THEN /potentialOccupantInjuryRating(<car>,extremely high)
                    case 0:
                        return getPotentialOccupantInjuryRating_0(car, rating,
                            _derivation.reset(_derivationlevel));

                    // AE_POIC02  IF hasDriversAirbag(<car>) AND hasFrontPassengerAirbag(<car>) AND hasSidePanelAirbags(<car>) THEN /potentialOccupantInjuryRating(<car>,high)
                    case 1:
                        return getPotentialOccupantInjuryRating_1(car, rating,
                            _derivation.reset(_derivationlevel));

                    // AE_POIC03  IF hasDriversAirbag(<car>) AND hasFrontPassengerAirbag(<car>) AND hasSidePanelAirbags(<car>) THEN /potentialOccupantInjuryRating(<car>,moderate)
                    case 2:
                        return getPotentialOccupantInjuryRating_2(car, rating,
                            _derivation.reset(_derivationlevel));

                    // AE_POIC04  IF hasDriversAirbag(<car>) AND hasFrontPassengerAirbag(<car>) AND hasSidePanelAirbags(<car>) THEN /potentialOccupantInjuryRating(<car>,low)
                    case 3:
                        return getPotentialOccupantInjuryRating_3(car, rating,
                            _derivation.reset(_derivationlevel));

                    // AE_POIC05  IF isConvertible(<car>) AND hasRollBar(<car>) THEN /potentialOccupantInjuryRating(<car>,extremely high)
                    case 4:
                        return getPotentialOccupantInjuryRating_4(car, rating,
                            _derivation.reset(_derivationlevel));

                    default:
                        return EmptyIterator.DEFAULT;
                    } // switch(pos)
                } // getIterator()

                public String getRuleRef(int pos) {
                    switch (pos) {
                    // AE_POIC01  IF hasAirbags(<car>) THEN /potentialOccupantInjuryRating(<car>,extremely high)
                    case 0:
                        return "AE_POIC01";

                    // AE_POIC02  IF hasDriversAirbag(<car>) AND hasFrontPassengerAirbag(<car>) AND hasSidePanelAirbags(<car>) THEN /potentialOccupantInjuryRating(<car>,high)
                    case 1:
                        return "AE_POIC02";

                    // AE_POIC03  IF hasDriversAirbag(<car>) AND hasFrontPassengerAirbag(<car>) AND hasSidePanelAirbags(<car>) THEN /potentialOccupantInjuryRating(<car>,moderate)
                    case 2:
                        return "AE_POIC03";

                    // AE_POIC04  IF hasDriversAirbag(<car>) AND hasFrontPassengerAirbag(<car>) AND hasSidePanelAirbags(<car>) THEN /potentialOccupantInjuryRating(<car>,low)
                    case 3:
                        return "AE_POIC04";

                    // AE_POIC05  IF isConvertible(<car>) AND hasRollBar(<car>) THEN /potentialOccupantInjuryRating(<car>,extremely high)
                    case 4:
                        return "AE_POIC05";

                    default:
                        return "";
                    } // switch(pos)
                } // getRuleRef()
            };

        return result;
    }

    /**
     * Method generated for query /potentialOccupantInjuryRating[in,in]
     * @param car input parameter generated from slot 0
     * @param rating input parameter generated from slot 1
     * @return an iterator for instances of PotentialOccupantInjuryRating
    */
    private static ResourceIterator<PotentialOccupantInjuryRating> getPotentialOccupantInjuryRating_0(
        final example.nz.org.take.compiler.userv.domainmodel.Car car,
        final java.lang.String rating, final DerivationController _derivation) {
        _derivation.log("AE_POIC01", DerivationController.RULE, car, rating);

        // comparing constants in rule head with parameters
        if (!"extremely high".equals(rating)) {
            return EmptyIterator.DEFAULT;
        }

        // Variable bindings in rule:  IF hasAirbags(<car>) THEN /potentialOccupantInjuryRating(<car>,extremely high)
        class bindingsInRule6 {
            // Property generated for term  "extremely high"
            java.lang.String p1;

            // Property generated for term  "<car>"
            example.nz.org.take.compiler.userv.domainmodel.Car p2;
        }
        ;

        final bindingsInRule6 bindings = new bindingsInRule6();
        bindings.p1 = "extremely high";
        bindings.p2 = car;

        // code for prereq hasAirbags(<car>)
        final ResourceIterator<not_hasAirbags> iterator1 = KBFragement_not_hasAirbags_1.not_hasAirbags_1(car,
                _derivation.increaseDepth());

        // code for prereq /potentialOccupantInjuryRating(<car>,extremely high)
        final ResourceIterator<PotentialOccupantInjuryRating> iterator2 = new NestedIterator<not_hasAirbags, PotentialOccupantInjuryRating>(iterator1) {
                public ResourceIterator<PotentialOccupantInjuryRating> getNextIterator(
                    not_hasAirbags object) {
                    bindings.p2 = object.slot1;

                    return new SingletonIterator(new PotentialOccupantInjuryRating(
                            bindings.p2, bindings.p1));
                }
            };

        return iterator2;
    }

    /**
     * Method generated for query /potentialOccupantInjuryRating[in,in]
     * @param car input parameter generated from slot 0
     * @param rating input parameter generated from slot 1
     * @return an iterator for instances of PotentialOccupantInjuryRating
    */
    private static ResourceIterator<PotentialOccupantInjuryRating> getPotentialOccupantInjuryRating_1(
        final example.nz.org.take.compiler.userv.domainmodel.Car car,
        final java.lang.String rating, final DerivationController _derivation) {
        _derivation.log("AE_POIC02", DerivationController.RULE, car, rating);

        // comparing constants in rule head with parameters
        if (!"high".equals(rating)) {
            return EmptyIterator.DEFAULT;
        }

        // Variable bindings in rule:  IF hasDriversAirbag(<car>) AND hasFrontPassengerAirbag(<car>) AND hasSidePanelAirbags(<car>) THEN /potentialOccupantInjuryRating(<car>,high)
        class bindingsInRule7 {
            // Property generated for term  "high"
            java.lang.String p1;

            // Property generated for term  "<car>"
            example.nz.org.take.compiler.userv.domainmodel.Car p2;
        }
        ;

        final bindingsInRule7 bindings = new bindingsInRule7();
        bindings.p1 = "high";
        bindings.p2 = car;

        // code for prereq hasDriversAirbag(<car>)
        final ResourceIterator<hasDriversAirbag> iterator1 = KBFragement_hasDriversAirbag_1.hasDriversAirbag_1(car,
                _derivation.increaseDepth());

        // code for prereq hasFrontPassengerAirbag(<car>)
        final ResourceIterator<not_hasFrontPassengerAirbag> iterator2 = new NestedIterator<hasDriversAirbag, not_hasFrontPassengerAirbag>(iterator1) {
                public ResourceIterator<not_hasFrontPassengerAirbag> getNextIterator(
                    hasDriversAirbag object) {
                    bindings.p2 = object.slot1;

                    return KBFragement_not_hasFrontPassengerAirbag_1.not_hasFrontPassengerAirbag_1(bindings.p2,
                        _derivation.increaseDepth());
                }
            };

        // code for prereq hasSidePanelAirbags(<car>)
        final ResourceIterator<not_hasSidePanelAirbags> iterator3 = new NestedIterator<not_hasFrontPassengerAirbag, not_hasSidePanelAirbags>(iterator2) {
                public ResourceIterator<not_hasSidePanelAirbags> getNextIterator(
                    not_hasFrontPassengerAirbag object) {
                    bindings.p2 = object.slot1;

                    return KBFragement_not_hasSidePanelAirbags_1.not_hasSidePanelAirbags_1(bindings.p2,
                        _derivation.increaseDepth());
                }
            };

        // code for prereq /potentialOccupantInjuryRating(<car>,high)
        final ResourceIterator<PotentialOccupantInjuryRating> iterator4 = new NestedIterator<not_hasSidePanelAirbags, PotentialOccupantInjuryRating>(iterator3) {
                public ResourceIterator<PotentialOccupantInjuryRating> getNextIterator(
                    not_hasSidePanelAirbags object) {
                    bindings.p2 = object.slot1;

                    return new SingletonIterator(new PotentialOccupantInjuryRating(
                            bindings.p2, bindings.p1));
                }
            };

        return iterator4;
    }

    /**
     * Method generated for query /potentialOccupantInjuryRating[in,in]
     * @param car input parameter generated from slot 0
     * @param rating input parameter generated from slot 1
     * @return an iterator for instances of PotentialOccupantInjuryRating
    */
    private static ResourceIterator<PotentialOccupantInjuryRating> getPotentialOccupantInjuryRating_2(
        final example.nz.org.take.compiler.userv.domainmodel.Car car,
        final java.lang.String rating, final DerivationController _derivation) {
        _derivation.log("AE_POIC03", DerivationController.RULE, car, rating);

        // comparing constants in rule head with parameters
        if (!"moderate".equals(rating)) {
            return EmptyIterator.DEFAULT;
        }

        // Variable bindings in rule:  IF hasDriversAirbag(<car>) AND hasFrontPassengerAirbag(<car>) AND hasSidePanelAirbags(<car>) THEN /potentialOccupantInjuryRating(<car>,moderate)
        class bindingsInRule8 {
            // Property generated for term  "moderate"
            java.lang.String p1;

            // Property generated for term  "<car>"
            example.nz.org.take.compiler.userv.domainmodel.Car p2;
        }
        ;

        final bindingsInRule8 bindings = new bindingsInRule8();
        bindings.p1 = "moderate";
        bindings.p2 = car;

        // code for prereq hasDriversAirbag(<car>)
        final ResourceIterator<hasDriversAirbag> iterator1 = KBFragement_hasDriversAirbag_1.hasDriversAirbag_1(car,
                _derivation.increaseDepth());

        // code for prereq hasFrontPassengerAirbag(<car>)
        final ResourceIterator<hasFrontPassengerAirbag> iterator2 = new NestedIterator<hasDriversAirbag, hasFrontPassengerAirbag>(iterator1) {
                public ResourceIterator<hasFrontPassengerAirbag> getNextIterator(
                    hasDriversAirbag object) {
                    bindings.p2 = object.slot1;

                    return KBFragement_hasFrontPassengerAirbag_1.hasFrontPassengerAirbag_1(bindings.p2,
                        _derivation.increaseDepth());
                }
            };

        // code for prereq hasSidePanelAirbags(<car>)
        final ResourceIterator<not_hasSidePanelAirbags> iterator3 = new NestedIterator<hasFrontPassengerAirbag, not_hasSidePanelAirbags>(iterator2) {
                public ResourceIterator<not_hasSidePanelAirbags> getNextIterator(
                    hasFrontPassengerAirbag object) {
                    bindings.p2 = object.slot1;

                    return KBFragement_not_hasSidePanelAirbags_1.not_hasSidePanelAirbags_1(bindings.p2,
                        _derivation.increaseDepth());
                }
            };

        // code for prereq /potentialOccupantInjuryRating(<car>,moderate)
        final ResourceIterator<PotentialOccupantInjuryRating> iterator4 = new NestedIterator<not_hasSidePanelAirbags, PotentialOccupantInjuryRating>(iterator3) {
                public ResourceIterator<PotentialOccupantInjuryRating> getNextIterator(
                    not_hasSidePanelAirbags object) {
                    bindings.p2 = object.slot1;

                    return new SingletonIterator(new PotentialOccupantInjuryRating(
                            bindings.p2, bindings.p1));
                }
            };

        return iterator4;
    }

    /**
     * Method generated for query /potentialOccupantInjuryRating[in,in]
     * @param car input parameter generated from slot 0
     * @param rating input parameter generated from slot 1
     * @return an iterator for instances of PotentialOccupantInjuryRating
    */
    private static ResourceIterator<PotentialOccupantInjuryRating> getPotentialOccupantInjuryRating_3(
        final example.nz.org.take.compiler.userv.domainmodel.Car car,
        final java.lang.String rating, final DerivationController _derivation) {
        _derivation.log("AE_POIC04", DerivationController.RULE, car, rating);

        // comparing constants in rule head with parameters
        if (!"low".equals(rating)) {
            return EmptyIterator.DEFAULT;
        }

        // Variable bindings in rule:  IF hasDriversAirbag(<car>) AND hasFrontPassengerAirbag(<car>) AND hasSidePanelAirbags(<car>) THEN /potentialOccupantInjuryRating(<car>,low)
        class bindingsInRule9 {
            // Property generated for term  "low"
            java.lang.String p1;

            // Property generated for term  "<car>"
            example.nz.org.take.compiler.userv.domainmodel.Car p2;
        }
        ;

        final bindingsInRule9 bindings = new bindingsInRule9();
        bindings.p1 = "low";
        bindings.p2 = car;

        // code for prereq hasDriversAirbag(<car>)
        final ResourceIterator<hasDriversAirbag> iterator1 = KBFragement_hasDriversAirbag_1.hasDriversAirbag_1(car,
                _derivation.increaseDepth());

        // code for prereq hasFrontPassengerAirbag(<car>)
        final ResourceIterator<hasFrontPassengerAirbag> iterator2 = new NestedIterator<hasDriversAirbag, hasFrontPassengerAirbag>(iterator1) {
                public ResourceIterator<hasFrontPassengerAirbag> getNextIterator(
                    hasDriversAirbag object) {
                    bindings.p2 = object.slot1;

                    return KBFragement_hasFrontPassengerAirbag_1.hasFrontPassengerAirbag_1(bindings.p2,
                        _derivation.increaseDepth());
                }
            };

        // code for prereq hasSidePanelAirbags(<car>)
        final ResourceIterator<hasSidePanelAirbags> iterator3 = new NestedIterator<hasFrontPassengerAirbag, hasSidePanelAirbags>(iterator2) {
                public ResourceIterator<hasSidePanelAirbags> getNextIterator(
                    hasFrontPassengerAirbag object) {
                    bindings.p2 = object.slot1;

                    return KBFragement_hasSidePanelAirbags_1.hasSidePanelAirbags_1(bindings.p2,
                        _derivation.increaseDepth());
                }
            };

        // code for prereq /potentialOccupantInjuryRating(<car>,low)
        final ResourceIterator<PotentialOccupantInjuryRating> iterator4 = new NestedIterator<hasSidePanelAirbags, PotentialOccupantInjuryRating>(iterator3) {
                public ResourceIterator<PotentialOccupantInjuryRating> getNextIterator(
                    hasSidePanelAirbags object) {
                    bindings.p2 = object.slot1;

                    return new SingletonIterator(new PotentialOccupantInjuryRating(
                            bindings.p2, bindings.p1));
                }
            };

        return iterator4;
    }

    /**
     * Method generated for query /potentialOccupantInjuryRating[in,in]
     * @param car input parameter generated from slot 0
     * @param rating input parameter generated from slot 1
     * @return an iterator for instances of PotentialOccupantInjuryRating
    */
    private static ResourceIterator<PotentialOccupantInjuryRating> getPotentialOccupantInjuryRating_4(
        final example.nz.org.take.compiler.userv.domainmodel.Car car,
        final java.lang.String rating, final DerivationController _derivation) {
        _derivation.log("AE_POIC05", DerivationController.RULE, car, rating);

        // comparing constants in rule head with parameters
        if (!"extremely high".equals(rating)) {
            return EmptyIterator.DEFAULT;
        }

        // Variable bindings in rule:  IF isConvertible(<car>) AND hasRollBar(<car>) THEN /potentialOccupantInjuryRating(<car>,extremely high)
        class bindingsInRule10 {
            // Property generated for term  "extremely high"
            java.lang.String p1;

            // Property generated for term  "<car>"
            example.nz.org.take.compiler.userv.domainmodel.Car p2;
        }
        ;

        final bindingsInRule10 bindings = new bindingsInRule10();
        bindings.p1 = "extremely high";
        bindings.p2 = car;

        // code for prereq isConvertible(<car>)
        final ResourceIterator<isConvertible> iterator1 = KBFragement_isConvertible_1.isConvertible_1(car,
                _derivation.increaseDepth());

        // code for prereq hasRollBar(<car>)
        final ResourceIterator<not_hasRollBar> iterator2 = new NestedIterator<isConvertible, not_hasRollBar>(iterator1) {
                public ResourceIterator<not_hasRollBar> getNextIterator(
                    isConvertible object) {
                    bindings.p2 = object.slot1;

                    return KBFragement_not_hasRollBar_1.not_hasRollBar_1(bindings.p2,
                        _derivation.increaseDepth());
                }
            };

        // code for prereq /potentialOccupantInjuryRating(<car>,extremely high)
        final ResourceIterator<PotentialOccupantInjuryRating> iterator3 = new NestedIterator<not_hasRollBar, PotentialOccupantInjuryRating>(iterator2) {
                public ResourceIterator<PotentialOccupantInjuryRating> getNextIterator(
                    not_hasRollBar object) {
                    bindings.p2 = object.slot1;

                    return new SingletonIterator(new PotentialOccupantInjuryRating(
                            bindings.p2, bindings.p1));
                }
            };

        return iterator3;
    }
}
