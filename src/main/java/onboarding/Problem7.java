package onboarding;

import onboarding.problem7.User;
import onboarding.problem7.Users;

import java.util.ArrayList;
import java.util.List;

public class Problem7 {
    private static Users users;
    private static List<String> userFriends;

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        init();
        createUserInFriends(friends, user);
        checkVisitors(visitors);
        return users.getRecommendFriendsRankingFive(userFriends);
    }

    private static void init() {
        users = new Users();
        userFriends = new ArrayList<>();
    }

    private static void createUserInFriends(List<List<String>> friends, String user) {
        for(List<String> friendship : friends) {
            for(String friend : friendship) {
                if(!friend.equals(user)) {
                    User findUser = users.findUser(friend);
                    findUser.addFriendScore();
                    continue;
                }
                addUserFriends(friendship, user);
            }
        }
    }

    private static void addUserFriends(List<String> friendship, String user) {
        if(friendship.indexOf(user) == 1) {
            userFriends.add(friendship.get(0));
        }
        else if(friendship.indexOf(user) == 0) {
            userFriends.add(friendship.get(1));
        }
    }

    private static void checkVisitors(List<String> visitors) {
        for(String visitor : visitors) {
            User findUser = users.findUser(visitor);
            findUser.addVisitsScore();
        }
    }
}
