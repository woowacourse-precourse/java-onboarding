package onboarding;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }

    public static Map<String, Integer> findknowFriendsPoint(List<String> knowFriendsList)
    {
        int point = 0;
        Map<String, Integer> knowFriends = new HashMap();

        for (int i = 0; i < knowFriendsList.size(); i++)
        {
            if (knowFriends.containsKey(knowFriendsList.get(i)))
                point += 10;
            knowFriends.put(knowFriendsList.get(i), point);
        }
        return knowFriends;
    }
}
