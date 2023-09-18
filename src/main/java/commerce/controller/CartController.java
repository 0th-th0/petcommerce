package commerce.controller;

import commerce.constant.RoleConstant;
import commerce.dto.MemberDto;
import commerce.entity.CartItemEntity;
import commerce.entity.ItemEntity;
import commerce.entity.MemberEntity;
import commerce.service.CartService;
import commerce.service.ItemService;
import commerce.service.MemberService;
import java.util.Objects;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class CartController {

  @PostMapping("/user/cart/{userNo}/{itemNo}")
  public String addCartItem(@PathVariable("userNo") Integer userNo,
      @PathVariable("itemNo") Integer itemNo, int amount) {
    MemberEntity member = MemberService.member(userNo);
    ItemEntity item = ItemService.itemView(itemNo);
    CartService.addCart(member, item, amount);

    return "redirect:/item/view/{itemNo}";
  } // 장바구니에 상품 추가

  @GetMapping("/user/cart/{userNo}/{cartItemId}/delete")
  public String deleteCartItem(@PathVariable("userNo") String userId,
      @PathVariable("cartItemId") Integer cartItemId, MemberEntity member) {
    if(Objects.equals(member.getUserId(), userId)){

    }
  } // 장바구니 상품 삭제
}
