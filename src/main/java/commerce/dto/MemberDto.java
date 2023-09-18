package commerce.dto;

import commerce.constant.RoleConstant;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberDto {

  private Integer userNo;
  private String userName;
  private String userId;
  private String userPassword;
  private String userBirth;
  private String userPhone;
  private String userAddress;
  private LocalDateTime userDate;
  private RoleConstant roleConstant;

}
