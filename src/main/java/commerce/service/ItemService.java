package commerce.service;

import commerce.dto.ItemDto;
import commerce.entity.ItemEntity;
import commerce.repository.ItemRepository;
import java.util.List;

public class ItemService {

  public static void saveItem(ItemEntity itemEntity) {
    ItemRepository.save(itemEntity);
  } //DB에 입력한 상품 정보 저장

  public static ItemEntity itemView(Integer itemNo) {
    return ItemRepository.findByItemNo(itemNo).get(0);
  } //findById로 개별 상품 읽어오기

  public static List<ItemEntity> allItemView() {
    return ItemRepository.fineAll();
  } //전체 상품 List 받아오기

  public void itemModify(ItemDto itemDto, Integer itemNo) {
    ItemEntity update = ItemRepository.findItemByItemNo(itemNo);
    update.setItemName(itemDto.getItemName());
    update.setItemPrice(itemDto.getItemPrice());
    update.setItemEa(itemDto.getItemEa());
    ItemRepository.save(update);
  } //상품 수정

  public static void itemDelete(Integer itemNo) {
    ItemRepository.deleteByItemNo(itemNo);
  } //상품 삭제

}
