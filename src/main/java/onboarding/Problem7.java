package onboarding;

import onboarding.problem7.FriendRelation;
import onboarding.problem7.RecommendMap;
import onboarding.problem7.Recommender;
import onboarding.problem7.SnsNetwork;
import onboarding.problem7.UserId;
import onboarding.problem7.VisitorScore;
import onboarding.problem7.Visitors;

import java.util.List;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        UserId target = new UserId(user);
        FriendRelation friendRelation = new FriendRelation(friends);
        Visitors visitor = new Visitors(visitors);

        SnsNetwork snsNetwork = new SnsNetwork(friendRelation);

        RecommendMap friendScoreDto = snsNetwork.getRecommend(target);
        RecommendMap visitorScoreDto = new VisitorScore(visitor).sum(friendScoreDto);

        return new Recommender(visitorScoreDto, snsNetwork).getFive(target);
    }
}
