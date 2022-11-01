package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> userFriends = getUserFriends(user, friends);

        Map<String, List<String>> unknownFriends = getUnknownFriends(user, friends, userFriends);

        registerFriendInUnknownFriends(friends, unknownFriends);

        HashMap<String, Integer> scoreOfVisitors = new HashMap<>();

        initScoreOfVisitors(scoreOfVisitors, visitors, unknownFriends, userFriends);

        setScoreOfBothKnownFriends(scoreOfVisitors, unknownFriends, userFriends);
        setScoreOfVisitors(scoreOfVisitors, visitors);

        //키를 먼저 정렬
        Map<String, Integer> sortedMap = new TreeMap<>(scoreOfVisitors);

        //value를 정렬
        List<String> keys = new ArrayList<>(sortedMap.keySet());
        keys.sort((v1, v2) -> (sortedMap.get(v2).compareTo(sortedMap.get(v1))));

        List<String> resultFriends = getResultFriends(sortedMap, keys);

        return resultFriends;
    }

    public static List<String> getUserFriends(String user, List<List<String>> friends) {
        List<String> userFriends = new ArrayList<>();

        for (List<String> relation : friends) {

            if (relation.get(0).equals(user)) {
                userFriends.add(relation.get(1));
            }

            if (relation.get(1).equals(user)) {
                userFriends.add((relation.get(0)));
            }

        }

        return userFriends;
    }

    public static Map<String, List<String>> getUnknownFriends(String user,
                                                              List<List<String>> friends,
                                                              List<String> userFriends) {
        Map<String, List<String>> unknownFriends = new HashMap<>();

        for (List<String> friend : friends) {
            for (int j = 0; j < 2; j++) {

                if (friend.get(j).equals(user) || userFriends.contains(friend.get(j))) {
                    continue;
                }

                if (!unknownFriends.containsKey(friend.get(j))) {
                    List<String> friendList = new ArrayList<>();
                    unknownFriends.put(friend.get(j), friendList);
                }
            }
        }

        return unknownFriends;
    }

    public static void registerFriendInUnknownFriends(List<List<String>> friends,
                                                      Map<String, List<String>> unknownFriends) {

        for (List<String> friend : friends) {

            if (unknownFriends.containsKey(friend.get(0))) {
                unknownFriends.get(friend.get(0)).add(friend.get(1));
            }

            if (unknownFriends.containsKey(friend.get(1))) {
                unknownFriends.get(friend.get(1)).add(friend.get(0));
            }

        }
    }

    public static void initScoreOfVisitors(HashMap<String, Integer> scoreOfVisitors,
                                           List<String> visitors,
                                           Map<String, List<String>> unknownFriends,
                                           List<String> userFriends) {

        for (String visitor : visitors) {

            if (!unknownFriends.containsKey(visitor) && !userFriends.contains(visitor)) {
                scoreOfVisitors.put(visitor, 0);
            }

        }
    }

    public static void setScoreOfBothKnownFriends(HashMap<String, Integer> scoreOfVisitors,
                                                  Map<String, List<String>> unknownFriends,
                                                  List<String> userFriends) {

        for (String unknownFriend : unknownFriends.keySet()) {

            for (String userFriend : userFriends) {

                if (unknownFriends.get(unknownFriend).contains(userFriend)) {

                    if (!scoreOfVisitors.containsKey(unknownFriend)) {
                        scoreOfVisitors.put(unknownFriend, 10);
                        continue;
                    }

                    scoreOfVisitors.put(unknownFriend, scoreOfVisitors.get(unknownFriend) + 10);

                }
            }
        }
    }

    public static void setScoreOfVisitors(HashMap<String, Integer> scoreOfVisitors, List<String> visitors) {

        for (String visitor : visitors) {

            if (scoreOfVisitors.containsKey(visitor)) {
                scoreOfVisitors.put(visitor, scoreOfVisitors.get(visitor) + 1);
            }

        }
    }

    public static List<String> getResultFriends(Map<String, Integer> sortedMap, List<String> keys) {
        List<String> resultFriends = new ArrayList<>();

        int count = 0;

        for (String key : keys) {

            if (count == 5) {
                break;
            }

            if (sortedMap.get(key) == 0) {
                continue;
            }

            resultFriends.add(key);
            count++;
        }

        return resultFriends;
    }
}
