package checkout.discount;

/**
 * @author Yuriy Tumakha
 */
public enum Buy3For2 implements Discount {

  BUY_3_FOR_2_DISCOUNT;

  private static final Integer DISCOUNT_QUANTITY = 3;
  private static final Integer PRICE_QUANTITY = 2;

  @Override
  public Double getItemTotal(Integer quantity, Double price) {
    return quantity / DISCOUNT_QUANTITY * price * PRICE_QUANTITY
        + quantity % DISCOUNT_QUANTITY * price;
  }

}
