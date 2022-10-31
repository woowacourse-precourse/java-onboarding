package onboarding;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class Problem7 {
    private static final List<String> myFriendsList = new ArrayList<>();
    private static final List<List<String>> notFriendsList = new ArrayList<>();

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        Map<String, Integer> score = new HashMap<>();

        if (isError(user, friends, visitors)) {
            return List.of("-1");
        }

        divideFriends(user, friends);

        giveScore(visitors, score);

        return score.entrySet().stream()
                .filter(e -> e.getValue() != 0)
                .sorted(new Comparator<Map.Entry<String, Integer>>() {
                    @Override
                    public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                        if (Objects.equals(o1.getValue(), o2.getValue())) {
                            return o1.getKey().compareTo(o2.getKey());
                        }
                        return o2.getValue().compareTo(o1.getValue());
                    }
                })
                .map(Map.Entry::getKey)
                .limit(5)
                .collect(Collectors.toList());
    }

    public static void giveScore(List<String> visitors, Map<String, Integer> score) {
        getFriendsScore(score);

        getVisitorsScore(visitors, score);
    }

    private static void getFriendsScore(Map<String, Integer> score) {
        for (List<String> notFriend : notFriendsList) {
            String id = null;
            if (myFriendsList.contains(notFriend.get(0)) && !myFriendsList.contains(notFriend.get(1))) {
                id = notFriend.get(1);
            } else if (myFriendsList.contains(notFriend.get(1)) && !myFriendsList.contains(notFriend.get(0))) {
                id = notFriend.get(0);
            }
            if (id != null) {
                score.put(id, score.getOrDefault(id, 0) + 10);
            }
        }
    }

    private static void getVisitorsScore(List<String> visitors, Map<String, Integer> score) {
        for (String visitor : visitors) {
            if (!myFriendsList.contains(visitor)) {
                score.put(visitor, score.getOrDefault(visitor, 0) + 1);
            }
        }
    }

    private static void divideFriends(String user, List<List<String>> friends) {
        for (List<String> friend : friends) {
            String id = getOneOfTwo(friend, user);

            if (id != null) {
                myFriendsList.add(id);
            } else {
                notFriendsList.add(friend);
            }
        }
    }

    public static String getOneOfTwo(List<String> list, String id) {
        if (list.get(0).equals(id)) {
            return list.get(1);
        } else if (list.get(1).equals(id)) {
            return list.get(0);
        }

        return null;
    }

    public static boolean isError(String user, List<List<String>> friends, List<String> visitors) {
        return checkUser(user) || checkFriends(friends) || checkVisitors(visitors);
    }

    public static boolean checkUser(String user) {
        return user.length() < 1 || user.length() > 30 || !user.matches("^[a-z]*$");
    }

    public static boolean checkFriends(List<List<String>> friends) {
        if (friends.size() < 1 || friends.size() > 10000) {
            return true;
        }
        for (List<String> friend : friends) {
            if (friend.size() != 2) {
                return true;
            }
            if (friend.get(0).length() < 1 || friend.get(0).length() > 30 || friend.get(1).length() < 1 || friend.get(1).length() > 30) {
                return true;
            }
        }

        return false;
    }

    public static boolean checkVisitors(List<String> visitors) {
        return visitors.size() > 10000;
    }
}
