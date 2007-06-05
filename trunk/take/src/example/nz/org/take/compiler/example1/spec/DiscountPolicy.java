package example.nz.org.take.compiler.example1.spec;
import nz.org.take.rt.*;
/**
 * Interface generated by the take compiler. 
 * @version Tue Jun 05 14:44:41 PDT 2007
 */
@SuppressWarnings("unchecked")
public interface DiscountPolicy{
/**
 * Method generated for query /discount[in,out]
 * @param customer input parameter generated from slot 0
 * @return an iterator for instances of CustomerDiscount
*/
public ResultSet<CustomerDiscount> getDiscount(final example.nz.org.take.compiler.example1.Customer customer)
;
}
