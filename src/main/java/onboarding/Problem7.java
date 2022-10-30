package onboarding;

import java.util.*;

/**
 * 1. 전체 사용자 목록 Set 생성
 * 2. 사용자 별 친구 리스트 Map 생성
 * 3. user의 추천 친구가 될 수 있는 사용자별 점수 Map 생성
 * 4. 방문자 id 별 횟수 Map 생성
 * 5. user의 추천 친구별 점수 Map 순회하면서 점수 계산하기
 * 6. 정렬 조건에 맞게 정렬 후 최대 5개 반환하기
 */

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }

    private static Set<String> toAllUserSet(List<List<String>> friends, List<String> visitors) {
        Set<String> allUserSet = new HashSet<>();

        for (List<String> friend : friends) {
            allUserSet.add(friend.get(0));
            allUserSet.add(friend.get(1));
        }
        allUserSet.addAll(visitors);

        return allUserSet;
    }

    private static Map<String, List<String>> mapFriendListByUser(List<List<String>> friends) {
        Map<String, List<String>> friendListMap = new HashMap<>();

        for (List<String> friend : friends) {
            String friendA = friend.get(0);
            String friendB = friend.get(1);
            List<String> friendListA = friendListMap.getOrDefault(friendA, new ArrayList<>());
            List<String> friendListB = friendListMap.getOrDefault(friendB, new ArrayList<>());
            friendListA.add(friendB);
            friendListB.add(friendA);
            friendListMap.put(friendA, friendListA);
            friendListMap.put(friendB, friendListB);
        }

        return friendListMap;
    }

    private static Map<String, Integer> mapScoreByNotFriendUser(List<String> userFriendList, Set<String> allUserSet) {
        Map<String, Integer> notFriendUsersScoreMap = new HashMap<>();

        for (String user : allUserSet) {
            if (!userFriendList.contains(user)) {
                notFriendUsersScoreMap.put(user, 0);
            }
        }

        return notFriendUsersScoreMap;
    }
}
