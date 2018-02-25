package checkout.discount;

/**
 * @author Yuriy Tumakha
 */
public class BuyQuantityForPrice implements Discount {

  private Integer discountQuantity;
  private Double discountPrice;

  public BuyQuantityForPrice(Integer discountQuantity, Double discountPrice) {
    this.discountQuantity = discountQuantity;
    this.discountPrice = discountPrice;
  }

  @Override
  public Double getItemTotal(Integer quantity, Double price) {
    return quantity / discountQuantity * discountPrice + quantity % discountQuantity * price;
  }

}
