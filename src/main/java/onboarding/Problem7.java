package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {
    private static Map<String,Integer> points = new HashMap<>();
    private static List<String> myFriends = new LinkedList<>();
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new LinkedList<>();
        calcVisitorsPoints(visitors);
        calcMyFriends(user, friends);
        calcFriendsPoints(user, friends, myFriends);
        getRecommendedFriends(answer);
        return answer;
    }


    private static void calcVisitorsPoints(List<String> visitors) {
        for (String visitor : visitors) {
            if(points.containsKey(visitor)){
                points.put(visitor, points.get(visitor) + 1);
                continue;
            }
            points.put(visitor, 1);
        }
    }

    private static void calcMyFriends(String user, List<List<String>> friends) {
        for (int i = 0; i < friends.size(); i++) {
            List<String> friend =  friends.get(i);
            addMyFriends(user, friend.get(0),friend.get(1));
            addMyFriends(user, friend.get(1),friend.get(0));
        }
    }

    private static void addMyFriends(String user, String id1, String id2) {
        if(id1.equals(user)){
            myFriends.add(id2);
            if(points.containsKey(id2)){
                points.remove(id2);
            }
        }
    }

    private static void calcFriendsPoints(String user, List<List<String>> friends, List<String> myFriends) {
        for (int i = 0; i < friends.size(); i++) {
            List<String> friend =  friends.get(i);
            if(friend.contains(user)){
                continue;
            }
            setPoints(myFriends, friend.get(0),friend.get(1));
            setPoints(myFriends, friend.get(1),friend.get(0));
        }
    }

    private static void setPoints(List<String> myFriends, String id1, String id2) {
        if(myFriends.contains(id1)){
            if(points.containsKey(id2)){
                points.put(id2,points.get(id2)+10);
            } else {
                points.put(id2,10);
            }
        }
    }

    private static void getRecommendedFriends(List<String> answer) {
        removeMyFriendsFromPoints();
        List<Map.Entry<String, Integer>> pointList = sortList();
        for (Map.Entry<String, Integer> entry : pointList) {
            answer.add(entry.getKey());
        }
    }

    private static void removeMyFriendsFromPoints() {
        for (int j = 0; j < myFriends.size(); j++) {
            points.remove(myFriends.get(j));
        }
    }

    private static List<Map.Entry<String, Integer>> sortList() {
        List<Map.Entry<String, Integer>> pointList = getPointsList();
        Collections.sort(pointList,new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                if (o2.getValue() - o1.getValue() == 0) {
                    return o1.getKey().compareTo(o2.getKey());
                }
                return o2.getValue() - o1.getValue();
            }
        });
        return pointList;
    }

    private static List<Map.Entry<String, Integer>> getPointsList() {
        return points.entrySet().stream().collect(Collectors.toList());
    }
}
