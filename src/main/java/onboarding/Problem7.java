package onboarding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Problem7 {

    private static final int BOTH_KNOW_FRIEND_SCORE = 10;
    private static final int ANSWER_SIZE_MAX = 5;
    private static final int ID_SIZE_MIN = 1;
    private static final int ID_SIZE_MAX = 30;
    private static final int FRIENDS_LIST_SIZE_MIN = 1;
    private static final int FRIENDS_LIST_SIZE_MAX = 10000;
    private static final int FRIENDS_ELEMENT_SIZE = 2;
    private static final int VISITORS_LIST_SIZE_MAX = 10000;
    private static final String LOWER_ALPHABET_REGEX = "^[a-z]*$";

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        validateInput(user, friends, visitors);
        Friends userAndFriends = new Friends(user, friends);
        BothKnowFriendsScore userAndBothKnowFriendsScore = new BothKnowFriendsScore(user, userAndFriends.get());
        VisitScore userAndVisitScore = new VisitScore(visitors);
        RecommendScore userAndRecommendScore = new RecommendScore(userAndBothKnowFriendsScore.get(), userAndVisitScore.get());
        Answer answer = new Answer(user, userAndFriends.get()
            .get(user), userAndRecommendScore.get());

        return answer.get();
    }

    private static void validateInput(String user, List<List<String>> friends, List<String> visitors) {
        validateUser(user);
        validateFriends(friends);
        validateVisitors(visitors);
    }

    static void validateVisitors(List<String> visitors) {
        if (!isValidVisitorsSize(visitors)) {
            throw new IllegalArgumentException();
        }
        visitors.forEach(Problem7::validateUser);
    }

    private static boolean isValidVisitorsSize(List<String> visitors) {
        return visitors.size() <= VISITORS_LIST_SIZE_MAX;
    }

    static void validateFriends(List<List<String>> friends) {
        if (!isValidFriendsSize(friends)) {
            throw new IllegalArgumentException();
        }
        friends.forEach(friend -> friend.forEach(Problem7::validateUser));
    }

    private static boolean isValidFriendsSize(List<List<String>> friends) {
        if (friends.size() < FRIENDS_LIST_SIZE_MIN || friends.size() > FRIENDS_LIST_SIZE_MAX) {
            return false;
        }
        return countInvalidFriendsElement(friends) == 0;
    }

    private static int countInvalidFriendsElement(List<List<String>> friends) {
        return (int) friends.stream()
            .filter(friend -> friend.size() != FRIENDS_ELEMENT_SIZE)
            .count();
    }

    static void validateUser(String user) {
        if (!isValidIdSize(user) || !isIdLowerAlphabet(user)) {
            throw new IllegalArgumentException();
        }
    }

    private static boolean isValidIdSize(String id) {
        return id.length() >= ID_SIZE_MIN && id.length() <= ID_SIZE_MAX;
    }

    private static boolean isIdLowerAlphabet(String id) {
        return Pattern.matches(LOWER_ALPHABET_REGEX, id);
    }

    public static class Answer {

        private static List<String> answer;

        public Answer(String mainCharacter, List<String> mainCharacterFriends, Map<String, Integer> userAndRecommendScore) {
            List<Map.Entry<String, Integer>> userAndRecommendScoreList = computeSortedRecommendScore(userAndRecommendScore.entrySet());

            answer = userAndRecommendScoreList.stream()
                .filter(entry -> !entry.getKey()
                    .equals(mainCharacter))
                .filter(entry -> !mainCharacterFriends.contains(entry.getKey()))
                .filter(entry -> entry.getValue() > 0)
                .map(Map.Entry::getKey)
                .limit(ANSWER_SIZE_MAX)
                .collect(Collectors.toList());
        }

        private List<Map.Entry<String, Integer>> computeSortedRecommendScore(Set<Entry<String, Integer>> userAndRecommendScore) {
            List<Map.Entry<String, Integer>> userAndRecommendScoreList = new ArrayList<>(userAndRecommendScore);

            userAndRecommendScoreList.sort((entry1, entry2) -> {
                if (entry1.getValue() - entry2.getValue() != 0) {
                    return entry2.getValue() - entry1.getValue();
                }
                return entry1.getKey()
                    .compareTo(entry2.getKey());
            });
            return userAndRecommendScoreList;
        }

        public List<String> get() {
            return answer;
        }
    }

    public static class RecommendScore {

        private static Map<String, Integer> userAndRecommendScore;

        public RecommendScore(Map<String, Integer> userAndBothKnowFriendsScore, Map<String, Integer> userAndVisitScore) {
            userAndRecommendScore = new HashMap<>(userAndBothKnowFriendsScore);

            userAndVisitScore.forEach((user, score) -> {
                if (!userAndRecommendScore.containsKey(user)) {
                    userAndRecommendScore.put(user, 0);
                }
                userAndRecommendScore.put(user, userAndRecommendScore.get(user) + score);
            });
        }

        public Map<String, Integer> get() {
            return userAndRecommendScore;
        }
    }

    public static class VisitScore {

        private static Map<String, Integer> userAndVisitScore;

        public VisitScore(List<String> visitors) {
            userAndVisitScore = visitors.stream()
                .distinct()
                .collect(Collectors.toMap(visitor -> visitor, visitor -> 0));

            visitors.forEach(visitor -> userAndVisitScore.put(visitor, userAndVisitScore.get(visitor) + 1));
        }

        public Map<String, Integer> get() {
            return userAndVisitScore;
        }
    }

    public static class Friends {

        private static Map<String, List<String>> userAndFriends;

        public Friends(String mainCharacter, List<List<String>> friends) {
            userAndFriends = new HashMap<>();
            friends.forEach(user -> {
                addFriend(userAndFriends, user.get(0), user.get(1));
                addFriend(userAndFriends, user.get(1), user.get(0));
            });
            if (!userAndFriends.containsKey(mainCharacter)) {
                userAndFriends.put(mainCharacter, new ArrayList<>());
            }
        }

        private void addFriend(Map<String, List<String>> userAndFriends, String user1, String user2) {
            if (!userAndFriends.containsKey(user1)) {
                userAndFriends.put(user1, new ArrayList<>());
            }
            List<String> friends = userAndFriends.get(user1);
            friends.add(user2);
            userAndFriends.put(user1, friends);
        }

        public Map<String, List<String>> get() {
            return userAndFriends;
        }
    }

    public static class BothKnowFriendsScore {

        private static Map<String, Integer> userAndBothKnowFriendsScore;

        public BothKnowFriendsScore(String mainCharacter, Map<String, List<String>> userAndFriends) {
            userAndBothKnowFriendsScore = new HashMap<>();
            List<String> mainCharacterFriends = userAndFriends.get(mainCharacter);

            userAndFriends.forEach((user, friends) -> {
                int bothKnowFriendsCount = countBothKnowFriends(mainCharacterFriends, friends);
                userAndBothKnowFriendsScore.put(user, BOTH_KNOW_FRIEND_SCORE * bothKnowFriendsCount);
            });
        }

        private int countBothKnowFriends(List<String> friends1, List<String> friends2) {
            return (int) friends1.stream()
                .filter(friends2::contains)
                .count();
        }

        public Map<String, Integer> get() {
            return userAndBothKnowFriendsScore;
        }
    }
}
