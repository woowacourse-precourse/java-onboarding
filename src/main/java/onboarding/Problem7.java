package onboarding;


import onboarding.problem7.Recommendation;

import java.util.List;



public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        
        Recommendation recommendation = new Recommendation();
        return recommendation.getBestRecommendList(user, friends, visitors);
    }
}
