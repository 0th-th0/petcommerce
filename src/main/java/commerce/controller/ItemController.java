package commerce.controller;

import commerce.entity.ItemEntity;
import commerce.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.cglib.reflect.MethodDelegate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class ItemController {

  private final ItemService itemService;

  @GetMapping("/item/new")
  public String itemSaveForm(){
    return "/seller/itemForm";
  } //상품 등록 페이지(GET)

  @PostMapping("/item/new/post")
  public String itemSave(ItemEntity itemEntity){
    ItemService.saveItem(itemEntity);
    return "/main";
  } //상품 등록(POST)

  @GetMapping("/item/view/{adminId}")
  public String itemView(Model model, @PathVariable("adminId") Integer adminNo){
    model.addAttribute("item", ItemService.itemView(adminNo));
    return "/seller/itemView";
  } //상품 상세 페이지

  @GetMapping("/item/delete/{adminId}")
  public String itemDelete(@PathVariable("adminId") Integer adminNo){
    ItemService.itemDelete(adminNo);
    return "/main";
  } // 상품 삭제

}
