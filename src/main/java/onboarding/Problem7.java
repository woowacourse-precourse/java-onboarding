package onboarding;

import java.util.List;
import onboarding.problem7.Finder;
import onboarding.problem7.FriendPointCalculator;
import onboarding.problem7.FriendsFinder;
import onboarding.problem7.FriendsRecommendator;
import onboarding.problem7.PointCalculator;
import onboarding.problem7.Recommendator;

public class Problem7 {

    public static final int FRIEND_OF_FRIEND_POINT = 10;
    public static final int VISITED_FRIEND_POINT = 1;
    public static final int RECOMMENDATION_FRIENDS_LIMIT = 5;

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        Finder finder = new FriendsFinder();
        PointCalculator calculator = new FriendPointCalculator();
        Recommendator recommendator = new FriendsRecommendator(calculator);

        return recommendator.recommend(finder.findNewFriendsFromUserFriends(user, friends),
            finder.findNewFriendsFromVisitRecord(user, friends, visitors),
            FRIEND_OF_FRIEND_POINT, VISITED_FRIEND_POINT, RECOMMENDATION_FRIENDS_LIMIT);
    }
}
