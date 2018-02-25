package checkout.discount;

/**
 * @author Yuriy Tumakha
 */
public interface Discount {

  Double getItemTotal(Integer quantity, Double price);

}
