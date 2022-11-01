package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();

        List<String> userFriends = getUserFriends(user, friends);
        Map<String, Integer> map = getCloseFriends(user, friends, userFriends);
        addVisitScore(visitors,userFriends,map);
        answer = sort(map);

        return answer;
    }

    private static List<String> sort(Map<String, Integer> map) {
        List<Map.Entry<String, Integer>> entries;

        Comparator<Map.Entry<String, Integer>> compareByValue = Map.Entry.comparingByValue(Comparator.reverseOrder());
        Comparator<Map.Entry<String, Integer>> compareByKey = Map.Entry.comparingByKey();
        Comparator<Map.Entry<String, Integer>> compare = compareByValue.thenComparing(compareByKey);


        entries = map.entrySet().stream()
                .sorted(compare)
                .collect(Collectors.toList());


        List<String > sortedList = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : entries) {
            sortedList.add(entry.getKey());
        }
        return sortedList;
    }


    private static void addVisitScore(List<String> visitors, List<String> userFriends, Map<String, Integer> map) {
        for (int i = 0; i < visitors.size(); i++) {
            String visitor = visitors.get(i);

            if (!userFriends.contains(visitor)) {
                if (map.containsKey(visitor)) {
                    map.put(visitor, map.get(visitor) + 1);
                } else {
                    map.put(visitor, 1);
                }

            }

        }
    }

    private static List<String> getUserFriends(String user, List<List<String>> friends) {
        Set<String> userFriendSet = new HashSet<>();
        for (int i = 0; i < friends.size(); i++) {

            String name1 = friends.get(i).get(0);
            String name2 = friends.get(i).get(1);

            if (name1.equals(user)) {
                userFriendSet.add(name2);
            } else if (name2.equals(user)) {
                userFriendSet.add(name1);
            }


        }

        List<String> userFriends = new ArrayList<>(userFriendSet);
        return userFriends;
    }

    private static Map<String, Integer> getCloseFriends(String user, List<List<String>> friends, List<String> userFriends) {
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < userFriends.size(); i++) {

            String userFriend = userFriends.get(i);

            for (int j = 0; j < friends.size(); j++) {

                String name1 = friends.get(j).get(0);
                String name2 = friends.get(j).get(1);


                if (name1.equals(userFriend) && !name2.equals(user)) {
                    //mrko 의 친구의 친구 이면서 이름이 mrko 가 아니면?
                    if (map.containsKey(name2)) {
                        map.put(name2, map.get(name2) + 10);
                    } else {
                        map.put(name2, 10);
                    }

                } else if (name2.equals(userFriend) && !name1.equals(user)) {
                    if (map.containsKey(name1)) {
                        map.put(name1, map.get(name1) + 10);
                    } else {
                        map.put(name1, 10);
                    }
                }

            }


        }
        return map;
    }


}
