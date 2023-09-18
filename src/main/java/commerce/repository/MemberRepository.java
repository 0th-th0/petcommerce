package commerce.repository;

import commerce.entity.MemberEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<MemberEntity, Integer> {

  static List<MemberEntity> findByUserNo(Integer userNo) {
    return null;
  }

  MemberEntity findAllByUserPhone(String userPhone);
}
