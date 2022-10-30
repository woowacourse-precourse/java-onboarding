package onboarding;

import onboarding.problem7.User;
import onboarding.problem7.Users;

import java.util.ArrayList;
import java.util.List;

public class Problem7 {
    private static Users users;
    private static List<String> userFriends;
    private static boolean isFriendsExist;

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        init();
        createUserInFriends(friends, user);
        createUserInVisitors(visitors);
        return users.getRecommendFriends(userFriends);
    }

    private static void init() {
        users = new Users();
        userFriends = new ArrayList<>();
        isFriendsExist = false;
    }

    private static void createUserInFriends(List<List<String>> friends, String user) {
        for (List<String> friendship : friends) {
            if (!friendship.contains(user)) {
                friendship.forEach(friend -> {
                    User findUser = users.findUserByName(friend);
                    findUser.addFriendScore();
                });
                continue;
            }
            addUserFriends(friendship, user);
        }
        checkUserFriends();
    }

    private static void addUserFriends(List<String> friendship, String user) {
        isFriendsExist = true;
        if (friendship.indexOf(user) == 1) {
            userFriends.add(friendship.get(0));
        } else if (friendship.indexOf(user) == 0) {
            userFriends.add(friendship.get(1));
        }
    }

    private static void createUserInVisitors(List<String> visitors) {
        for (String visitor : visitors) {
            User findUser = users.findUserByName(visitor);
            findUser.addVisitsScore();
        }
    }

    private static void checkUserFriends() {
        if (!isFriendsExist) {
            users = new Users();
        }
    }
}
