package onboarding;

import onboarding.problem7.Recommendation;
import onboarding.problem7.User;
import onboarding.problem7.Users;

import java.util.List;

public class Problem7 {
    public static List<String> solution(String username, List<List<String>> friends, List<String> visitors) {
        validateFriendsSize(friends);
        validateVisitorsSize(visitors);

        Users users = new Users(friends);
        User user = users.findByUsername(username);

        Recommendation recommendation = new Recommendation(users);
        return recommendation.recommend(user.getVisitStatistics(visitors), user.getFriendsOfMyFriends(friends), user.getMyFriends(friends));
    }

    private static void validateFriendsSize(List<List<String>> friends) {
        if (!isValideFriendsSize(friends)) {
            throw new IllegalArgumentException("friends의 길이는 0이상 10000이하의 배열이어야합니다.");
        }
    }

    private static boolean isValideFriendsSize(List<List<String>> friends) {
        return friends.size() > 0 && friends.size() < 10000;
    }

    private static void validateVisitorsSize(List<String> visitors) {
        if (!isValideVisitorsSize(visitors)) {
            throw new IllegalArgumentException("타임라인 방문 기록은 0이상 10000이하 입니다.");
        }
    }

    private static boolean isValideVisitorsSize(List<String> visitors) {
        return visitors.size() > 0 && visitors.size() < 10000;
    }
}
