package onboarding;

import javax.print.attribute.HashPrintServiceAttributeSet;
import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {

        final int COUNT = 5;
        Map<String, Set<String>> friendsList = new HashMap<>();

        for (int i = 0; i < friends.size(); i++) {
            makeConnections(friendsList, friends.get(i).get(0), friends.get(i).get(1));
        }

        Set<String> userFriendSet = friendsList.get(user);

        Map scores = getFriendScore(friendsList, userFriendSet);

        
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

    static Map getFriendScore(Map<String, Set<String>> friendList, Set<String> userFriends){
        Map<String, Integer> result = new HashMap<>();

        for (String str : userFriends) {
            Iterator<String> it = friendList.get(str).iterator();
            while(it.hasNext()){
                String name = it.next();
                result.put(str, result.getOrDefault(str, 0) + 10);
            }
        }
        return result;
    }
}
