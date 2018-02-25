package checkout;

/**
 * @author Yuriy Tumakha
 */
public class Checkout {

  private PricingRules pricingRules;

  public Checkout(PricingRules pricingRules) {
    this.pricingRules = pricingRules;
  }

  public void scan(String itemCode) {

  }

  public Double getTotal() {
    return 0.0;
  }

}
