package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {
    private static final Map<String, Integer> recommendScore = new HashMap<>();

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        return Collections.emptyList();
    }

    private static void addFriend(List<String> friend, Map<String, List<String>> friendsList) {
        String from = friend.get(0);
        String to = friend.get(1);

        if (friendsList.containsKey(from))
            friendsList.get(from).add(to);
        else
            friendsList.put(from, new ArrayList<>(List.of(to)));

        if (friendsList.containsKey(to))
            friendsList.get(to).add(from);
        else
            friendsList.put(to, new ArrayList<>(List.of(from)));
    }

    private static Map<String, List<String>> makeFriendsList(List<List<String>> friends) {
        Map<String, List<String>> friendsList = new HashMap<>();

        for (List<String> friend : friends) {
            addFriend(friend, friendsList);
        }

        return friendsList;
    }

    private static void addScore(List<String> friends, int score) {
        for (String friend : friends) {
            if (recommendScore.containsKey(friend)) {
                int existingScore = recommendScore.get(friend);
                recommendScore.put(friend, existingScore + score);
            }
            else {
                recommendScore.put(friend, score);
            }
        }
    }

    private static void deleteInvalidFriends(String user, List<String> existingFriends) {
        recommendScore.remove(user);

        for (String existingFriend: existingFriends) {
            recommendScore.remove(existingFriend);
        }
    }
}