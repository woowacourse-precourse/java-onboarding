package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        HashSet<String> myFriends = new HashSet<>();
        HashMap<String, Integer> recommends = new HashMap<>();

        for (List<String> friend : friends) {
            if (friend.get(0).equals(user)) myFriends.add(friend.get(1));
            else if (friend.get(1).equals(user)) myFriends.add(friend.get(0));
        }

        for (List<String> friend : friends) {
            if (myFriends.contains(friend.get(0)) && !friend.get(1).equals(user)) {
                if (recommends.containsKey(friend.get(1))) recommends.replace(friend.get(1), recommends.get(friend.get(1)) + 10);
                else recommends.put(friend.get(1), 10);
            }
            else if (myFriends.contains(friend.get(1)) && !friend.get(0).equals(user)) {
                if (recommends.containsKey(friend.get(0))) recommends.replace(friend.get(0), recommends.get(friend.get(0)) + 10);
                else recommends.put(friend.get(0), 10);
            }
        }

        for (String visitor : visitors) {
            if (!myFriends.contains(visitor)) {
                if (recommends.containsKey(visitor)) recommends.replace(visitor, recommends.get(visitor) + 1);
                else recommends.put(visitor, 1);
            }
        }

        List<String> answer = new ArrayList<>(recommends.keySet());
        Collections.sort(answer, String::compareTo);
        Collections.sort(answer, (o1, o2) -> (recommends.get(o2).compareTo(recommends.get(o1))));
        answer.subList(0, Math.min(answer.size(), 5));

       return answer;
    }
}
