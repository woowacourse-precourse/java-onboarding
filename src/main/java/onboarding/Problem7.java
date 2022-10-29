package onboarding;

import onboarding.problem7.Users;

import java.util.ArrayList;
import java.util.List;

public class Problem7 {
    private static Users users;
    private static List<String> userFriend;
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        users = new Users();
        userFriend = new ArrayList<>();
        setUserFriend(friends, user);
        return users.getRecommendFriendsRankingFive();
    }

    private static void setUserFriend(List<List<String>> friends, String user) {
        for(List<String> friend : friends) {
            String friend1 = friend.get(0);
            String friend2 = friend.get(1);

            if(friend1.equals(user)) {
                userFriend.add(friend2);
            }
            else if(friend2.equals(user)) {
                userFriend.add(friend1);
            }
        }
    }
}
