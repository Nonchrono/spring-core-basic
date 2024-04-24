package com.nonchrono.practice01;

import com.nonchrono.practice01.discount.DiscountPolicy;
import com.nonchrono.practice01.discount.FixDiscountPolicy;
import com.nonchrono.practice01.discount.RateDiscountPolicy;
import com.nonchrono.practice01.member.MemberRepository;
import com.nonchrono.practice01.member.MemberService;
import com.nonchrono.practice01.member.MemberServiceImpl;
import com.nonchrono.practice01.member.MemoryMemberRepository;
import com.nonchrono.practice01.order.OrderService;
import com.nonchrono.practice01.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

  @Bean
  public MemberService memberService() {
    return new MemberServiceImpl(memberRepository());
  }

  @Bean
  public static MemberRepository memberRepository() {
    return new MemoryMemberRepository();
  }

  @Bean
  public OrderService orderService() {
    return new OrderServiceImpl(memberRepository(), discountPolicy());
  }

  @Bean
  private static DiscountPolicy discountPolicy() {
//    return new FixDiscountPolicy();
    return new RateDiscountPolicy();
  }
}
