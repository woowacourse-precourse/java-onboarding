package onboarding;

import onboarding.problem7.Sns;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        return recommendFriend(user, friends, visitors);
    }

    private static List<String> recommendFriend(String user, List<List<String>> friends, List<String> visitors) {
        Sns sns = new Sns();
        sns.setFriendShip(friends);
        sns.addVisitLog(user, visitors);
        return sns.recommendMembers(user);
    }
}
