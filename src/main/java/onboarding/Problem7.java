package onboarding;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.stream.Collectors;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<String>();
        Map<String, List<String>> friendsMap = getFriendsMap(friends);
        Map<String, Integer> scoreMap = getScoreMap(friendsMap, user);
        scoreMap = calculateVisitorScore(friendsMap, scoreMap, visitors, user);
        answer = getTopFiveScore(scoreMap);
        return answer;
    }

    static Map<String, List<String>> getFriendsMap(List<List<String>> friends) {
        Map<String, List<String>> friendsMap = new HashMap<String, List<String>>();
        for (List<String> friend : friends) {
            String friendA = friend.get(0);
            String friendB = friend.get(1);
            friendsMap = addFriend(friendsMap, friendA, friendB);
            friendsMap = addFriend(friendsMap, friendB, friendA);
        }
        return friendsMap;
    }

    static Map<String, List<String>> addFriend(Map<String, List<String>> friendsMap, String A, String B) {
        if (friendsMap.containsKey(A)) {
            friendsMap.get(A).add(B);
        } else {
            List<String> friendList = new ArrayList<String>();
            friendList.add(B);
            friendsMap.put(A, friendList);
        }
        return friendsMap;
    }

    static Map<String, Integer> getScoreMap(Map<String, List<String>> friendsMap, String user) {
        Map<String, Integer> scoreMap = new HashMap<String, Integer>();
        List<String> userFriends = friendsMap.get(user);
        for (String friend : userFriends) {
            for (String friendOfFriend : friendsMap.get(friend)) {
                if (friendOfFriend.equals(user)) {
                    continue;
                }
                if (!scoreMap.containsKey(friendOfFriend)) {
                    scoreMap.put(friendOfFriend, 10);
                }
            }
        }
        return scoreMap;
    }

    static Map<String, Integer> calculateVisitorScore(Map<String, List<String>> friendsMap,
            Map<String, Integer> scoreMap, List<String> visitors, String user) {
        List<String> userFriends = friendsMap.get(user);
        for (String visitor : visitors) {
            // 친구 목록에 없을 경우: 친구의 친구, 혹은 모르는 사람
            if (!userFriends.contains(visitor)) {
                if (scoreMap.containsKey(visitor)) {
                    scoreMap.put(visitor, scoreMap.get(visitor) + 1);
                } else {
                    scoreMap.put(visitor, 1);
                }
            }
        }
        return scoreMap;
    }

    static List<String> getTopFiveScore(Map<String, Integer> scoreMap) {
        List<String> answer = new ArrayList<String>();
        Map<String, Integer> sortedScoreMap = scoreMap.entrySet().stream()
                .sorted(Collections.reverseOrder(Map.Entry.<String, Integer>comparingByValue())
                        .thenComparing(Map.Entry.comparingByKey()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2, LinkedHashMap::new));
        for (Map.Entry<String, Integer> entry : sortedScoreMap.entrySet()) {
            answer.add(entry.getKey());
            System.out.println(entry.getKey() + " : " + entry.getValue());
            if (answer.size() == 5) {
                break;
            }
        }
        return answer;
    }
}
