package commerce.entity;

import commerce.constant.RoleConstant;
import commerce.dto.MemberDto;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.crypto.password.PasswordEncoder;

@Entity
@Table(name = "member")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MemberEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(nullable = false, name = "member_no", length = 10)
  private Integer userNo;

  @Column(nullable = false, length = 10)
  private String userName;

  @Column(nullable = false, length = 20)
  private String userId;

  @Column(nullable = false, length = 150)
  private String userPassword;

  @Column(nullable = false, length = 8)
  private String userBirth;

  @Column(unique = true, nullable = false, length = 11)
  private String userPhone; // userPhone 중복 안 됨

  @Column(nullable = false, length = 100)
  private String userAddress;

  @Column(nullable = false)
  private LocalDateTime userDate;

  @Enumerated(EnumType.STRING)
  private RoleConstant roleConstant; // 권한


  public static MemberEntity createMember(MemberDto memberDto, PasswordEncoder passwordEncoder){
    MemberEntity member = new MemberEntity();
    member.setUserName(memberDto.getUserName());
    member.setUserId(memberDto.getUserId());
    String password = passwordEncoder.encode(memberDto.getUserPassword());
    member.setUserPassword(password);
    member.setUserBirth(memberDto.getUserBirth());
    member.setUserPhone(memberDto.getUserPhone());
    member.setUserAddress(memberDto.getUserAddress());
    member.setUserDate(memberDto.getUserDate());
    member.setRoleConstant(RoleConstant.USER);
    return member;
  }

}
