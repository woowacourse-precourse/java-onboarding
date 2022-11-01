package onboarding;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.stream.Collectors;

public class Problem7 {
    static Map<String, List<String>> friendsMap = new HashMap<String, List<String>>();
    static Map<String, Integer> scoreMap = new HashMap<String, Integer>();
    static String userID = new String();

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<String>();
        userID = user;
        setFriendsMap(friends);
        setScoreMap();
        calculateVisitorScore(visitors);
        answer = getTopFiveScore();
        return answer;
    }

    static void setFriendsMap(List<List<String>> friends) {
        for (List<String> friend : friends) {
            String friendA = friend.get(0);
            String friendB = friend.get(1);
            addFriend(friendA, friendB);
            addFriend(friendB, friendA);
        }
    }

    static void addFriend(String A, String B) {
        if (friendsMap.containsKey(A)) {
            friendsMap.get(A).add(B);
        } else {
            List<String> friendList = new ArrayList<String>();
            friendList.add(B);
            friendsMap.put(A, friendList);
        }
    }

    static void setScoreMap() {
        List<String> userFriends = friendsMap.get(userID);
        for (String friend : userFriends) {
            for (String friendOfFriend : friendsMap.get(friend)) {
                if (friendOfFriend.equals(userID)) {
                    continue;
                }
                if (!scoreMap.containsKey(friendOfFriend)) {
                    scoreMap.put(friendOfFriend, 10);
                }
            }
        }
    }

    static void calculateVisitorScore(List<String> visitors) {
        List<String> userFriends = friendsMap.get(userID);
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
    }

    static List<String> getTopFiveScore() {
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
