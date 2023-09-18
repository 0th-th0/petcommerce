package commerce.controller;


import commerce.dto.MemberDto;
import commerce.entity.MemberEntity;
import commerce.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@Controller
@RequestMapping("/members")
public class MemberController {

  private final MemberService memberService;
  private final PasswordEncoder passwordEncoder;

  @GetMapping(value = "/new")
  public String RoleConstant(Model model){
    model.addAttribute("memberDto",new MemberDto());
    return "member/memberDto";
  }

  @PostMapping(value = "/new")
  public String RoleConstant(MemberDto memberDto){
    MemberEntity member = MemberEntity.createMember(memberDto, passwordEncoder);
    memberService.saveMember(member);
    return "redirect:/";
  }
}
