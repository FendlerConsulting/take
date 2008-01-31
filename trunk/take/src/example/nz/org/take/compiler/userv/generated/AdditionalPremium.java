package example.nz.org.take.compiler.userv.generated;

/**
 * Class generated by the take compiler.
 * This class represents the predicate additionalPremium
 * @version Fri Feb 01 12:12:07 NZDT 2008
 */
public class AdditionalPremium {
    public example.nz.org.take.compiler.userv.domainmodel.Policy policy;
    public example.nz.org.take.compiler.userv.domainmodel.Car car;
    public long premium;

    public AdditionalPremium(
        example.nz.org.take.compiler.userv.domainmodel.Policy policy,
        example.nz.org.take.compiler.userv.domainmodel.Car car, long premium) {
        super();
        this.policy = policy;
        this.car = car;
        this.premium = premium;
    }

    public AdditionalPremium() {
        super();
    }
}
