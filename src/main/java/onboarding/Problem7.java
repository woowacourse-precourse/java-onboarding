package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {
    private static Map<String,Integer> recommenedFreinds = new HashMap<>();
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
            if(recommenedFreinds.containsKey(visitor)){
                recommenedFreinds.put(visitor, recommenedFreinds.get(visitor) + 1);
                continue;
            }
            recommenedFreinds.put(visitor, 1);
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
            if(recommenedFreinds.containsKey(id2)){
                recommenedFreinds.remove(id2);
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
            if(recommenedFreinds.containsKey(id2)){
                recommenedFreinds.put(id2,recommenedFreinds.get(id2)+10);
            } else {
                recommenedFreinds.put(id2,10);
            }
        }
    }

    private static void getRecommendedFriends(List<String> answer) {
        removeMyFriendsFromPoints();
        List<Map.Entry<String, Integer>> pointList = sortList();
        int max = pointList.size() < 5 ? pointList.size() : 5;
        for (int i = 0; i < max; i++) {
            answer.add(pointList.get(i).getKey());
        }
    }

    private static void removeMyFriendsFromPoints() {
        for (int j = 0; j < myFriends.size(); j++) {
            recommenedFreinds.remove(myFriends.get(j));
        }
    }

    private static List<Map.Entry<String, Integer>> sortList() {
        return null;
    }
}
