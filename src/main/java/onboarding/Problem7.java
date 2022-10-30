package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {
    private static final Map<String, Integer> recommendScore = new HashMap<>();

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        Map<String, List<String>> friendsList = makeFriendsList(friends);
        List<String> userFriends = friendsList.get(user);

        for (String userFriend : userFriends) {
            List<String> friendsOfUserFriend = friendsList.get(userFriend);
            addScore(friendsOfUserFriend, 10);
        }

        addScore(visitors, 1);
        deleteInvalidFriends(user, userFriends);
        return sortByValue(recommendScore);
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

    private static List<String> sortByValue(Map<String, Integer> map) {
        List<String> sortedEmails = map.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        if (sortedEmails.size() > 5)
            sortedEmails = sortedEmails.subList(0, 5);
        return sortedEmails;
    }
}