package hello.core.member;


import hello.core.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



class MemberServiceTest {

    MemberService memberService;

    @BeforeEach
    void setup() {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
    }

    @Test
    void join() {

        //given
        Member memberA = new Member(1L, "memberA", Grade.VIP);
        Member memberB = new Member(2L, "memberB", Grade.VIP);

        //when
        memberService.join(memberA);
        memberService.join(memberB);

        Member findMemberA = memberService.findById(1L);
        Member findMemberB = memberService.findById(2L);

        //then
        Assertions.assertThat(memberA).isEqualTo(findMemberA);
        Assertions.assertThat(memberA).isNotEqualTo(findMemberB);

    }

    @Test
    void findMember() {
    }
}