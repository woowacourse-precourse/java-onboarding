package onboarding;

import onboarding.problem7.repository.FriendRepository;
import onboarding.problem7.service.RecommendService;

import java.util.List;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        FriendRepository friendRepository = FriendRepository.of(user);
        RecommendService recommendService = new RecommendService(friendRepository);
        return recommendService.recommendFriends(friends, visitors);
    }
}
