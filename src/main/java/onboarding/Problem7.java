package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        Map<String, Integer> friendScore = new HashMap<>();

        List<String> friendListOfUser = getFriendList(user, friends);

        for (String friend: friendListOfUser) {
            List<String> friendListOfFriend = getFriendList(friend, friends);
            friendListOfFriend.remove(user);
            applyScore(friendListOfFriend, friendScore, 10);
        }
        applyScore(visitors, friendScore, 1);

        answer = friendScore.entrySet().stream()
            .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
            .limit(5)
            .map(Entry::getKey)
            .collect(Collectors.toList());

        answer.removeAll(friendListOfUser);
        answer.remove(user);

        return answer;
    }

    private static List<String> getFriendList(String user, List<List<String>> friends) {
        List<String> result = new ArrayList<>();

        for (List<String> friend: friends) {
            String friend1 = friend.get(0);
            String friend2 = friend.get(1);

            if (friend1.equals(user)) {
                result.add(friend2);
            } else if (friend2.equals(user)) {
                result.add(friend1);
            }
        }
        return result;
    }

    private static void applyScore(List<String> list, Map<String, Integer> to, Integer score) {
        list.forEach(element ->
            to.put(element, to.getOrDefault(element, 0) + score)
        );
    }
}
