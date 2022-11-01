package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class Problem7 {

    public static List<String> solution(String user, List<List<String>> friends,
                                        List<String> visitors) {
        List<String> answer = Collections.emptyList();
        Set<String> userFriends = new HashSet<>();
        Map<String, Integer> friendRelationScoreRepo = new HashMap<>();
        UserValidator.validate(user);
        FriendsValidator.validate(friends);
        VisitorsValidator.validate(visitors);
        findUserFriends(user, friends, userFriends);
        calculateRelationScore(user, friends, userFriends, friendRelationScoreRepo);
        calculateVisitScore(userFriends, visitors, friendRelationScoreRepo);
        answer = getResult(friendRelationScoreRepo);
        return answer;
    }

    private static List<String> getResult(Map<String, Integer> friendRelationScoreRepo) {
        List<String> sortedResult = new ArrayList<>();
        List<Map.Entry<String, Integer>> entries =
            friendRelationScoreRepo.entrySet().stream().sorted(Map.Entry.comparingByKey())
                .sorted(new Comparator<Map.Entry<String, Integer>>() {
                    @Override
                    public int compare(Map.Entry<String, Integer> o1,
                                       Map.Entry<String, Integer> o2) {
                        return o2.getValue() - o1.getValue();
                    }
                })
                .collect(Collectors.toList());
        for (Map.Entry<String, Integer> entry : entries) {
            sortedResult.add(entry.getKey());
        }
        return sortedResult.stream().limit(5).collect(Collectors.toList());
    }

    private static Map<String, Integer> calculateVisitScore(Set<String> userFriends,
                                                            List<String> visitors,
                                                            Map<String, Integer> friendRelationScoreRepo) {
        visitors.stream().forEach(visitor -> friendRelationScoreRepo.put(visitor,
            friendRelationScoreRepo.getOrDefault(visitor, 0) + 1));
        userFriends.stream().forEach(friendRelationScoreRepo::remove);
        return friendRelationScoreRepo;
    }

    private static Map<String, Integer> calculateRelationScore(
        String user, List<List<String>> friends, Set<String> userFriends,
        Map<String, Integer> friendRelationScoreRepo) {
        for (String userFriend : userFriends) {
            friends.stream().filter(friend -> friend.contains(userFriend))
                .forEach(friend -> friend.stream()
                    .filter(mate -> !Objects.equals(mate, userFriend))
                    .forEach(mate -> friendRelationScoreRepo.put(mate,
                        friendRelationScoreRepo.getOrDefault(mate, 0) + 10))
                );
        }
        friendRelationScoreRepo.remove(user);
        return friendRelationScoreRepo;
    }

    private static Set<String> findUserFriends(String user, List<List<String>> friends,
                                               Set<String> userFriends) {
        for (List<String> friend : friends) {
            if (friend.contains(user)) {
                userFriends.add(friend.get(0));
                userFriends.add(friend.get(1));
            }
        }
        userFriends.remove(user);
        return userFriends;
    }

    private static class UserValidator {
        private static final int MIN_USER_LENGTH = 1;
        private static final int MAX_USER_LENGTH = 30;

        public static void validate(String user) {
            char[] chars = user.toCharArray();
            if (!isValidUserLength(user.length())) {
                throw new IllegalArgumentException(
                    "The user's length should be greater than or equal to 1, and less than or equal to 30.");
            }

            for (char aChar : chars) {
                if(Character.isUpperCase(aChar)) {
                    throw new IllegalArgumentException("The user ID should be in lowercase alphabetic characters.");
                }
            }
        }

        private static boolean isValidUserLength(int length) {
            return length >= MIN_USER_LENGTH && length <= MAX_USER_LENGTH;
        }
    }

    private static class FriendsValidator {
        private static final int MIN_FRIENDS_LIST_SIZE = 1;
        private static final int MAX_FRIENDS_LIST_SIZE = 10000;
        private static final int FRIEND_LIST_SIZE = 2;
        private static final int MIN_ID_LENGTH = 1;
        private static final int MAX_ID_LENGTH = 30;

        public static void validate(List<List<String>> friends) {
            if (!isValidFriendsListSize(friends.size())) {
                throw new IllegalArgumentException(
                    "The size of friends list should be greater than or equal to 1, and less than or equal to 10000.");
            }
            for (List<String> friendList : friends) {
                if (!isValidFriendListSize(friendList.size())) {
                    throw new IllegalArgumentException("The size of friend list should be 2.");
                }
                for (String id : friendList) {
                    if (!isValidIdLength(id.length())) {
                        throw new IllegalArgumentException(
                            "The id's Length should be greater than or equal to 1, and less than or equal to 30.");
                    }
                }
            }
        }

        private static boolean isValidIdLength(int idLength) {
            return idLength >= MIN_ID_LENGTH && idLength <= MAX_ID_LENGTH;
        }

        private static boolean isValidFriendListSize(int size) {
            return size == FRIEND_LIST_SIZE;
        }

        private static boolean isValidFriendsListSize(int size) {
            return size >= MIN_FRIENDS_LIST_SIZE && size <= MAX_FRIENDS_LIST_SIZE;
        }
    }

    private static class VisitorsValidator {
        private final static int MAX_VISITORS_LIST_SIZE = 10000;

        public static void validate(List<String> visitors) {
            if (!isValidVisitorsListSize(visitors.size())) {
                throw new IllegalArgumentException(
                    "The size of visitors list should be less than or equal to 10000.");
            }
        }

        private static boolean isValidVisitorsListSize(int size) {
            return size <= MAX_VISITORS_LIST_SIZE;
        }
    }
}
