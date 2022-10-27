package onboarding;

import java.util.*;

/*
1. 친구목록 생성하기
2. 지인 확인하기
3. 지인, 방믄자 점수 계산하기
4. 오름차순 정렬하기
*/

public class Problem7 {

    private static Map<String, Integer> getMutualFriends(String user, List<List<String>> friends, List<String> userFriends) {
        Map<String, Integer> mutualFriendsMap = new HashMap<>();
        for (String userFriend : userFriends) {
            for (List<String> relationship : friends) {
                if (relationship.get(0).equals(user) || relationship.get(1).equals(user)) {
                    continue;
                }
                if (userFriends.contains(relationship.get(0))) {
                    mutualFriendsMap.put(relationship.get(1), mutualFriendsMap.get(relationship.get(1) + 1));
                }
            }
        }
        return mutualFriendsMap;
    }

    private static List<String> getUserFriends(String user, List<List<String>> friends) {
        List<String> userFriends = new ArrayList<>();
        for (List<String> relationship : friends) {
            String name1 = relationship.get(0), name2 = relationship.get(1);
            if (name1.equals(user)) {
                userFriends.add(name2);
            }
            if (name2.equals(user)) {
                userFriends.add(name1);
            }
        }
        return userFriends;
    }

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }
}
