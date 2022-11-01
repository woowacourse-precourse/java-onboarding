package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();

        List<String> userFriends = friendList(user, friends);
        HashMap<String, Integer> recommendScore = acquaintance(friends, userFriends);
        numOfVisit(recommendScore, visitors);
        List<String> sortedList = sortByValues(recommendScore);

        answer = exceptId(user, userFriends, sortedList);
        return answer;
    }

    private static List<String> friendList(String user, List<List<String>> friends) {
        List<String> userFriends = new ArrayList<>();
        for (List<String> friend : friends) {
            if (friend.get(0).equals(user)) {
                userFriends.add(friend.get(1));
            } else if (friend.get(1).equals(user)) {
                userFriends.add(friend.get(0));
            }
        }
        return userFriends;
    }

    private static HashMap<String, Integer> acquaintance(List<List<String>> friends, List<String> userFriends) {
        HashMap<String, Integer> recommendScore = new HashMap<>();
        for (List<String> friend : friends) {
            if (userFriends.contains(friend.get(0))) {
                String person = friend.get(1);
                recommendScore.put(person, recommendScore.getOrDefault(person, 0)+10);
            } else if (userFriends.contains(friend.get(1))) {
                String person = friend.get(0);
                recommendScore.put(person, recommendScore.getOrDefault(person, 0)+10);
            }
        }
        return recommendScore;
    }

    private static void numOfVisit(HashMap<String, Integer> recommendScore, List<String> visitors) {
        for (String visitor : visitors) {
            recommendScore.put(visitor, recommendScore.getOrDefault(visitor, 0)+1);
        }
    }

    private static List<String> sortByValues(HashMap<String, Integer> map) {
        List<String> sortedList = new ArrayList<>(map.keySet());
        Collections.sort(sortedList);
        Collections.sort(sortedList, (value1, value2) -> (map.get(value2).compareTo(map.get(value1))));
        return sortedList;
    }

    private static List<String> exceptId(String user, List<String> userFriends, List<String> sortedList) {
        List<String> answer = new ArrayList<>();
        for (String key : sortedList) {
            if (!key.equals(user) && !userFriends.contains(key)) {
                answer.add(key);
            }
        }
        return answer;
    }
}
