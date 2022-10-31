package onboarding;

import onboarding.problem7.FriendRelation;
import onboarding.problem7.SNSFriendRecommender;

import java.util.List;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        FriendRelation relation = new FriendRelation(friends);
        return new SNSFriendRecommender(user, visitors, relation).recommendFriends();
    }
}
