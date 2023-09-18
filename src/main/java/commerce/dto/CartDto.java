package commerce.dto;

import commerce.entity.CartItemEntity;
import commerce.entity.MemberEntity;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class CartDto {

  private long cartNo;
  private LocalDateTime cartDate;
  private MemberEntity userId; // 구매자
  private int count;
  private List<CartItemEntity> cartItems = new ArrayList<>();

}
