package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        Map<String, List<String>> friendsMap = new HashMap<>();
        Map<String, Integer> usersMap = new HashMap<>();

        for(List<String> friend : friends) {
            if(!friendsMap.containsKey(friend.get(0)))
                friendsMap.put(friend.get(0), new ArrayList<>());
            friendsMap.get(friend.get(0)).add(friend.get(1));

            if(!friendsMap.containsKey(friend.get(1)))
                friendsMap.put(friend.get(1), new ArrayList<>());
            friendsMap.get(friend.get(1)).add(friend.get(0));

            usersMap.put(friend.get(0), 0);
            usersMap.put(friend.get(1), 0);
        }

        for(String visitor : visitors) {
            if(!usersMap.containsKey(visitor))
                usersMap.put(visitor, 0);

            Integer score = usersMap.get(visitor);
            usersMap.put(visitor, score + 1);
        }

        List<String> friendsList = friendsMap.get(user);

        for(String friend : friendsList) {
            for(String together : friendsMap.get(friend)) {
                Integer score = usersMap.get(together);
                usersMap.put(together, score + 10);
            }
        }

        List<String> recommendsList = new ArrayList<>();
        usersMap.forEach((k, v) -> {
            if(!friendsList.contains(k) && !user.equals(k) && v != 0)
                recommendsList.add(k);
        });

        recommendsList.sort((a, b) -> usersMap.get(b) - usersMap.get(a) == 0 ? a.compareTo(b) : usersMap.get(b) - usersMap.get(a));

        List<String> answer = new ArrayList<>();

        for(int i = 0; i < Math.min(recommendsList.size(), 5); i++)
            answer.add(recommendsList.get(i));

        return answer;
    }
}
