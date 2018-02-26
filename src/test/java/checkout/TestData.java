package checkout;

import static checkout.discount.Buy3For2.BUY_3_FOR_2_DISCOUNT;

import checkout.discount.Buy3For2;
import checkout.discount.BuyQuantityForPrice;
import checkout.discount.Discount;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Yuriy Tumakha
 */
public class TestData {

  public static final double DELTA = 0.001;

  public PricingRules getPricingRules() {
    return new PricingRules(getPrices(), getDiscounts());
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

  private Map<String, Discount> getDiscounts() {
    return new HashMap<String, Discount>() {
      {
        put("A", new BuyQuantityForPrice(3, 1.30));
        put("B", new BuyQuantityForPrice(2, 0.45));
        put("C", BUY_3_FOR_2_DISCOUNT);
      }
    };
  }

}
