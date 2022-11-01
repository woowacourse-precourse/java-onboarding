package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Problem7 {
    public static HashMap<String, Integer> createSharedFriendsHashmap(List<List<String>> friends, List<String> userFriends, String user) {
        HashMap<String, Integer> sharedFriends = new HashMap<String, Integer>();
        for(String userFriend : userFriends) {
            for(List<String> friend : friends) {
                if(friend.get(0) == user || friend.get(1) == user) {
                    continue;
                } else{
                    String key = null;
                    if(friend.get(0) == userFriend){
                        key = friend.get(1);
                        if(sharedFriends.containsKey(key)) {
                            sharedFriends.replace(key, sharedFriends.get(key), sharedFriends.get(key) + 10);
                        } else {
                            sharedFriends.put(key, 10);
                        }
                    } else if(friend.get(1) == userFriend) {
                        key = friend.get(0);
                        if(sharedFriends.containsKey(key)) {
                            sharedFriends.replace(key, sharedFriends.get(key), sharedFriends.get(key) + 10);
                        } else {
                            sharedFriends.put(key, 10);
                        }
                    }
                }
            }
        }
        System.out.println(sharedFriends);
        return sharedFriends;
    }
    public static List<String> findUserFriends(String user, List<List<String>> friends) {
        List<String> userFriend = new ArrayList<>();
        for(List<String> friend :  friends) {
            if(friend.get(0) == user) {
                userFriend.add(friend.get(1));
            } else if(friend.get(1) == user) {
                userFriend.add(friend.get(0));
            }
        }
        return userFriend;
    }
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        List<String> userFriends = findUserFriends(user, friends);
        createSharedFriendsHashmap(friends, userFriends, user);
        System.out.println(userFriends);
        return answer;
    }

    public static void main(String[] args) {
        String user = "mrko";
        List<List<String>> friends = List.of(
                List.of("donut", "andole"),
                List.of("donut", "jun"),
                List.of("donut", "mrko"),
                List.of("shakevan", "andole"),
                List.of("shakevan", "jun"),
                List.of("shakevan", "mrko")
        );
        List<String> visitors = List.of("bedi", "bedi", "donut", "bedi", "shakevan");
        solution(user, friends, visitors);
    }
}
