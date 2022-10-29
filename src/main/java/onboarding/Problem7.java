package onboarding;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.HashMap;

public class Problem7 {
    private static final int ID_A = 0;
    private static final int ID_B = 1;
    private static final int FRIEND_OF_FRIEND_SCORE = 10;
    private static final int VISIT_SCORE = 1;
    private static final int LIMIT_RESULT_COUNT = 5;
    private static final int STANDARD_SCORE = 0;

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer;

        Map<String, List<String>> friendMap = new HashMap<>();
        Map<String, Integer> friendScoreMap = new HashMap<>();

        makeFriendMap(friendMap, friendScoreMap, friends);

        giveScoreByFriend(user, friendMap, friendScoreMap);

        giveScoreByVisit(visitors, friendMap.get(user), friendScoreMap);

        List<String> resultList = makeFriends(friendScoreMap);

        answer = resultList.stream()
                .limit(LIMIT_RESULT_COUNT)
                .collect(Collectors.toList());

        return answer;
    }

    private static void addFriend(Map<String, List<String>> friendMap, Map<String, Integer> friendScoreMap, String friendA, String friendB) {
        if (!friendMap.containsKey(friendA)) {
            List<String> friends = new LinkedList<>();
            friends.add(friendB);

            friendMap.put(friendA, friends);
            friendScoreMap.put(friendA, 0);
        }
        else {
            List<String> friends = friendMap.get(friendA);
            friends.add(friendB);
        }
    }

    private static void makeFriendMap(Map<String, List<String>> friendMap, Map<String, Integer> friendScoreMap, List<List<String>> friends) {
        for(List<String> relation : friends) {
            String friend1 = relation.get(ID_A);
            String friend2 = relation.get(ID_B);

            addFriend(friendMap, friendScoreMap, friend1, friend2);
            addFriend(friendMap, friendScoreMap, friend2, friend1);
        }
    }

    private static void giveScoreByFriend(String user, Map<String, List<String>> friendMap , Map<String, Integer> friendScoreMap) {
        List<String> friendsOfUser = friendMap.get(user);

        for(String friendOfUser : friendsOfUser) {
            List<String> friendsOfFriend = friendMap.get(friendOfUser);

            for(String friend : friendsOfFriend) {
                if (friend.equals(user)) {
                    continue;
                }

                int friendScore = friendScoreMap.get(friend);
                friendScoreMap.put(friend, friendScore + FRIEND_OF_FRIEND_SCORE);
            }
        }
    }

    private static void giveScoreByVisit(List<String> visitors, List<String> friendsOfUser, Map<String, Integer> friendScoreMap) {
        for(String visitor : visitors) {
            if (friendsOfUser.contains(visitor))
                continue;;

            if (friendScoreMap.containsKey(visitor)) {
                int friendScore = friendScoreMap.get(visitor).intValue();
                friendScoreMap.put(visitor, friendScore + VISIT_SCORE);
            } else {
                friendScoreMap.put(visitor, VISIT_SCORE);
            }
        }
    }

    private static List<String> makeFriends(Map<String, Integer> friendScoreMap) {
        List<String> friends = new LinkedList<>();

        for(String friend : friendScoreMap.keySet()) {
            if (friendScoreMap.get(friend) > STANDARD_SCORE) {
                friends.add(friend);
            }
        }

        friends.sort(new Comparator<String>() {
            @Override public int compare(String subject, String target) {
                int subjectScore = friendScoreMap.get(subject).intValue();
                int targetScore = friendScoreMap.get(target).intValue();
                if (subjectScore > targetScore) {
                    return -1;
                }
                if (subjectScore < targetScore) {
                    return 1;
                }
                return subject.compareTo(target);
            }
        });

        return friends;
    }
}
