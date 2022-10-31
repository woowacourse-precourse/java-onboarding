package onboarding;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Problem7 {
    private static final int NUMBER_OF_OUTPUT = 5;
    private static TreeMap<String, Integer> friendsScore = new TreeMap<>();

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer;
        List<String> userFriends;
        initFriendsScore();

        userFriends = getUserFriends(user, friends);
        scoringFriend(user, userFriends, friends);
        scoringVisitor(userFriends, visitors);
        answer = sortByScore();

        return answer;
    }

    private static void initFriendsScore() {
        friendsScore = new TreeMap<>();
    }

    private static List<String> getUserFriends(String user, List<List<String>> friends) {
        List<String> userFriends = new ArrayList<>();

        for (List<String> friend : friends) {
            String addId = getUserToAdd(user, friend);

            if (!addId.isEmpty()) {
                userFriends.add(addId);
            }
        }

        return userFriends;
    }

    private static String getUserToAdd(String user, List<String> friend) {
        int friendIndex = friend.indexOf(user);

        if (friendIndex == 0) {
            return friend.get(1);
        } else if (friendIndex == 1) {
            return friend.get(0);
        }

        return "";
    }

    private static void scoringFriend(String user, List<String> userFriends, List<List<String>> friends) {
        for (List<String> friend : friends) {
            if (isNotFriend(user, friend)) {
                String friendId = getFriendName(userFriends, friend);
                String addId = getUserToAdd(friendId, friend);

                if (!addId.isEmpty() && isNotFriend(addId, userFriends)) {
                    int score = 10;

                    if (isContainFriendsScore(addId)) {
                        score += friendsScore.get(addId);
                    }

                    friendsScore.put(addId, score);
                }
            }
        }
    }

    private static void scoringVisitor(List<String> userFriends, List<String> visitors) {
        for (String visitor : visitors) {
            if (isNotFriend(visitor, userFriends)) {
                int score = 1;

                if (isContainFriendsScore(visitor)) {
                    score += friendsScore.get(visitor);
                }

                friendsScore.put(visitor, score);
            }
        }
    }

    private static boolean isNotFriend(String user, List<String> friend) {
        return !friend.contains(user);
    }

    private static boolean isContainFriendsScore(String checkNickname) {
        return friendsScore.containsKey(checkNickname);
    }

    private static String getFriendName(List<String> userFriends, List<String> friend) {
        List<String> result = friend.stream()
                                    .filter(old -> userFriends.stream()
                                    .anyMatch(Predicate.isEqual(old)))
                                    .collect(Collectors.toList());
        return result.get(0);
    }

    private static List<String> sortByScore() {
        List<String> keySet = new ArrayList<>(friendsScore.keySet());
        List<String> topFiveUser = new ArrayList<>();

        keySet.sort((o1, o2) -> friendsScore.get(o2).compareTo(friendsScore.get(o1)));

        for (String key : keySet) {
            topFiveUser.add(key);

            if (topFiveUser.size() == NUMBER_OF_OUTPUT) {
                break;
            }
        }

        return topFiveUser;
    }
}
