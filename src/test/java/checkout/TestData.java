package checkout;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Yuriy Tumakha
 */
public class TestData {

  static final double DELTA = 0.001;

  public PricingRules getPricingRules() {
    return new PricingRules(getPrices());
  }

  private Map<String, Double> getPrices() {
    return new HashMap<String, Double>() {
      {
        put("A", 0.50);
        put("B", 0.30);
        put("C", 2.00);
        put("D", 0.75);
      }
    };
  }

}
