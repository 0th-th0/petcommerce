package commerce.controller;

import commerce.constant.RoleConstant;
import commerce.entity.AdminEntity;
import commerce.entity.ItemEntity;
import commerce.entity.MemberEntity;
import commerce.service.ItemService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class MainController {

  @GetMapping(value = "/")
  public String mainPageNoneLogin(Model model) {
    List<ItemEntity> items = ItemService.allItemView();
    model.addAttribute("items", items);
    return "main";
  } // 로그인을 안 한 경우

  @GetMapping("/main")
  public String mainPageLogin(Model model, AdminEntity admin, MemberEntity member){
    if(admin.getRoleConstant().equals(RoleConstant.ADMIN)){
      List<ItemEntity> items = ItemService.allItemView();
      model.addAttribute("items", items);
      model.addAttribute("user", admin.getAdminId());
      return "/seller/mainSeller"; // 관리자일 경우
    } else {
      List<ItemEntity> items = ItemService.allItemView();
      model.addAttribute("items", items);
      model.addAttribute("user", member.getUserId());
      return "user/mainUser"; // 일반 회원일 경우
    }
  }
}
