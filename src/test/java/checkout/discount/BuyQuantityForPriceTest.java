package checkout.discount;

import static checkout.TestData.DELTA;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * @author Yuriy Tumakha
 */
public class BuyQuantityForPriceTest {

  private static final int DISCOUNT_QUANTITY = 3;
  private static final double DISCOUNT_PRICE = 1.30;
  private static final double PRICE = 0.50;
  private final BuyQuantityForPrice discount = new BuyQuantityForPrice(DISCOUNT_QUANTITY, DISCOUNT_PRICE);

  @Test
  public void testDiscountOnce() {
    checkItemTotal(DISCOUNT_QUANTITY, DISCOUNT_PRICE);
  }

  @Test
  public void testDiscountTwice() {
    checkItemTotal(DISCOUNT_QUANTITY * 2 + 1, DISCOUNT_PRICE * 2 + PRICE);
  }

  @Test
  public void testNoDiscount() {
    int quantity = DISCOUNT_QUANTITY - 1;
    checkItemTotal(quantity, PRICE * quantity);
  }

  @Test
  public void testNoItems() {
    checkItemTotal(0, 0.0);
  }

  private void checkItemTotal(Integer quantity, Double expectedTotal) {
    assertEquals("Wrong item total",
        expectedTotal, discount.getItemTotal(quantity, PRICE),  DELTA);
  }

}
