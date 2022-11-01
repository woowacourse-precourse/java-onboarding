package onboarding;

import onboarding.problem7.FriendRecommender;

import java.util.*;

public class Problem7 {

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        return FriendRecommender.getRecommendFriends(user,friends,visitors);
    }

}
