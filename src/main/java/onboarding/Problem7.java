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

        Map<String, Integer> calcResult = calcScore(nonFriendScore, friends, friendList);

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
        return List.of(friendList, nonFriendList);
    }

    private static Map<String, Integer> calcScore(Map<String, Integer> nonFriendScore, List<List<String>> friendRelations, List<String> friendList) {
        for (List<String> relation : friendRelations) {
            for (String friend : friendList) {
                if (relation.contains(friend)) {
                    relation.remove(friend);
                    nonFriendScore.put(relation.get(0), nonFriendScore.get(relation.get(0))+10);
                }
            }
        }
        return nonFriendScore;
    }
}
