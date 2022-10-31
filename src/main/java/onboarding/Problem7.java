package onboarding;

import onboarding.problem7.ScoreCalculator;
import onboarding.problem7.User;
import onboarding.problem7.utils.Slicer;

import java.util.List;


public class Problem7 {
    private static final int RECOMMEND_COUNT = 5;

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        User userInfo = new User(user, friends, visitors);
        List<String> recommendUserList = userInfo.getRecommendUserList();

        if (recommendUserList.size() > RECOMMEND_COUNT) {
            return Slicer.sliceList(recommendUserList, RECOMMEND_COUNT);
        }

        return recommendUserList;
    }
}
