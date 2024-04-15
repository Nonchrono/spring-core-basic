package com.nonchrono.practice01;

import com.nonchrono.practice01.discount.FixDiscountPolicy;
import com.nonchrono.practice01.member.*;
import com.nonchrono.practice01.order.Order;
import com.nonchrono.practice01.order.OrderService;
import com.nonchrono.practice01.order.OrderServiceImpl;

public class OrderApp {

  public static void main(String[] args) {

    AppConfig appConfig = new AppConfig();
    MemberService memberService = appConfig.memberService();
    OrderService orderService = appConfig.orderService();

    Long memberId = 1L;
    Member member = new Member(1L, "memberA", Grade.VIP);
    memberService.join(member);

    Order order = orderService.createOrder(memberId, "itemA", 10000);
    System.out.println("order = " + order);
    System.out.println("order.calculatePrice = " + order.calculatePrice());
  }
}
