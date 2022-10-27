package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {

        final int COUNT = 5;
        Map<String, Set<String>> friendsList = new HashMap<>();

        for (int i = 0; i < friends.size(); i++) {
            makeConnections(friendsList, friends.get(i).get(0), friends.get(i).get(1));
        }
    }

    static void makeConnections(Map<String, Set<String>> map, String name1, String name2){
        Set set = new HashSet();
        if (map.containsKey(name1)){
            set = map.get(name1);
            set.add(name2);
        } else {
            set.add(name2);
        }
        map.put(name1, set);
    }
}
