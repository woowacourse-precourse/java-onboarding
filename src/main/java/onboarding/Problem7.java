package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        HashMap<String, Integer> map = new HashMap<>();
        List<String> alreadyFriends = new ArrayList<>();
        for (List<String> friend : friends) {
            if(friend.get(0).equals(user)) alreadyFriends.add(friend.get(1));
            else if(friend.get(1).equals(user)) alreadyFriends.add(friend.get(0));
            map.putIfAbsent(friend.get(0), 0);
            map.putIfAbsent(friend.get(1), 0);
        }

        for (List<String> friend : friends) {
            if(alreadyFriends.contains(friend.get(0)) && !alreadyFriends.contains(friend.get(1)))
                map.replace(friend.get(1), map.get(friend.get(1)) + 10);
            else if(alreadyFriends.contains(friend.get(1)) && !alreadyFriends.contains(friend.get(0)))
                map.replace(friend.get(0), map.get(friend.get(0)) + 10);
        }

        for (String visitor : visitors) {
            map.putIfAbsent(visitor, 0);
            if(!alreadyFriends.contains(visitor)) map.replace(visitor, map.get(visitor) + 1);
        }

        for (String friend : alreadyFriends) {
            map.remove(friend);
        }
        map.remove(user);

        List<Map.Entry<String, Integer>> entries = new ArrayList<>(map.entrySet());
        entries.sort(((o1, o2) -> o2.getValue().compareTo(o1.getValue())));

        List<String> answer = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : entries) {
            answer.add(entry.getKey());
        }
        return answer;
    }
}
