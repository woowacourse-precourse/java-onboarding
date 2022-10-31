package onboarding;

import java.security.KeyStore;
import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        Map<String, Integer> userInfo = new HashMap<>();
        Set<String> myFriends = new HashSet<>();


        for (List<String> friend : friends) {
            userInfo.put(friend.get(0), 0);
            userInfo.put(friend.get(1), 0);
        }
        for (List<String> strings : friends) {
            if (strings.contains(user)) {
                myFriends.addAll(strings);
            }
        }
        List<String> myFriend = new ArrayList<>(myFriends);


        for (String visitor : visitors) {
            if (userInfo.containsKey(visitor)) {
                userInfo.put(visitor, userInfo.get(visitor) + 1);
            } else {
                userInfo.put(visitor, 1);
            }
        }
        for (int i = 0; i < friends.size(); i++) {
            for (int j = 0; j < 2; j++) {
                if (friends.get(i).contains(myFriend.get(0))) {
                    userInfo.put(friends.get(i).get(1), userInfo.get(friends.get(i).get(1)) + 10);

                }
                if (friends.get(i).contains(myFriend.get(1))) {
                    userInfo.put(friends.get(i).get(0), userInfo.get(friends.get(i).get(0)) + 10);
                }
            }
        }

        userInfo.remove(user);
        for (String friend : myFriend) {
            userInfo.remove(friend);
        }
        List<String> keySetList = new ArrayList<>(userInfo.keySet());

        keySetList.sort(((o1, o2) -> userInfo.get(o2).compareTo(userInfo.get(o1))));
        System.out.println(keySetList);
        return keySetList;
    }

}

