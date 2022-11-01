package onboarding;

import onboarding.problem7.repository.MemberRepository;
import onboarding.problem7.repository.MemberRepositoryImpl;
import onboarding.problem7.service.RecommendService;

import java.util.List;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        MemberRepository memberRepository = MemberRepositoryImpl.of(user);
        RecommendService recommendService = new RecommendService(memberRepository);
        return recommendService.recommendFriends(friends, visitors);
    }
}
