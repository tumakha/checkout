package checkout;

import static java.util.Optional.ofNullable;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author Yuriy Tumakha
 */
public class Checkout {

  private PricingRules pricingRules;

  private final Map<String, Integer> items = new LinkedHashMap<>();

  public Checkout(PricingRules pricingRules) {
    this.pricingRules = pricingRules;
  }

  public void scan(String itemCode) {
    items.compute(itemCode, (code, quantity) -> ofNullable(quantity).orElse(0) + 1);
  }

  public Double getTotal() {
    return items.entrySet().stream()
        .mapToDouble(e -> getItemTotal(e.getKey(), e.getValue())).sum();
  }

  private Double getItemTotal(String code, Integer quantity) {
    Double price = pricingRules.getPrice(code);
    return pricingRules.getDiscount(code)
        .map(discount -> discount.getItemTotal(quantity, price)).orElse(price * quantity);
  }

}
