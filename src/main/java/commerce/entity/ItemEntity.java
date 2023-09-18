package commerce.entity;


import commerce.constant.ItemConstant;
import commerce.constant.RoleConstant;
import commerce.dto.ItemDto;
import commerce.dto.MemberDto;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.crypto.password.PasswordEncoder;

@Entity
@Table(name = "item")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ItemEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(nullable = false, name = "item_no", length = 10)
  private Integer itemNo;

  @Column(nullable = false, length = 20)
  private String itemName;

  @Column(nullable = false, length = 10)
  private int itemPrice;

  @Column(nullable = false)
  private LocalDateTime itemDate;

  @Column(nullable = false, length = 10)
  private int itemEa;

  @Enumerated(EnumType.STRING)
  private ItemConstant itemConstant;

  @ManyToOne
  @JoinColumn(name="admin_id")
  private AdminEntity adminId; // 판매자 아이디

  @OneToMany(mappedBy = "item")
  private List<CartItemEntity> cart_items = new ArrayList<>();

  public static ItemEntity createItem(ItemDto itemDto){
    ItemEntity item = new ItemEntity();
    item.setItemName(itemDto.getItemName());
    item.setItemPrice(itemDto.getItemPrice());
    item.setItemEa(itemDto.getItemEa());
    item.setItemDate(itemDto.getItemDate());
    item.setItemConstant(ItemConstant.SELL);
    return item;

}
