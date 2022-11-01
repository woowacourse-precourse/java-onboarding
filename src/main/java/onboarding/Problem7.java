package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {

        Map<String, List<String>> relation = makeFriendsRelation(user, friends, visitors);

        getRelationScore(relation, userFriends);
        getVisitorScore(relation, visitors);

    }

    private static Map makeFriendsRelation(String user, List<List<String>> friends, List<String> visitors) {
        Map<String, List<String>> temp = new HashMap<>();
        temp.put(user, new ArrayList<>());

        for (List info : friends) {
            for (Object person : info) {
                if (!temp.containsKey((String)person)) {
                    List<String> defaultScore = new ArrayList<>();
                    defaultScore.add("0");
                    temp.put((String)person, defaultScore);
                }
            }

            if (temp.containsKey(info.get(0))) {
                List<String> friendsList = temp.get(info.get(0));
                friendsList.add((String)info.get(1));
            }

            if (temp.containsKey(info.get(1))) {
                List<String> friendsList = temp.get(info.get(1));
                friendsList.add((String)info.get(0));
            }

            for (String visitor : visitors) {
                if (!temp.containsKey(visitor)) {
                    List<String> defaultScore = new ArrayList<>();
                    defaultScore.add("0");
                    temp.put(visitor, defaultScore);
                }
            }
        }
        return temp;
    }
    private static void getRelationScore(Map<String, List<String>> relation, List<String> userFriends) {
        for (String name : userFriends) {
            for (String person : relation.keySet()) {
                if (relation.get(person).contains(name)) {
                    relation.get(person).set(0, String.valueOf(Integer.parseInt(relation.get(person).get(0)) + 10));
                }
            }
        }
    }
    private static void getVisitorScore(Map<String, List<String>> relation, List<String> visitors) {
        for (String visitor : visitors) {
            relation.get(visitor).set(0, String.valueOf(Integer.parseInt(relation.get(visitor).get(0)) + 1));
        }
    }

    private static List<String> processData(Map<String, List<String>> relation, List<String> userFriends) {
        Map<String, Integer> data = new HashMap<>();
        for (String person : relation.keySet()) {
            data.put(person, Integer.parseInt(relation.get(person).get(0)));
        }
        removeAlreadyFriends(data, userFriends);
        removeZeroScore(data);
        List<Map.Entry<String, Integer>> recommendedFriendsList = getSortedList(data);
        return "";
    }

        // 이미 친구면 제외
    private static void removeAlreadyFriends(Map<String, Integer> user, List<String> userFriends) {
        for (String name : userFriends) {
            if (user.containsKey(name)) {
                user.remove(name);
            }
        }
    }

    // 0점이면 제외
    private static void removeZeroScore(Map<String, Integer> scoreInfo) {
        scoreInfo.entrySet().removeIf(
                entry -> entry.getValue().equals(0));
    }

    // 점수가 큰 순으로 정렬, 점수가 같다면 사전순 정렬
    private static List<Map.Entry<String, Integer>> getSortedList(Map<String, Integer> scoreInfo) {
        List<Map.Entry<String, Integer>> list = new ArrayList<>(scoreInfo.entrySet());
        Collections.sort(list, (first, second) -> {
            if (first.getValue() > second.getValue()) {
                return -1;
            }
            if (first.getValue() < second.getValue()) {
                return 1;
            }
            return first.getKey().compareTo(second.getKey());
        });
        return list;
    }
}
