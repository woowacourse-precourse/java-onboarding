package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {

        Map<String, Set<String>> friendsList = new HashMap<>();

        for (int i = 0; i < friends.size(); i++) {
            makeConnections(friendsList, friends.get(i).get(0), friends.get(i).get(1));
        }

        Set<String> usersFriends = makeUsersFriendsList(user, friendsList);

        

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
}
