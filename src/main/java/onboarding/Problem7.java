package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        HashMap<String, Integer> scoreMap = new HashMap<>();
        Set<String> oldFriends = getOldFriends(user, friends);
        for (int i = 0; i < friends.size(); i++) {
            for (int j = 0; j < 2; j++) {
                for (String oldFriend: oldFriends) {
                    if (oldFriend.equals(friends.get(i).get(j))) {
                        String opposite = friends.get(i).get(1-j);
                        scoreMap.put(opposite, scoreMap.get(opposite) + 10);
                    }
                }
            }
        }

        for (String visitor: visitors) {
            int score;
            score = scoreMap.getOrDefault(visitor, 0);
            scoreMap.put(visitor, score + 1);
        }

        scoreMap.remove(user);
        for (String oldFriend: oldFriends) {
            scoreMap.remove(oldFriend);
        }

        return sorting(scoreMap);
    }

    private static Set<String> getOldFriends(String user, List<List<String>> friends) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < friends.size(); i++) {
            for (int j = 0; j < 2; j++) {
                if (friends.get(i).get(j).equals(user)) {
                    set.add(friends.get(i).get(1-j));
                    break;
                }
            }
        }
        return set;
    }

    private static List<String> sorting(HashMap<String, Integer> score) {

        Map<String, Integer> sortedMap = new TreeMap<>(score);
        List<String> keySet = new ArrayList<>(sortedMap.keySet());
        keySet.sort((o1, o2) -> sortedMap.get(o2).compareTo(sortedMap.get(o1)));

        List<String> answer = new ArrayList<>();

        for (int i = 0; i < keySet.size(); i += 1) {
            answer.add(keySet.get(i));
        }

        if (answer.size() > 5) {
            for (int i = 5; i < keySet.size(); i += 1) {
                answer.remove(i);
            }
        }

        return answer;

    }
}
