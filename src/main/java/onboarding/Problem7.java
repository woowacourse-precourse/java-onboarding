package onboarding;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Problem7 {
    public static final int MUTUAL_SCORE = 10;
    public static final int VISITED_SCORE = 1;

    private static Set<String> userFriendList;
    private static Map<String, Integer> recommendScore;

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        initSetAndMap();
        saveUserFriendList(user, friends);
        addMutualFriend(user, friends);
        addVisitedPerson(user, visitors);
        List<String> sortedRecommendList = getSortedRecommendList();
        return getNRecommendList(sortedRecommendList, 5);
    }

    private static void initSetAndMap() {
        userFriendList = new HashSet<>();
        recommendScore = new HashMap<>();
    }

    private static void saveUserFriendList(String user, List<List<String>> friends) {
        for (List<String> friend : friends) {
            addFriendToSet(user, friend);
        }
    }

    private static void addFriendToSet(String user, List<String> friend) {
        if (user.equals(friend.get(0))) {
            userFriendList.add(friend.get(1));
        } else if (user.equals(friend.get(1))) {
            userFriendList.add(friend.get(0));
        }
    }

    private static void addMutualFriend(String user, List<List<String>> friends) {
        for (List<String> friend : friends) {
            scoreMutualFriend(user, friend);
        }
    }

    private static void scoreMutualFriend(String user, List<String> friend) {
        if (!isNewFriend(user, friend.get(0))) {
            if (isNewFriend(user, friend.get(1))) {
                addRecommendScore(friend.get(1), MUTUAL_SCORE);
            }
        } else if (!isNewFriend(user, friend.get(1))) {
            if (isNewFriend(user, friend.get(0))) {
                addRecommendScore(friend.get(0), MUTUAL_SCORE);
            }
        }
    }

    private static boolean isNewFriend(String user, String friend) {
        return !(userFriendList.contains(friend) || user.equals(friend));
    }

    private static void addRecommendScore(String friend, int x) {
        if (recommendScore.containsKey(friend)) {
            recommendScore.replace(friend, recommendScore.get(friend) + x);
        } else {
            recommendScore.put(friend, x);
        }
    }

    private static void addVisitedPerson(String user, List<String> visitors) {
        for (String visitor : visitors) {
            if (isNewFriend(user, visitor)) {
                addRecommendScore(visitor, VISITED_SCORE);
            }
        }
    }


    private static List<String> getSortedRecommendList() {
        List<String> recommendList = new ArrayList<>(recommendScore.keySet());

        recommendList.sort((o1, o2) -> {
            if (recommendScore.get(o1) > recommendScore.get(o2)) {
                return -1;
            } else if (recommendScore.get(o1) < recommendScore.get(o2)) {
                return 1;
            } else {
                return o1.compareTo(o2);
            }
        });

        return recommendList;
    }

    private static List<String> getNRecommendList(List<String> sortedRecommendList, int n) {
        ArrayList<String> nRecommendList = new ArrayList<>();

        int size = Math.min(n, sortedRecommendList.size());

        for (int i = 0; i < size; i++) {
            nRecommendList.add(sortedRecommendList.get(i));
        }

        return nRecommendList;
    }
}
