package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();
        List<String> friendList = new ArrayList<>();
        TreeMap<String, Integer> recommendedFriends = new TreeMap<>();

        createFriendList(user, friends, friendList);
        checkFriendOfFriend(user, friends, friendList, recommendedFriends);

        return answer;
    }

    private static void createFriendList(String user, List<List<String>> friends, List<String> friendList) {
        for (List<String> friend : friends)
            if (friend.contains(user))
                for (String name : friend)
                    if (!name.equals(user))
                        friendList.add(name);
    }

    private static void checkFriendOfFriend(String user, List<List<String>> friends, List<String> friendList, Map<String, Integer> recommendedFriends) {
        for (List<String> friend : friends)
            if(friendList.contains(friend.get(0)) || friendList.contains(friend.get(1)))
                for (String name : friend)
                    if (!friendList.contains(name) && !name.equals(user))
                        if (recommendedFriends.containsKey(name))
                            recommendedFriends.put(name, recommendedFriends.get(name) + 10);
                        else
                            recommendedFriends.put(name, 10);
    }

}
