package commerce.entity;

import commerce.dto.CartDto;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "cart")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CartEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(nullable = false, name = "cart_no", length = 20)
  private Integer cartNo;

  @Column(nullable = false)
  @DateTimeFormat(pattern = "yyyy-mm-dd")
  private LocalDateTime cartDate;

  @OneToOne(fetch = FetchType.EAGER)
  @JoinColumn(name="user_id")
  MemberEntity userId;

  private int count;

  @OneToMany(mappedBy = "cart")
  private List<CartItemEntity> cartItems = new ArrayList<>();


  public static CartEntity createCart(CartDto cartDto) {
    CartEntity cart = new CartEntity();
    cart.setCount(0);
    cart.setUserId(cartDto.getUserId());
    return cart;
  }


}
