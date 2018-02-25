package checkout;

import static checkout.TestData.DELTA;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * @author Yuriy Tumakha
 */
public class CheckoutSequentialTest {

  private Checkout checkout = new Checkout(new TestData().getPricingRules());

  @Test
  public void testScanAndTotal() {
    assertEquals("Wrong init total", 0.0, checkout.getTotal(), DELTA);
    scanCodeCheckTotal("A", 0.5);
    scanCodeCheckTotal("B", 0.8);
    scanCodeCheckTotal("A", 1.3);
    scanCodeCheckTotal("A", 1.6);
    scanCodeCheckTotal("B", 1.75);
  }

  private void scanCodeCheckTotal(String code, Double expectedTotal) {
    checkout.scan(code);
    assertEquals("Wrong checkout total", expectedTotal, checkout.getTotal(), DELTA);
  }

}
