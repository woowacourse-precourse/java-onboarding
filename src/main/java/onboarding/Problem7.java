package onboarding;

import java.util.*;
import onboarding.problem7.FriendRecommender;


public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        FriendRecommender recommender = new FriendRecommender(friends);
        return recommender.recommendUser(user, visitors);
    }
}

