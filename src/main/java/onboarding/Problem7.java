package onboarding;

import java.security.Key;
import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();
        Map<String, List<String>> friendsList = new HashMap<>();
        Map<String, Integer> points = new HashMap<>();

        user.toLowerCase();

        if(!checkUserName(user) && !checkFriendsList(friends))
            return answer;


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
                List<String> stringList = friendsList.get(findKey);
                for (String temp : stringList) {
                    if (temp.equals(user) || temp.equals(findKey))
                        continue;
                    if (points.containsKey(temp)) {
                        points.merge(temp, 10, Integer::sum);
                    } else {
                        points.put(temp, 10);
                    }
                }
            }
        }
        return points;
    }
    public static boolean checkUserName(String user){
        System.out.println("checkUserName");
        return user.length() > 0  && user.length() < 31;
    }

    public static boolean checkFriendsList(List<List<String>> friends){
        boolean result = false;
        for(List<String> key : friends){
            if(key.size() == 2) {
                for (String temp : key) {
                    if (temp.length() < 31) {
                        result = true;
                        break;
                    }
                }
            }
        }
        System.out.println("checkFriendList");
        return result;
    }

}