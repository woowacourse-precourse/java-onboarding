package onboarding;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Comparator.*;

public class Problem7 {
    static Map<String, Integer> points;
    static String userName;
    static List<String> userFriendList;

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        init(user, friends, visitors);
        List<String> answer = new ArrayList<>(points.keySet());

        answer.sort((o1, o2) -> {
            if (points.get(o1) < points.get(o2)) return 1;
            else if (points.get(o1) > points.get(o2)) return -1;
            else {
                if (points.get(o1) == points.get(o2)) {
                    return o1.compareTo(o2);
                }
            }
            return 0;
        });

        List<String> collect = answer.stream().limit(5).collect(Collectors.toList());
        return collect;
    }

    private static void init(String user, List<List<String>> friends, List<String> visitors) {
        points = new HashMap<>();
        userName = user;
        userFriendList = getFriends(userName, friends);
        addPoints(getRecommendFriends(userFriendList, friends));
        addVisitorPoint(visitors);
    }

    private static void addVisitorPoint(List<String> visitors) {
        for (String s : visitors) {
            if (userFriendList.contains(s)) {
                continue;
            }
            if (points.containsKey(s)) {
                points.put(s, points.get(s) + 1);
            } else {
                points.put(s, 1);
            }

        }
    }

    private static void addPoints(List<String> list) {
        for (int i = 0; i < list.size(); i++) {
            if (points.containsKey(list.get(i))) {
                points.put(list.get(i), points.get(list.get(i)) + 10);
            } else points.put(list.get(i), 10);
        }
    }

    private static List<String> getRecommendFriends(List<String> userFriendList, List<List<String>> friends) {
        List<String> list = new ArrayList<>();
        for (String s : userFriendList) {
            List<String> list2 = getFriends(s, friends);
            for (int i = 0; i < list2.size(); i++) {
                if (list2.get(i).equals(userName)) {
                    continue;
                }
                if (!userFriendList.contains(list2.get(i))) {
                    list.add(list2.get(i));
                }
            }

        }
        return list;

    }


    private static List<String> getFriends(String user, List<List<String>> friends) {
        List<String> friendList = new ArrayList<>();
        for (List s : friends) {
            if (s.contains(user)) {
                friendList.add(OnlyFriend(s, user));
            }
        }
        return friendList;
    }

    private static String OnlyFriend(List s, String user) {
        if (s.get(0).equals(user)) {
            return (String) s.get(1);
        }
        return (String) s.get(0);
    }
}
