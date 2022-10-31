package onboarding;

import onboarding.problem7.RecommendationAlgorithm;
import onboarding.problem7.User;
import onboarding.problem7.UserRelation;
import onboarding.problem7.UserStore;

import java.util.List;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        User target = new User(user);
        UserStore.add(target);

        UserRelation.addBulk(friends);
        for (List<String> relation : friends) {
            UserStore.add(new User(relation.get(0)));
            UserStore.add(new User(relation.get(1)));
        }

        if(visitors.size() > 10_000) {
            System.out.println("visitors의 길이는 0이상 10_000 이하여야 합니다");
        }
        for(String visitor : visitors) {
            UserStore.add(new User(visitor));
        }

        List<String> usersRecommended = RecommendationAlgorithm.recommend(target.getName(), visitors);
        return usersRecommended;
    }
}
