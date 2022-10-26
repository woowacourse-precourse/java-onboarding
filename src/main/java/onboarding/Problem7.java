package onboarding;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem7 {
    static int frendPoint = 10;
    static int visitPoint = 1;
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }

    public static Map<String, Integer> findknowFriendsPoint(List<String> knowFriendsList)
    {
        int point = frendPoint;
        String key;

        Map<String, Integer> knowFriendsMap = new HashMap();

        for (int i = 0; i < knowFriendsList.size(); i++)
        {
            key = knowFriendsList.get(i);
            if (knowFriendsMap.containsKey(key))
                point = knowFriendsMap.get(key) + frendPoint;
            knowFriendsMap.put(knowFriendsList.get(i), point);
            point = frendPoint;
        }
        return knowFriendsMap;
    }

    public static void findVisitedPoint(Map<String, Integer> knowFriendsMap, List<String> visitors)
    {
        int point = visitPoint;

        for (int i = 0; i < visitors.size(); i++)
        {
            String key = visitors.get(i);
            if (knowFriendsMap.containsKey(key))
            {
                point = knowFriendsMap.get(key) + visitPoint;
                knowFriendsMap.put(visitors.get(i), point);
            }
        }
    }
}
