package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{

   // MemberRepository memberRepository = new MemoryMemberRepository();
   //
   // DiscountPolicy discountPolicy = new FixDiscountPolicy();

    private  final MemberRepository memberRepository;

    private  final  DiscountPolicy discountPolicy;

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }


    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {

        // 회원 id -> 회원 등급 조회 -> 할인 정책 적용

        //회원 조회
        Member member = memberRepository.findById(memberId);

        // 회원 정보가지고 등급 조회해서 할인 금액 반환
        int discountPrice = discountPolicy.discount(member, itemPrice);

//        Order order = new Order(memberId, itemName, itemPrice, discountPrice);
//
//        return order;

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
