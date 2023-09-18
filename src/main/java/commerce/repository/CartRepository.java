package commerce.repository;

import commerce.entity.CartEntity;
import commerce.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<CartEntity, Integer> {

  static CartEntity findByUserId(MemberEntity member) {
    return null;
  }
}
