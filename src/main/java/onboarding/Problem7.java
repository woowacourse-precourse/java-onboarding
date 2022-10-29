package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();

        HashSet<String> userFriendMap = new HashSet<>(getFriendListOfUser(user, friends));
        System.out.println(userFriendMap);
        System.out.println(getScoreMap(user, userFriendMap, friends));
        return answer;
    }

    private static HashMap<String, Integer> getScoreMap(String user, HashSet<String> userFriendMap, List<List<String>> friends) {
        HashMap<String, Integer> result = new HashMap<>();


        for (List<String> list: friends) {
            String friendA = list.get(0);
            String friendB = list.get(1);

            if (friendA.equals(user) || friendB.equals(user)) {
                continue;
            }

            updateMutualFriendScore(userFriendMap, result, friendA, friendB);
            updateMutualFriendScore(userFriendMap, result, friendB, friendA);
        }

        return result;
    }

    private static void updateMutualFriendScore(HashSet<String> userFriendMap, HashMap<String, Integer> result,
                                          String scoreReceiver, String friend) {
        if (userFriendMap.contains(scoreReceiver)) {
            return;
        }

        Integer withFriendScore = getMutualFriendScore(userFriendMap, scoreReceiver, friend);
        updateScore(result, scoreReceiver, withFriendScore);
    }

    private static Integer getMutualFriendScore(HashSet<String> userFriendMap, String scoreReceiver, String friend) {
        if (userFriendMap.contains(friend) && !userFriendMap.contains(scoreReceiver)) {
            return 10;
        }
        return 0;
    }

    private static void updateScore(HashMap<String, Integer> scoreMap, String receiver, Integer score) {
        if (!scoreMap.containsKey(receiver)) {
            scoreMap.put(receiver, score);
        } else {
            scoreMap.put(receiver, scoreMap.get(receiver) + score);
        }
    }

    private static List<String> getFriendListOfUser(String user, List<List<String>> friends) {
        List<String> result = new ArrayList<>();

        for (List<String> list: friends) {
            if (list.get(0).equals(user)) {
                result.add(list.get(1));
            } else if (list.get(1).equals(user)) {
                result.add(list.get(0));
            }
        }

        return result;
    }
}
