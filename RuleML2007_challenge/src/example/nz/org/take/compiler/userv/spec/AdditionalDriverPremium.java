package example.nz.org.take.compiler.userv.spec;

/**
 * Class generated by the take compiler.
 * This class represents the predicate additionalDriverPremium
 * @version Sun Oct 21 23:25:20 NZDT 2007
 */
public class AdditionalDriverPremium {
    public example.nz.org.take.compiler.userv.domainmodel.Driver driver;
    public int premium;

    public AdditionalDriverPremium(
        example.nz.org.take.compiler.userv.domainmodel.Driver driver,
        int premium) {
        super();
        this.driver = driver;
        this.premium = premium;
    }

    public AdditionalDriverPremium() {
        super();
    }
}
