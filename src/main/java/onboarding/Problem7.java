package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        Set<String> userFriends = new HashSet<>();
        friends.forEach(elem -> constructFriendsSet(userFriends, user, elem.get(0), elem.get(1)));

        List<String> friendsOfUserFriends = new ArrayList<>();
        userFriends.forEach(elem -> constructFriendsList(elem, friendsOfUserFriends, friends));

        Map<String, Integer> scoreOfFriends = new HashMap<>();
        addScores(scoreOfFriends, userFriends, user, friendsOfUserFriends, visitors);
        return getAnswer(scoreOfFriends);

    }

    private static void constructFriendsSet(Set<String> setFriends,
                                           String target,
                                           String friendA,
                                           String friendB) {
        if (friendA.equals(target)) {
            setFriends.add(friendB);
        }
        if (friendB.equals(target)) {
            setFriends.add(friendA);
        }
    }

    private static void constructFriendsList(String target,
                                            List<String> listFriends,
                                            List<List<String>> friends) {
        Set<String> targetFriends = new HashSet<>();
        friends.forEach(elem -> constructFriendsSet(targetFriends, target, elem.get(0), elem.get(1)));
        targetFriends.forEach(elem -> listFriends.add(elem));
    }

    private static Map<String, Integer> addScores(Map<String, Integer> scores,
                                                  Set<String> userFriends,
                                                  String user,
                                                  List<String> commonFriends,
                                                  List<String> visitors) {
        commonFriends.forEach(item -> addCommonFriendsScores(scores, userFriends, item, user));
        visitors.forEach(item -> scores.put(item, scores.containsKey(item) ? scores.get(item) + 1 : 1));
        return scores;
    }

    private static void addCommonFriendsScores(Map<String, Integer> scores,
                                               Set<String> userFriends,
                                               String target,
                                               String user) {
        if (!userFriends.contains(target) && !target.equals(user)) {
            scores.put(target, scores.containsKey(target) ? scores.get(target) + 10 : 0);
        }
    }

    private static List<String> getAnswer(Map<String, Integer> scores) {

    }
}

//A
//
//B C D
//
//각 B C D의 친구들 다 list에 넣어서 elem마다 점수 10점씩 주는데
//이때 elem이 A와 친구 set에 있으면 안주고 아니면 줌.