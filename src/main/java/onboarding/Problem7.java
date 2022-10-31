package onboarding;

import java.util.*;

public class Problem7 {
    // 유저와 친구인 사람들 목록 구하기
    private static List<String> getFriendsList(String user, List<List<String>> friends) {
        List<String> friendList = new ArrayList<>();
        for (int i = 0; i < friends.size(); i++) {
            List<String> friend = friends.get(i);
            if (friend.get(0).equals(user))
                friendList.add(friend.get(1));
            else if (friend.get(1).equals(user))
                friendList.add(friend.get(0));
        }
        return friendList;
    }

    // 유저의 친구와 친구인지 체크
    private static Map<String, Integer> checkFriends(Map<String, Integer> scoreMap, String user, List<List<String>> friends, List<String> friendList) {
        for (List<String> friend : friends) {
            if (friend.contains(user))
                continue;
            if (friendList.contains(friend.get(0))) {
                if (scoreMap.containsKey(friend.get(1)))
                    scoreMap.put(friend.get(1), scoreMap.get(friend.get(1)) + 10);
                else
                    scoreMap.put(friend.get(1), 10);
            }
            else if (friendList.contains(friend.get(1))) {
                if (scoreMap.containsKey(friend.get(0)))
                    scoreMap.put(friend.get(0), scoreMap.get(friend.get(0)) + 10);
                else
                    scoreMap.put(friend.get(0), 10);
            }
        }
        return scoreMap;
    }

    // 방문자 체크
    private static Map<String, Integer> checkVisitors(Map<String, Integer> scoreMap, List<String> visitors, List<String> friendList) {
        for (String visitor : visitors) {
            if (friendList.contains(visitor))
                continue;
            if (scoreMap.containsKey(visitor))
                scoreMap.put(visitor, scoreMap.get(visitor) + 1);
            else
                scoreMap.put(visitor, 1);
        }
        return scoreMap;
    }

    // 친구 추천 점수 구하기
    private static Map<String, Integer> getScoreMap(String user, List<List<String>> friends, List<String> visitors, List<String> friendList) {
        Map<String, Integer> scoreMap = new HashMap<>();
        scoreMap = checkFriends(scoreMap, user, friends, friendList);
        scoreMap = checkVisitors(scoreMap, visitors, friendList);
        return scoreMap;
    }
    
    // 정렬(점수, 이름 순)된 키 set 구하기
    private static List<String> getSortedKeySet(Map<String, Integer> scoreMap) {
        Comparator<String> comparator = (s1, s2) -> {
            if (scoreMap.get(s1) > scoreMap.get(s2))
                return -1;
            else if (scoreMap.get(s1) < scoreMap.get(s2))
                return 1;
            else
                return s1.compareTo(s2);
        };
        List<String> keySet = new ArrayList<>(scoreMap.keySet());
        keySet.sort(comparator);
        return keySet;
    }

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> friendList = getFriendsList(user, friends);
        Map<String, Integer> scoreMap = getScoreMap(user, friends, visitors, friendList);
        List<String> keySet = getSortedKeySet(scoreMap);
        
        // 상위 5명만 뽑기
        List<String> result = new ArrayList<>();
        for (int i = 0; i < 5 && i < keySet.size(); i++) {
            result.add(keySet.get(i));
        }
        return result;
    }
}
