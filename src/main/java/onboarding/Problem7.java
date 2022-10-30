package onboarding;

import onboarding.problem7.FriendRecommender;

import java.util.List;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        FriendRecommender friendRecommender = new FriendRecommender();

        return friendRecommender.recommendFriends(user, friends, visitors);
    }
}
