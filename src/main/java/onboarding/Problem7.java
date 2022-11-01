package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Problem7 {
    static HashMap<String,Integer> friendScoreMap;
    static List<String> userFriends;
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        friendScoreMap = new HashMap<>();
        userFriends = new ArrayList<>();
        List<String> answer = new ArrayList<>();

        findFriendsByUser(user, friends);
        scoreByFriends(user, friends);

        return answer;
    }

    public static void findFriendsByUser(String user, List<List<String>> friends){
        for(List<String> friend : friends){
            String friendId = friend.get(1);
            if(friendId.equals(user)) {
                userFriends.add(friend.get(0));
            }
        }
    }

    public static void scoreByFriends(String user, List<List<String>> friends){
        for(List<String> friend : friends){
            String friendId = friend.get(1);
            if(friendId.equals(user) || userFriends.contains(friendId) ) {
                continue;
            }
            friendScoreMap.put(friendId,friendScoreMap.getOrDefault(friendId,0)+10);
        }
    }
}