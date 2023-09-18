package commerce.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class CartItemEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer cartItemId;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "cart_no")
  private CartEntity cartNo;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "item_no")
  private ItemEntity itemNo;

  private int cartCount; // 상품 개수

  public static CartItemEntity createCartItem(CartEntity cartNo, ItemEntity itemNo, int amount) {
    CartItemEntity cartItem = new CartItemEntity();
    cartItem.setCartNo(cartNo);
    cartItem.setItemNo(itemNo);
    cartItem.setCartCount(amount);
    return cartItem;
  }

  public void addCount(int count) {
    this.cartCount += count;
  }

}
