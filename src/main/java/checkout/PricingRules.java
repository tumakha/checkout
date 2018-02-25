package checkout;

import static java.util.Optional.ofNullable;

import checkout.discount.Discount;
import java.util.Map;
import java.util.Optional;

/**
 * @author Yuriy Tumakha
 */
public class PricingRules {

  private Map<String, Double> prices;
  private Map<String, Discount> discounts;

  public PricingRules(Map<String, Double> prices, Map<String, Discount> discounts) {
    this.prices = prices;
    this.discounts = discounts;
  }

  public Double getPrice(String code) {
    return prices.getOrDefault(code, 0.0);
  }

  public Optional<Discount> getDiscount(String code) {
    return ofNullable(discounts.get(code));
  }

}
