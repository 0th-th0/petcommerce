package commerce.repository;

import commerce.entity.ItemEntity;
import java.util.List;
import org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<ItemEntity, Integer> {

  static List<ItemEntity> findByItemName(String itemName) {
    return null;
  }

  static List<ItemEntity> findByItemNo(Integer itemNo) {
    return null;
  }

  static List<ItemEntity> fineAll() {
    return null;
  }

  static ItemEntity findItemByItemNo(Integer itemNo) {
    return null;
  }

  static void deleteByItemNo(Integer itemNo) {
  }


}
