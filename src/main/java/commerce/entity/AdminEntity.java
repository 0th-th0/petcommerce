package commerce.entity;

import commerce.constant.RoleConstant;
import commerce.dto.AdminDto;
import commerce.dto.MemberDto;
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
@Table(name = "admin")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AdminEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(nullable = false, name = "admin_no", length = 10)
  private Integer adminNo;

  @Column(nullable = false, name = "admin_id", length = 10)
  private String adminId;

  @Column(nullable = false, length = 150)
  private String adminPassword;

  @Column(nullable = false, length = 10)
  private String adminName;

  @Enumerated(EnumType.STRING)
  private RoleConstant roleConstant; // 권한

  public static AdminEntity createAdmin(AdminDto adminDto, PasswordEncoder passwordEncoder){
    AdminEntity admin = new AdminEntity();
    admin.setAdminName(adminDto.getAdminName());
    admin.setAdminId(adminDto.getAdminId());
    String adminPassword = passwordEncoder.encode(adminDto.getAdminPassword());
    admin.setAdminPassword(adminPassword);
    admin.setRoleConstant(RoleConstant.ADMIN);
    return admin;
  }

}
