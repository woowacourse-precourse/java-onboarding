package onboarding;

import java.util.*;

public class Problem7 {
    static Map<String, List> map = new HashMap<>();
    static Map <String, Integer> point = new HashMap<>();
    public static void addFriend(String friend1, String friend2) {
        if(map.get(friend1)==null) {
            List <String> list = new ArrayList<>();
            list.add(friend2);
            map.put(friend1, list);
        }
        else {
            List <String> list = map.get(friend1);
            list.add(friend2);
            map.put(friend1, list);
        }
    }

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        for(int i=0; i<friends.size(); i++) {
            String friend1 = friends.get(i).get(0);
            String friend2 = friends.get(i).get(1);
            addFriend(friend1, friend2);
            addFriend(friend2, friend1);
        }
        addFriendPoint(user);
        addVisitorPoint(visitors);
        excludeFriend(user);
        List<Map.Entry<String, Integer>> resultmap = sortByKeyAndValue();
        List <String> answer = convertResultMapToList(resultmap);

        return answer;
    }
}

