package onboarding;

import onboarding.problem7.FriendRecommender;

import java.util.Collections;
import java.util.List;

/**
 * Problem 7 function list
 * - Create relations from friends list
 * - Create score list of each friend candidates
 * --> if candidate is a friend of user's friend add 10 point
 * --> if candidate visited user's SNS add 1 point
 * - Sort candidate list (Descending order of score -> Ascending order of name)
 * - Check maximum 5 new friends
 */
public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        FriendRecommender recommender = new FriendRecommender(user, friends, visitors);
        return recommender.recommend();
    }
}
