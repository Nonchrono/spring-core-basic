package com.nonchrono.practice01.singleton;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.assertj.core.api.Assertions.assertThat;

class StatefulServiceTest {

  @Test
  void statefulServiceSingleton() {
    ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
    StatefulService s1 = ac.getBean(StatefulService.class);
    StatefulService s2 = ac.getBean(StatefulService.class);

    // ThreadA: A 사용자 10000원 주문
    int userAPrice = s1.order("userA", 10000);
    // ThreadB: B 사용자 20000원 주문
    int userBPrice = s2.order("userB", 20000);

    // ThreadA: 사용자 A 주문 금액 조회
//    int price = s1.getPrice();
    System.out.println("price = " + userAPrice);

    assertThat(userAPrice).isNotEqualTo(20000);
  }

  static class TestConfig {

    @Bean
    public StatefulService statefulService() {
      return new StatefulService();
    }
  }
}