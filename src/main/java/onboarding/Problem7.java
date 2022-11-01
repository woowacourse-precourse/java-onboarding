package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        List<String> userFriend = new ArrayList<>();
        List<String> friendResult = new ArrayList<>();

        for (int i = 0; i < friends.size(); i++) {
            List<String> friend = friends.get(i);
            if (friend.get(0) == user) {
                userFriend.add(friend.get(1));
            }
            if (friend.get(1) == user) {
                userFriend.add(friend.get(0));
            }
        }

        for (int i = 0; i < userFriend.size(); i++) {
            String userFriendName = userFriend.get(i);

            for (int j = 0; j < friends.size(); j++) {

                List<String> friend = friends.get(j);

                if (friend.get(0) == userFriendName) {
                    friendResult.add(friend.get(1));
                }
                if (friend.get(1) == userFriendName) {
                    friendResult.add(friend.get(0));
                }
            }
        }
        while (friendResult.remove(user)) {}

        HashMap<String, Integer> result = new HashMap<>();

        for (int i = 0; i < friendResult.size(); i++) {

            if (result.containsKey(friendResult.get(i))) {
                Integer visit = result.get(friendResult.get(i));
                result.put(friendResult.get(i), visit + 10);
            } else {
                result.put(friendResult.get(i), 10);
            }
        }

        for (int i = 0; i < visitors.size(); i++) {
            if (!userFriend.contains(visitors.get(i))) {

                if (result.containsKey(visitors.get(i))) {
                    Integer visit = result.get(visitors.get(i));
                    result.put(visitors.get(i), visit + 1);
                } else {
                    result.put(visitors.get(i), 1);
                }

            }
        }

        List<String> resultList = new ArrayList(result.keySet());
        resultList.sort((o1, o2) -> result.get(o2) - result.get(o1));

        if (resultList.size() <= 5)
            answer = resultList;
        else {
            answer.add(resultList.get(0));
            answer.add(resultList.get(1));
            answer.add(resultList.get(2));
            answer.add(resultList.get(3));
            answer.add(resultList.get(4));
        }

        return answer;
    }
}
