package onboarding;

import java.util.List;

import onboarding.domain.problem7.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        FriendRelations relations = new FriendRelations(friends);
        MutualDictionary mutualDictionary = new MutualDictionary(relations, user);
        VisitsDictionary visitsDictionary = new VisitsDictionary(relations, user, visitors);
        FriendRecommender recommender = new FriendRecommender(mutualDictionary, visitsDictionary);
        return recommender.getTopRecommends();
    }
}
