package onboarding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.TreeMap;

public class Problem7 {

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {

        List<String> answer = new LinkedList<>();
        HashMap<String, List<String>> friendMap = new HashMap<>();
        TreeMap<String, Integer> friendScore = new TreeMap<>();
        int cnt = 0;

        for (List<String> friend : friends) {
            String friend1 = friend.get(0);
            String friend2 = friend.get(1);
            List<String> list1 = friendMap.getOrDefault(friend1, new ArrayList<>());
            List<String> list2 = friendMap.getOrDefault(friend2, new ArrayList<>());
            list1.add(friend2);
            list2.add(friend1);
            friendMap.put(friend1, list1);
            friendMap.put(friend2, list2);
        }

        for (String visitor : visitors) {
            if (!friendMap.get(user).contains(visitor) && !visitor.equals(user)) {
                friendScore.put(visitor, friendScore.getOrDefault(visitor, 0) + 1);
            }
        }

        for (String friend : friendMap.get(user)) {
            List<String> mutual = friendMap.get(friend);
            for (String m : mutual) {
                if (!friendMap.get(user).contains(m) && !m.equals(user)) {
                    friendScore.put(m, friendScore.getOrDefault(m, 0) + 10);
                }
            }
        }

        while (!friendScore.isEmpty() && cnt < 5) {
            int max = Integer.MIN_VALUE;
            String maxFriend = "";
            for (Entry<String, Integer> friend : friendScore.entrySet()) {
                String name = friend.getKey();
                int score = friend.getValue();
                if (score > max) {
                    max = score;
                    maxFriend = name;
                }
            }
            answer.add(maxFriend);
            friendScore.remove(maxFriend);
            cnt++;
        }
        return answer;

    }
}
