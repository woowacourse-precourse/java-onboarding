package onboarding;

import java.util.List;

import onboarding.domain.problem7.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        FriendRelations relations = new FriendRelations(friends);
        MutualDictionaryGenerator mGenerator = new MutualDictionaryGenerator(relations, user);
        VisitsDictionaryGenerator vGenerator = new VisitsDictionaryGenerator(relations, user, visitors);
        FriendRecommender recommender = new FriendRecommender(new MutualDictionary(mGenerator), new VisitsDictionary(vGenerator));
        return recommender.getTopRecommends();
    }
}
