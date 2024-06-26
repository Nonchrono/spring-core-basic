package com.nonchrono.practice01.order;

import com.nonchrono.practice01.AppConfig;
import com.nonchrono.practice01.member.Grade;
import com.nonchrono.practice01.member.Member;
import com.nonchrono.practice01.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {

  MemberService memberService;
  OrderService orderService;

  @BeforeEach
  public void beforeEach() {
    AppConfig appConfig = new AppConfig();
    memberService = appConfig.memberService();
    orderService = appConfig.orderService();
  }

  @Test
  void createOrder() {
    Long memberID = 1L;
    Member member = new Member(memberID, "memberA", Grade.VIP);
    memberService.join(member);

    Order order = orderService.createOrder(memberID, "itemA", 10000);
    Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
  }
}
