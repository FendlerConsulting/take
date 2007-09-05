package example.nz.org.take.compiler.userv.generated;

/**
 * Class generated by the take compiler.
 * This class represents the predicate policyEligibilityScore
 * @version Wed Sep 05 23:20:43 NZST 2007
 */
public class PolicyEligibilityScore {
    public example.nz.org.take.compiler.userv.domainmodel.Car car;
    public example.nz.org.take.compiler.userv.domainmodel.Driver driver;
    public int score;

    public PolicyEligibilityScore(
        example.nz.org.take.compiler.userv.domainmodel.Car car,
        example.nz.org.take.compiler.userv.domainmodel.Driver driver, int score) {
        super();
        this.car = car;
        this.driver = driver;
        this.score = score;
    }

    public PolicyEligibilityScore() {
        super();
    }
}
