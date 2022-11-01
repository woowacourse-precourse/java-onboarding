package onboarding;

import onboarding.problem7.service.SocialNetworkService;

import java.util.List;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        return SocialNetworkService.recommendFriends(user, friends, visitors);
    }
}
