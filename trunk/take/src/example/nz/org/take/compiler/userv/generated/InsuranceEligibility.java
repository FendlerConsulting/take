package example.nz.org.take.compiler.userv.generated;

/**
 * Class generated by the take compiler.
 * This class represents the predicate insuranceEligibility
 * @version Wed Nov 14 22:35:13 NZDT 2007
 */
public class InsuranceEligibility {
    public example.nz.org.take.compiler.userv.domainmodel.Car car;
    public example.nz.org.take.compiler.userv.domainmodel.Driver driver;
    public java.lang.String status;

    public InsuranceEligibility(
        example.nz.org.take.compiler.userv.domainmodel.Car car,
        example.nz.org.take.compiler.userv.domainmodel.Driver driver,
        java.lang.String status) {
        super();
        this.car = car;
        this.driver = driver;
        this.status = status;
    }

    public InsuranceEligibility() {
        super();
    }
}