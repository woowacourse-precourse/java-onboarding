package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {

        Map<String, Set<String>> friendsList = new HashMap<>();

        for (int i = 0; i < friends.size(); i++) {
            makeConnections(friendsList, friends.get(i).get(0), friends.get(i).get(1));
        }

        Set<String> usersFriendsSet = makeUsersFriendsList(user, friendsList);

        Map<String, Integer> scores = getFriendScore(user, usersFriendsSet, friendsList);

    }

    static void makeConnections(Map<String, Set<String>> map, String name1, String name2){
        if (map.containsKey(name1)){
            map.get(name1).add(name2);
        } else {
            map.put(name1, Set.of(name2));
        }
    }

    static Set<String> makeUsersFriendsList(String user, Map<String, Set<String>> map){
        Set<String> result = new HashSet<>();

        Set<String> keySet = map.keySet();

        for(String str : keySet){
            if (map.get(user).contains(str)){
                result.add(str);
            }
        }
        return result;
    }

    static Map<String, Integer> getFriendScore(String user, Set<String> set, Map<String, Set<String>> map) {
        Map<String, Integer> result = new HashMap<>();

        for (String str : set) {
            Iterator<String> it = map.get(str).iterator();
            if (!str.equals(user) && it.hasNext()) {
                result.put(str, result.getOrDefault(str, 0) + 10);
            }
        }
        return result;
    }

}
