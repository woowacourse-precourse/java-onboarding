package onboarding;

import java.security.Key;
import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();
        Map<String, List<String>> friendsList = new HashMap<>();
        Map<String, Integer> points = new HashMap<>();

        friendsList = addFriendsList(friends);
        points = cal_visitor_Points(friendsList, visitors, user);
        points = cal_friends_Points(points, friendsList, user);

        List<Map.Entry<String, Integer>> list_entries = new ArrayList<Map.Entry<String, Integer>>(points.entrySet());

        Collections.sort(list_entries, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        });

        for(String name : points.keySet()){
            answer.add(name);
        }
        return answer;
    }

    public static Map<String, List<String>> addFriendsList(List<List<String>> friends) {

        Map<String, List<String>> friendsList = new HashMap<>();
        for (List<String> friend : friends) {
            if (!friendsList.containsKey(friend.get(0))) {
                List<String> newfriends = new ArrayList<>();
                newfriends.add(friend.get(1));
                friendsList.put(friend.get(0), newfriends);
            } else {
                friendsList.get(friend.get(0)).add(friend.get(1));
            }

            if (!friendsList.containsKey(friend.get(1))) {
                List<String> newfriends = new ArrayList<>();
                newfriends.add(friend.get(0));
                friendsList.put(friend.get(1), newfriends);
            } else {
                friendsList.get(friend.get(1)).add(friend.get(0));
            }
        }
        return friendsList;
    }

    public static Map<String, Integer> cal_visitor_Points(Map<String, List<String>> friendsList, List<String> visitors, String user) {
        Map<String, Integer> points = new HashMap<>();
        for (String visitor : visitors) {
            List<String> newfriends = new ArrayList<>();
            if(!friendsList.containsKey(visitor))
                friendsList.put(visitor, newfriends);

            if(friendsList.get(visitor).contains(user))
                continue;

            if (!points.containsKey(visitor)) {
                points.put(visitor, 1);
            } else {
                points.merge(visitor, 1, Integer::sum);
            }
        }
        return points;
    }

    public static Map<String, Integer> cal_friends_Points(Map<String, Integer> points, Map<String, List<String>> friendsList, String user) {
        String findKey = "";

        for (String key : friendsList.keySet()) {
            if (friendsList.get(key).contains(user)) {
                findKey = key;
                List<String> asdf = friendsList.get(findKey);
                for (String qqq : asdf) {
                    if (qqq.equals(user) || qqq.equals(findKey))
                        continue;
                    if (points.containsKey(qqq)) {
                        points.merge(qqq, 10, Integer::sum);
                    } else {
                        points.put(qqq, 10);
                    }
                }
            }
        }
        return points;
    }

}