package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();

        List<String> friendList = classifyPeople(user, friends).get(0);
        List<String> nonFriendList = classifyPeople(user, friends).get(1);

        Map<String, Integer> nonFriendScore = new HashMap<>();
        for (String nonFriend : nonFriendList) {
            nonFriendScore.put(nonFriend, 0);
        }

        Map<String, Integer> calcResult = calcScore(nonFriendScore, friends, friendList, visitors);

        for (String nonFriend : calcResult.keySet()) {
            if (calcResult.get(nonFriend) == 0) {
                calcResult.remove(nonFriend);
            }
        }
        return answer;
    }

    private static List<List<String>> classifyPeople(String user, List<List<String>> friends) {
        List<String> friendList = new ArrayList<>();
        List<String> nonFriendList = new ArrayList<>();
        for (List<String> relation : friends) {
            if (relation.contains(user)) {
                relation.remove(user);
                String friend1 = relation.get(0);
                friendList.add(friend1);
            } else {
                nonFriendList.add(relation.get(0));
                nonFriendList.add(relation.get(1));
            }
        }
        // 중복 제거
        Set<String> set = new HashSet<>(nonFriendList);
        List<String> n_nonFriendList = new ArrayList<>(set);

        // 안친구목록 중 친구 있다면 지워주기
        for (String friend : friendList) {
            if (n_nonFriendList.contains(friend)) {
                n_nonFriendList.remove(friend);
            }
        }
        return List.of(friendList, n_nonFriendList);
    }

    private static Map<String, Integer> calcScore(Map<String, Integer> nonFriendScore, List<List<String>> friendRelations, List<String> friendList, List<String> visitors) {

        // 아는 친구 점수 업데이트
        for (List<String> relation : friendRelations) {
            for (String friend : friendList) {
                if (relation.contains(friend)) {
                    relation.remove(friend);
                    nonFriendScore.put(relation.get(0), nonFriendScore.get(relation.get(0))+10);
                }
            }
        }

        // 방문 점수 업데이트
        for (String visitor : visitors) {
            if (nonFriendScore.containsKey(visitor)){
                nonFriendScore.put(visitor, nonFriendScore.get(visitor)+1);
            }
        }
        return nonFriendScore;
    }
}
