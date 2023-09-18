package commerce.dto;

import commerce.constant.ItemConstant;
import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemDto {

  private Integer itemNo;
  private String itemName;
  private int itemPrice;
  private LocalDateTime itemDate;
  private int itemEa;
  private ItemConstant itemConstant;

}
