package hello.core.member;

import hello.core.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {

    MemberService memberService;

    @BeforeEach //테스트 전 반드시 실행
    public void beforeEach(){
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
    }

    @Test
    void join(){
        //given ~환경에서
        Member member = new Member(1L, "memberA", Grade.VIP);

        //when  ~했을때
        memberService.join(member);
        Member findMember = memberService.findMember(1L);

        //then  ~결과가 나온다
        Assertions.assertThat(member).isEqualTo(findMember);
        //Assertions : 검증을 API
    }
}
