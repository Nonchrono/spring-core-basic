package com.nonchrono.practice01.member;

public interface MemberRepository {

  void save(Member member);
  Member findById(Long memberID);
}
