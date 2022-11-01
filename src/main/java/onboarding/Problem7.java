package onboarding;

import java.util.List;

import onboarding.domain.problem7.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        FriendRelations relations = new FriendRelations(friends);
        FriendRecommender recommender = new FriendRecommender(user, relations, visitors);
        return recommender.getTopRecommends();
    }
}
