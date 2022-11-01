package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem7 {
    public static List<String>  solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.singletonList("aa");
        List<String> userFriendList = getUserFriendList(user, friends);

        return answer;
    }
    public static List<String> getUserFriendList(String user, List<List<String>> friends){
        List<String> userFriendList = new ArrayList<>();
        for (List<String> friend : friends){
            if (friend.indexOf(user) == 1){
                userFriendList.add(friend.get(0));
            }
            if (friend.indexOf(user) == 0){
                userFriendList.add(friend.get(1));
            }
        }
        return userFriendList;
    }
}
