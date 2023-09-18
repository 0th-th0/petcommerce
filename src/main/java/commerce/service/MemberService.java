package commerce.service;

import commerce.dto.MemberDto;
import commerce.entity.ItemEntity;
import commerce.entity.MemberEntity;
import commerce.repository.ItemRepository;
import commerce.repository.MemberRepository;
import javax.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberService implements UserDetailsService {

    private final MemberRepository memberRepository;

  public static MemberEntity member(Integer userNo) {
    return MemberRepository.findByUserNo(userNo).get(0);
  } //findById로 개별 상품 읽어오기
  public MemberEntity saveMember(MemberEntity member){
      validateDuplicateMember(member);
      return memberRepository.save(member);
    }
    private void validateDuplicateMember(MemberEntity member) {
      MemberEntity findMember = memberRepository.findAllByUserPhone(member.getUserPhone());
      if(findMember != null){
        throw new IllegalStateException("이미 가입된 회원입니다.");
      }
  }

  @Override
  public UserDetails loadUserByUsername(String userPhone) throws UsernameNotFoundException {
      MemberEntity member = memberRepository.findAllByUserPhone(userPhone);

      if(member == null){
        throw new UsernameNotFoundException(userPhone);
      }

      return User.builder()
          .username(member.getUserId())
          .password(member.getUserPassword())
          .roles(member.getRoleConstant().toString())
          .build();
    }
}
