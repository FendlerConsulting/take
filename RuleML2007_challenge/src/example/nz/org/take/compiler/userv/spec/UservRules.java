package example.nz.org.take.compiler.userv.spec;

import nz.org.take.rt.*;


/**
 * Interface generated by the take compiler.
 * @version Sun Oct 21 23:25:20 NZDT 2007
 */
@SuppressWarnings("unchecked")
public interface UservRules {
    /**
     * Method generated for query /potentialTheftRating[in,out]
     * @param car input parameter generated from slot 0
     * @return an iterator for instances of PotentialTheftRating
    */
    public ResultSet<PotentialTheftRating> getPotenialTheftRating(
        final example.nz.org.take.compiler.userv.domainmodel.Car car);

    /**
     * Method generated for query /potentialOccupantInjuryRating[in,out]
     * @param car input parameter generated from slot 0
     * @return an iterator for instances of PotentialOccupantInjuryRating
    */
    public ResultSet<PotentialOccupantInjuryRating> getPotentialOccupantInjuryRating(
        final example.nz.org.take.compiler.userv.domainmodel.Car car);

    /**
     * Method generated for query /autoEligibility[in,out]
     * @param car input parameter generated from slot 0
     * @return an iterator for instances of AutoEligibility
    */
    public ResultSet<AutoEligibility> getAutoEligibility(
        final example.nz.org.take.compiler.userv.domainmodel.Car car);

    /**
     * Method generated for query /driverCategory[in,out]
     * @param driver input parameter generated from slot 0
     * @return an iterator for instances of DriverCategory
    */
    public ResultSet<DriverCategory> getDriverCategory(
        final example.nz.org.take.compiler.userv.domainmodel.Driver driver);

    /**
     * Method generated for query /isEligible[in]
     * @param driver input parameter generated from slot 0
     * @return an iterator for instances of DriverEligibility
    */
    public ResultSet<DriverEligibility> getDriverEligibility(
        final example.nz.org.take.compiler.userv.domainmodel.Driver driver);

    /**
     * Method generated for query /isHighRiskDriver[in]
     * @param driver input parameter generated from slot 0
     * @return an iterator for instances of HighRiskDriver
    */
    public ResultSet<HighRiskDriver> isHighRiskDriver(
        final example.nz.org.take.compiler.userv.domainmodel.Driver driver);

    /**
     * Method generated for query /hasTrainingCertification[in]
     * @param driver input parameter generated from slot 0
     * @return an iterator for instances of TrainedDriver
    */
    public ResultSet<TrainedDriver> hasTrainingCertification(
        final example.nz.org.take.compiler.userv.domainmodel.Driver driver);

    /**
     * Method generated for query /policyEligibilityScore[in,in,out]
     * @param car input parameter generated from slot 0
     * @param driver input parameter generated from slot 1
     * @return an iterator for instances of PolicyEligibilityScore
    */
    public ResultSet<PolicyEligibilityScore> getPolicyEligibilityScore(
        final example.nz.org.take.compiler.userv.domainmodel.Car car,
        final example.nz.org.take.compiler.userv.domainmodel.Driver driver);

    /**
     * Method generated for query /insuranceEligibility[in,in,out]
     * @param car input parameter generated from slot 0
     * @param driver input parameter generated from slot 1
     * @return an iterator for instances of InsuranceEligibility
    */
    public ResultSet<InsuranceEligibility> getPolicyEligibility(
        final example.nz.org.take.compiler.userv.domainmodel.Car car,
        final example.nz.org.take.compiler.userv.domainmodel.Driver driver);

    /**
     * Method generated for query /isLongTermClient[in]
     * @param driver input parameter generated from slot 0
     * @return an iterator for instances of LongTermClient
    */
    public ResultSet<LongTermClient> isLongTermClient(
        final example.nz.org.take.compiler.userv.domainmodel.Driver driver);

    /**
     * Method generated for query /basePremium[in,out]
     * @param car input parameter generated from slot 0
     * @return an iterator for instances of BasePremium
    */
    public ResultSet<BasePremium> getBasePremium(
        final example.nz.org.take.compiler.userv.domainmodel.Car car);

    /**
     * Method generated for query /additionalPremium[in,in,out]
     * @param policy input parameter generated from slot 0
     * @param car input parameter generated from slot 1
     * @return an iterator for instances of AdditionalPremium
    */
    public ResultSet<AdditionalPremium> getAdditionalPremium(
        final example.nz.org.take.compiler.userv.domainmodel.Policy policy,
        final example.nz.org.take.compiler.userv.domainmodel.Car car);

    /**
     * Method generated for query /additionalDriverPremium[in,out]
     * @param driver input parameter generated from slot 0
     * @return an iterator for instances of AdditionalDriverPremium
    */
    public ResultSet<AdditionalDriverPremium> getAdditionalDriverPremium(
        final example.nz.org.take.compiler.userv.domainmodel.Driver driver);

    /**
     * Method generated for query /premiumDiscount[in,out]
     * @param car input parameter generated from slot 0
     * @return an iterator for instances of PremiumDiscount
    */
    public ResultSet<PremiumDiscount> getPremiumDiscount(
        final example.nz.org.take.compiler.userv.domainmodel.Car car);

    /**
    * Method that can be used to query annotations at runtime.
    * @param id the id of the rule (or other knowledge element)
    * @return a map of annotations (string-string mappings)
    * code generated using velocity template LocalAnnotationMethod.vm
    */
    public java.util.Map<String, String> getAnnotations(String id);

    /**
     * Method that can be used to query global annotations at runtime.
     * Global annotations are attached to the knowledge base, not to
     * a particular element (rule,..).
     * @return a map of annotations (string-string mappings)
     * code generated using velocity template GlobalAnnotationMethod.vm
    */
    public java.util.Map<String, String> getAnnotations();
}
