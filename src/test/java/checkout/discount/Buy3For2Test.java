package checkout.discount;

import static checkout.TestData.DELTA;
import static checkout.discount.Buy3For2.BUY_3_FOR_2_DISCOUNT;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * @author Yuriy Tumakha
 */
public class Buy3For2Test {
  private static final int DISCOUNT_QUANTITY = 3;
  private static final Integer PRICE_QUANTITY = 2;
  private static final double PRICE = 0.50;
  private static final double DISCOUNT_PRICE = PRICE * PRICE_QUANTITY;
  private final Buy3For2 discount = BUY_3_FOR_2_DISCOUNT;

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
