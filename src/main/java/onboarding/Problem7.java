package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {

    // 1. Use HashSet and HashMap to solve the problem7
    static Set<String> userFriendsList = new HashSet<>();
    static Map<String, Integer> scoreList = new HashMap<>();

    // 2. Main logic
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        makeFriendsList(user, friends);     // Make user's friends list
        calculateScore(user, friends, visitors);    // Calculate each friends' score
        List<String> answer = getFinalList((HashMap<String, Integer>) scoreList);
        return answer;
    }

    // 3. Method to make users' friend list
    public static void makeFriendsList(String user, List<List<String>> friends) {
        for (List<String> friend : friends) {
            if (friend.get(0).equals(user)) {
                userFriendsList.add(friend.get(1));
            } else if (friend.get(1).equals(user)) {
                userFriendsList.add(friend.get(0));
            }
        }
    }

    // 4. Method to calculate each friends' score
    public static void calculateScore(String user, List<List<String>> friends, List<String> visitors) {
        for (List<String> friend : friends) {
            if (friend.get(0).equals(user) || friend.get(1).equals(user)) { // If the user and friend are the same
                continue;
            }
            if (userFriendsList.contains(friend.get(0))) {  // If the friend know the same friend of user: + 10
                increaseScore(friend.get(1), 10);
            }
            if (userFriendsList.contains(friend.get(1))) {
                increaseScore(friend.get(0), 10);
            }
        }

        for (String visitor : visitors) {
            if (scoreList.containsKey(visitor)) {   // If the friend visited the user: + 1
                increaseScore(visitor, 1);
            }
            scoreList.put(visitor, 1);
        }
    }

    // 5. Method to increase score of the friend
    public static void increaseScore(String user, int score) {
        scoreList.put(user, scoreList.getOrDefault(user, 0) + score);
    }

    // 6. Method to return the top 5 friends sorted by score -> name
    public static List<String> getFinalList(HashMap<String, Integer> userScoreList) {
        return userScoreList.entrySet().stream().filter(e -> !userFriendsList.contains(e.getKey()) && e.getValue() > 0)
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .map(Map.Entry::getKey)
                .limit(5)
                .collect(Collectors.toList());
    }
}