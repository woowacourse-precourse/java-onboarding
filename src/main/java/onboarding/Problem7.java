package onboarding;

import onboarding.problem7.FriendRecommender;

import java.util.Collections;
import java.util.List;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {

        return new FriendRecommender(user, friends, visitors).recommendFriends();
    }
}
