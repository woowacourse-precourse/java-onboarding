package onboarding.prob7.domain;

import java.util.List;

public class RecommendScoreCalculator {

    public int getRecommendScore(String candidatant, List<List<String>> tableOfFriends, List<String> friends, List<String> visitors) {
        int closeScore = getCloseScore(candidatant, tableOfFriends, friends);
        int visitScore = getVisitScore(candidatant, visitors);
        return closeScore+visitScore;
    }
    final int getCloseScore(String candidatant, List<List<String>> tableOfFriends, List<String> friends) {
        int score = 0;
        for (int i = 0; i< friends.size(); i++) {
            for (int j = 0; j < tableOfFriends.size(); j++) {
                String someone1 = tableOfFriends.get(j).get(0);
                String someone2 = tableOfFriends.get(j).get(1);
                if (friends.get(i).equals(someone1) && candidatant.equals(someone2)) score+=10;
                if (friends.get(i).equals(someone2) && candidatant.equals(someone1)) score+=10;
            }
        }
        return score;
    }
    final int getVisitScore(String candidatant, List<String> visitors) {
        int score = 0;
        for (int i = 0; i < visitors.size(); i++) {
            if (visitors.get(i).equals(candidatant)) score++;
        }
        return score;
    }
}
