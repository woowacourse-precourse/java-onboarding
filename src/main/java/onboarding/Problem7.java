package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }
    private static List<String> filterFriendsOfUser(String user, List<List<String>> friends){
        List<String> friendsOfUser = new ArrayList<>();
        friends.forEach(relationTwoUsers -> {
            if(relationTwoUsers.contains(user)){
                friendsOfUser.add(relationTwoUsers.get(friendsIndex(user,relationTwoUsers)));
            }
        });
        return friendsOfUser;
    }
    private static int friendsIndex(String user, List<String> relationTwoUsers) {
        if(user.equals(relationTwoUsers.get(0))){
            return 1;
        }
        return 0;
    }
}
