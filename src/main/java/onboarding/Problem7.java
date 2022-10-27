package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {

        Map<String, Set<String>> friendsList = new HashMap<>();

        for (int i = 0; i < friends.size(); i++) {
            makeList(friendsList, friends.get(i).get(0), friends.get(i).get(1));
        }
    }

    static void makeList(Map<String, Set<String>> map, String name1, String name2){
        if (map.containsKey(name1)){
            map.get(name1).add(name2);
        } else {
            map.put(name1, Set.of(name2));
        }
    }
}
