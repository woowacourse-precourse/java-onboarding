package onboarding;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Problem7 {

    private static final int BOTH_KNOW_FRIEND_SCORE = 10;
    private static final int ANSWER_SIZE_MAX = 5;
    private static final int ID_SIZE_MIN = 1;
    private static final int ID_SIZE_MAX = 30;
    private static final String LOWER_ALPHABET_REGEX = "^[a-z]*$";

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        validateInput(user, friends, visitors);
        Map<String, List<String>> userAndFriends = parseFriendsInput(friends);
        Map<String, Integer> userAndBothKnowFriendsScore = computeBothKnowFriendsScore(user, userAndFriends);
        Map<String, Integer> userAndVisitScore = computeVisitScore(visitors);
        Map<String, Integer> userAndRecommendScore = computeRecommendScore(userAndBothKnowFriendsScore, userAndVisitScore);

        return computeAnswer(user, userAndFriends.get(user), userAndRecommendScore);
    }

    private static void validateInput(String user, List<List<String>> friends, List<String> visitors) {
        validateUser(user);
    }

    static void validateUser(String user) {
        if (!isValidIdSize(user) || !isIdLowerAlphabet(user)) {
            throw new IllegalArgumentException();
        }
    }

    private static boolean isValidIdSize(String id) {
        if (id.length() >= ID_SIZE_MIN && id.length() <= ID_SIZE_MAX) {
            return true;
        }
        return false;
    }

    private static boolean isIdLowerAlphabet(String id) {
        if(Pattern.matches(LOWER_ALPHABET_REGEX, id)) {
            return true;
        }
        return false;
    }

    static List<String> computeAnswer(String mainCharacter, List<String> mainCharacterFriends, Map<String, Integer> userAndRecommendScore) {
        List<Map.Entry<String, Integer>> userAndRecommendScoreList = new ArrayList<>(userAndRecommendScore.entrySet());

        userAndRecommendScoreList.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));
        return userAndRecommendScoreList.stream()
            .filter(entry -> entry.getKey() != mainCharacter)
            .filter(entry -> !mainCharacterFriends.contains(entry.getKey()))
            .filter(entry -> entry.getValue() > 0)
            .map(entry -> entry.getKey())
            .limit(ANSWER_SIZE_MAX)
            .collect(Collectors.toList());
    }

    static Map<String, Integer> computeRecommendScore(Map<String, Integer> userAndBothKnowFriendsScore, Map<String, Integer> userAndVisitScore) {
        Map<String, Integer> userAndRecommendScore = new HashMap<>(userAndBothKnowFriendsScore);

        userAndVisitScore.forEach((user, score) -> {
            if (!userAndRecommendScore.containsKey(user)) {
                userAndRecommendScore.put(user, 0);
            }
            userAndRecommendScore.put(user, userAndRecommendScore.get(user) + score);
        });
        return userAndRecommendScore;
    }

    static Map<String, Integer> computeVisitScore(List<String> visitors) {
        Map<String, Integer> userAndVisitScore = visitors.stream()
            .distinct()
            .collect(Collectors.toMap(visitor -> visitor, visitor -> 0));

        visitors.forEach(visitor -> userAndVisitScore.put(visitor, userAndVisitScore.get(visitor) + 1));
        return userAndVisitScore;
    }

    static Map<String, Integer> computeBothKnowFriendsScore(String mainCharacter, Map<String, List<String>> userAndFriends) {
        Map<String, Integer> userAndBothKnowFriendsScore = new HashMap<>();
        List<String> mainCharacterFriends = userAndFriends.get(mainCharacter);

        userAndFriends.forEach((user, friends) -> {
            int bothKnowFriendsCount = countBothKnowFriends(mainCharacterFriends, friends);
            userAndBothKnowFriendsScore.put(user, BOTH_KNOW_FRIEND_SCORE * bothKnowFriendsCount);
        });
        return userAndBothKnowFriendsScore;
    }

    private static int countBothKnowFriends(List<String> friends1, List<String> friends2) {
        return (int) friends1.stream()
            .filter(friend1 -> friends2.contains(friend1))
            .count();
    }

    static Map<String, List<String>> parseFriendsInput(List<List<String>> friends) {
        Map<String, List<String>> userAndFriends = new HashMap<>();

        friends.forEach(user -> {
            String user1 = user.get(0);
            String user2 = user.get(1);

            addFriend(userAndFriends, user1, user2);
            addFriend(userAndFriends, user2, user1);
        });

        return userAndFriends;
    }

    private static void addFriend(Map<String, List<String>> userAndFriends, String user1, String user2) {
        if (!userAndFriends.containsKey(user1)) {
            userAndFriends.put(user1, new ArrayList<>());
        }
        List<String> friends = userAndFriends.get(user1);
        friends.add(user2);
        userAndFriends.put(user1, friends);
    }
}
