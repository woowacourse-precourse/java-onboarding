package onboarding;

import onboarding.problem7.FriendListScoreCalculation;
import onboarding.problem7.TopFiveCompare;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();

        FriendListScoreCalculation friendListScoreCalculation = new FriendListScoreCalculation();
        HashMap<String, Integer> scores = friendListScoreCalculation.scoreCalculations(user, friends, visitors);

        TopFiveCompare topFiveCompare = new TopFiveCompare();
        answer = topFiveCompare.sortOrder(scores);

        return answer;
    }
}
