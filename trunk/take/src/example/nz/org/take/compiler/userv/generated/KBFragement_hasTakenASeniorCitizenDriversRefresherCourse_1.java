package example.nz.org.take.compiler.userv.generated;

import nz.org.take.rt.*;


/**
 * Class generated by the take compiler.
 * @version Sun Feb 03 21:41:18 NZDT 2008
 */
@SuppressWarnings("unchecked")
class KBFragement_hasTakenASeniorCitizenDriversRefresherCourse_1 {
    /**
     * Method generated for query hasTakenASeniorCitizenDriversRefresherCourse[in]
     * @param slot1 input parameter generated from slot 0
     * @return an iterator for instances of hasTakenASeniorCitizenDriversRefresherCourse
    */
    public static ResultSet<hasTakenASeniorCitizenDriversRefresherCourse> hasTakenASeniorCitizenDriversRefresherCourse_1(
        final example.nz.org.take.compiler.userv.domainmodel.Driver slot1) {
        DerivationController _derivation = new DefaultDerivationController();
        ResultSet<hasTakenASeniorCitizenDriversRefresherCourse> _result = new ResultSet(KBFragement_hasTakenASeniorCitizenDriversRefresherCourse_1.hasTakenASeniorCitizenDriversRefresherCourse_1(
                    slot1, _derivation), _derivation);

        return _result;
    }

    /**
     * Method generated for query hasTakenASeniorCitizenDriversRefresherCourse[in]
     * @param source
     * @param target
     * @return an iterator
     * code generated using velocity template JPredicate_11.vm
    */
    static ResourceIterator<hasTakenASeniorCitizenDriversRefresherCourse> hasTakenASeniorCitizenDriversRefresherCourse_1(
        final example.nz.org.take.compiler.userv.domainmodel.Driver slot1,
        final DerivationController _derivation) {
        _derivation.log("public boolean example.nz.org.take.compiler.userv.domainmodel.Driver.hasTakenASeniorCitizenDriversRefresherCourse()",
            DerivationController.JAVA_METHOD);

        if (slot1.hasTakenASeniorCitizenDriversRefresherCourse()) {
            hasTakenASeniorCitizenDriversRefresherCourse result = new hasTakenASeniorCitizenDriversRefresherCourse();
            result.slot1 = slot1;

            return new SingletonIterator<hasTakenASeniorCitizenDriversRefresherCourse>(result);
        }

        return EmptyIterator.DEFAULT;
    }
}
