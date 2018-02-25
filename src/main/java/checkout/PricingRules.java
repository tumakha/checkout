package checkout;

import java.util.Map;

/**
 * @author Yuriy Tumakha
 */
public class PricingRules {

  private Map<String, Double> prices;

  public PricingRules(Map<String, Double> prices) {
    this.prices = prices;
  }

  public Double getPrice(String key) {
    return prices.getOrDefault(key, 0.0);
  }

}
