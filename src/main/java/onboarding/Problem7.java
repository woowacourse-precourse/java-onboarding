package onboarding;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Problem7 {
    public static boolean isUser(String user, List<String> friend) {
        if(user.equals(friend.get(0)) || user.equals(friend.get(1))) {
            return true;
        }
        return false;
    }
    public static String getFriendName(String user, List<String> friend) {
        if(user.equals(friend.get(0))) {
            return friend.get(1);
        }
        else {
            return friend.get(0);
        }
    }
    public static HashSet<String> getFriendSet(String user, List<List<String>> friends){
        HashSet<String> friendSet = new HashSet<>();

        for(List<String> friend: friends) {
            if(isUser(user, friend)) {  // user가 있는 친구 목록일 경우
                String friendName = getFriendName(user, friend);
                friendSet.add(friendName);
            }
        }

        return friendSet;
    }

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        HashSet<String> friendSet;


        friendSet = getFriendSet(user, friends);

        return answer;
    }
}
