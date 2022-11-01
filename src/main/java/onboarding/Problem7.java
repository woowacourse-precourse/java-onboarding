package onboarding;

import java.util.*;
import java.util.stream.Collectors;

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
        List<String> answer = new ArrayList<>();

        Set<String> allUserSet = toAllUserSet(friends, visitors);
        Map<String, List<String>> usersFriendListMap = mapFriendListByUser(friends);
        List<String> userFriendList = usersFriendListMap.get(user);
        Map<String, Integer> notFriendUsersScoreMap = mapScoreByNotFriendUser(userFriendList, allUserSet);
        Map<String, Integer> visitorsCountMap = mapVisitorCountByUser(visitors);

        notFriendUsersScoreMap.remove(user);

        for (String notFriendUser : notFriendUsersScoreMap.keySet()) {
            int score = notFriendUsersScoreMap.get(notFriendUser);
            int visitorCount = visitorsCountMap.getOrDefault(notFriendUser, 0);
            List<String> notFriendUserFriendList = usersFriendListMap.getOrDefault(notFriendUser, new ArrayList<>());
            notFriendUsersScoreMap.put(notFriendUser, calculateRecommendScore(score, countCommonFriends(userFriendList, notFriendUserFriendList), visitorCount));
        }

        answer.addAll(notFriendUsersScoreMap.keySet());

        return answer.stream()
                .filter(notFriendUser -> notFriendUsersScoreMap.get(notFriendUser) > 0)
                .sorted(((o1, o2) -> {
                    if (notFriendUsersScoreMap.get(o1) == notFriendUsersScoreMap.get(o2)) {
                        return o1.compareTo(o2);
                    }
                    return notFriendUsersScoreMap.get(o2) - notFriendUsersScoreMap.get(o1);
                }))
                .limit(5)
                .collect(Collectors.toList());
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

    private static Map<String, Integer> mapVisitorCountByUser(List<String> visitors) {
        Map<String, Integer> visitorsCountMap = new HashMap<>();

        for (String visitor : visitors) {
            int visitorCount = visitorsCountMap.getOrDefault(visitor, 0);
            visitorsCountMap.put(visitor, visitorCount + 1);
        }

        return visitorsCountMap;
    }

    private static int countCommonFriends(List<String> friendListA, List<String> friendListB) {
        int result = 0;

        for (String friend : friendListA) {
            if (friendListB.contains(friend)) {
                result++;
            }
        }

        return result;
    }

    private static int calculateRecommendScore(int currentScore, int commonFriendsCount, int visitorCount) {
        return currentScore + commonFriendsCount * 10 + visitorCount;
    }
}
