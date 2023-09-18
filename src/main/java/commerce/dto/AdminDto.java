package commerce.dto;

import commerce.constant.RoleConstant;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AdminDto {

  private Integer adminNo;
  private String adminId;
  private String adminPassword;
  private String adminName;
  private RoleConstant roleConstant;

}
