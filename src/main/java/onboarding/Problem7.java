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

        createFriendList(user, friends, friendList);

        return answer;
    }

    private static void createFriendList(String user, List<List<String>> friends, List<String> friendList) {
        for (List<String> friend : friends)
            if (friend.contains(user))
                for (String name : friend)
                    if (!name.equals(user))
                        friendList.add(name);
    }
}
