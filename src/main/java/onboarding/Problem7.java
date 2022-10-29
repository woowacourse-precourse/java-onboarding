package onboarding;

import onboarding.problem7.User;
import onboarding.problem7.Users;

import java.util.List;

public class Problem7 {
    private static Users users;

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        init();
        createUserInFriends(friends, user);
        checkVisitors(visitors);
        return users.getRecommendFriendsRankingFive();
    }

    private static void init() {
        users = new Users();
    }

    private static void createUserInFriends(List<List<String>> friends, String user) {
        for(List<String> friendship : friends) {
            for(String friend : friendship) {
                if(!friend.equals(user)) {
                    User findUser = users.findUser(friend);
                    findUser.addFriendScore();
                }
            }
        }
    }

    private static void checkVisitors(List<String> visitors) {
        for(String visitor : visitors) {
            User findUser = users.findUser(visitor);
            findUser.addVisitsScore();
        }
    }
}
