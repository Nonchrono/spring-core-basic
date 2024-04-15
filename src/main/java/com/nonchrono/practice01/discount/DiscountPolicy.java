package com.nonchrono.practice01.discount;

import com.nonchrono.practice01.member.Member;

public interface DiscountPolicy {

  /**
   * @return 할인 대상 금액
   * */
  int discount(Member member, int price);
}
