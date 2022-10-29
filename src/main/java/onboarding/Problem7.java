package onboarding;

import entity.UserRelation;
import entity.UserScore;

import java.util.List;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        UserRelation relation = new UserRelation(user, friends, visitors);
        UserScore userScore = new UserScore();
        userScore.addFriendsScore(user, relation.getFriendsRelations());
        userScore.addVisitorsScore(visitors, relation.getUserFriends());
        userScore.getUserScoreTop5();
        return userScore.getUserScoreTop5();
    }
}