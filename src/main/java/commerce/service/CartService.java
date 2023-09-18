package commerce.service;

import commerce.dto.CartDto;
import commerce.entity.CartEntity;
import commerce.entity.ItemEntity;
import commerce.entity.MemberEntity;
import commerce.repository.CartRepository;
import javax.transaction.Transactional;
import org.springframework.web.bind.annotation.GetMapping;

@Transactional
public class CartService {

  public static void addCart(MemberEntity member, ItemEntity item, int amount) {
    CartEntity cart = CartRepository.findByUserId(member);

    if(cart == null) {
      cart = CartEntity.createCart(member);
      CartRepository.save(cart);
    }

  }
}
