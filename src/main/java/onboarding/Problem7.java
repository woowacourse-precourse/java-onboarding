package onboarding;

import java.util.List;

import onboarding.domain.FriendRecommender;
import onboarding.domain.FriendRelations;
import onboarding.domain.MutualDictionary;
import onboarding.domain.MutualDictionaryGenerator;
import onboarding.domain.VisitsDictionary;
import onboarding.domain.VisitsDictionaryGenerator;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        FriendRelations relations = new FriendRelations(friends);
        MutualDictionaryGenerator mgen = new MutualDictionaryGenerator(relations, user);
        VisitsDictionaryGenerator vgen = new VisitsDictionaryGenerator(relations, user, visitors);
        FriendRecommender rc = new FriendRecommender(new MutualDictionary(mgen), new VisitsDictionary(vgen));
        return rc.getRecommendList();
    }
}
