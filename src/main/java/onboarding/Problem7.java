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
}
