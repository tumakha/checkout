package checkout;

import static checkout.TestData.DELTA;
import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

/**
 * @author Yuriy Tumakha
 */
@RunWith(Parameterized.class)
public class CheckoutTest {

  private List<String> codes;
  private Double total;

  public CheckoutTest(String itemCodes, Double expectedTotal) {
    codes = asList(itemCodes.split(""));
    total = expectedTotal;
  }

  @Parameterized.Parameters(name = "{index}: \"{0}\" => Total: {1}")
  public static Iterable<Object[]> data() {
    return asList(new Object[][]{
        {"", 0.0},
        {"A", 0.50},
        {"AB", 0.80},
        {"CDBA", 3.55},
    });
  }

  @Test
  public void testGetTotal() {
    Checkout checkout = new Checkout(new TestData().getPricingRules());
    codes.forEach(checkout::scan);
    assertEquals("Wrong checkout total", total, checkout.getTotal(), DELTA);
  }

}
