package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }

    public static List<String> getUserFriends(String user, List<List<String>> friends) {
        List<String> userFriends = new ArrayList<>();
        for (List<String> friend: friends) {
            String user1 = friend.get(0);
            String user2 = friend.get(1);

            if(user1.equals(user)) {
                userFriends.add(user2);
                continue;
            }
            if (user2.equals(user)) {
                userFriends.add(user1);
                continue;
            }
        }

        return userFriends;
    }

    public static HashMap<String, Integer> getAcquaintance (List<String> userFriends, List<List<String>> friends) {
        HashMap<String, Integer> listOfScore = new HashMap<>();
        for (String user: userFriends) {
            for (List<String> friend: friends) {
                String user1 = friend.get(0);
                String user2 = friend.get(1);
                if (user1.equals(user)) {
                    listOfScore.put(user2, listOfScore.getOrDefault(user2, 0) + 10);
                } else if (user2.equals(user)) {
                    listOfScore.put(user1, listOfScore.getOrDefault(user1, 0) + 10);
                }
            }
        }
        return listOfScore;
    }


}
