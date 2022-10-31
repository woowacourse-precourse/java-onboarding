package onboarding;

import java.util.Collections;
import java.util.List;

public class Problem7 {

    static HashMap<String, Set<String>> friendsMap = new HashMap<>();
    static HashMap<String, Integer> points = new HashMap<>();

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }

    private static void addFriends(List<String> friend, String user) {
        if (!friend.get(0).equals(user)) points.put(friend.get(0), 0);
        if (!friend.get(1).equals(user)) points.put(friend.get(1), 0);

        if (!friendsMap.containsKey(friend.get(0))) friendsMap.put(friend.get(0), new HashSet<>());
        if (!friendsMap.containsKey(friend.get(1))) friendsMap.put(friend.get(1), new HashSet<>());

        friendsMap.get(friend.get(1)).add(friend.get(0));
        friendsMap.get(friend.get(0)).add(friend.get(1));

        return;
    }

}
