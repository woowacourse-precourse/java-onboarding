package onboarding;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        Map<String, Set<String>> friendsRelationMap = createFriendRelations(friends);
        Set<String> userFriendsSet = createUserFriends(user, friendsRelationMap);
        List<String> notUserFriendList = createNotUserFriendRelations(friendsRelationMap, userFriendsSet);
        List<String> notUserFriendVisitorList = createNotUserFriendsVisitors(visitors, userFriendsSet);
        notUserFriendList.addAll(notUserFriendVisitorList);
        Map<String, Integer> scoreMap = createScoreInList(notUserFriendList);
        increaseVisitorsOnScoreMap(notUserFriendVisitorList, scoreMap);
        increaseUserFriendsOnScoreMap(user, friendsRelationMap, scoreMap);
        List<String> answer = scoreMap.keySet().stream()
                .sorted((o1, o2) -> {
                    if (scoreMap.get(o2).equals(scoreMap.get(o1)))
                        return o1.compareTo(o2);
                    return scoreMap.get(o2).compareTo(scoreMap.get(o1));
                })
                .collect(Collectors.toList());
        return answer;
    }

    private static List<String> createNotUserFriendsVisitors(List<String> visitors, Set<String> userFriendsSet) {
        return visitors.stream()
                .filter(visitor -> !userFriendsSet.contains(visitor))
                .collect(Collectors.toList());
    }

    private static List<String> createNotUserFriendRelations(Map<String, Set<String>> friendsRelationMap, Set<String> userFriendsSet) {
        return friendsRelationMap.keySet().stream()
                .filter(userId -> !userFriendsSet.contains(userId))
                .collect(Collectors.toList());
    }

    private static Set<String> createUserFriends(String user, Map<String, Set<String>> friendsRelationMap) {
        return friendsRelationMap.keySet().stream()
                .filter(userId -> userId.equals(user) || friendsRelationMap.get(user).contains(userId))
                .collect(Collectors.toSet());
    }

    private static void increaseUserFriendsOnScoreMap(String user, Map<String, Set<String>> friendsRelationMap, Map<String, Integer> scoreMap) {
        friendsRelationMap.get(user).forEach(userFriend -> {
            friendsRelationMap.get(userFriend).forEach(friend -> increaseFriend10(scoreMap, friend));
        });
    }

    private static void increaseFriend10(Map<String, Integer> scoreMap, String friend) {
        if (scoreMap.containsKey(friend))
            scoreMap.put(friend, scoreMap.get(friend) + 10);
    }

    private static void increaseVisitorsOnScoreMap(List<String> visitors, Map<String, Integer> scoreMap) {
        visitors.forEach(userId -> {
            if (scoreMap.containsKey(userId))
                scoreMap.merge(userId, scoreMap.get(userId), Integer::sum);
        });
    }

    private static Map<String, Integer> createScoreInList(List<String> list) {
        Map<String, Integer> scoreMap = new HashMap<>();
        list.forEach(userId -> scoreMap.put(userId, 0));
        return scoreMap;
    }

    private static Map<String, Set<String>> createFriendRelations(List<List<String>> friends) {
        Map<String, Set<String>> friendRelationMap = new HashMap<>();
        friends.forEach(list -> {
            addAtoBInMap(list.get(0), list.get(1), friendRelationMap);
            addAtoBInMap(list.get(1), list.get(0), friendRelationMap);
        });
        return friendRelationMap;
    }

    private static void addAtoBInMap(String a, String b, Map<String, Set<String>> map) {
        if (map.containsKey(b))
            map.get(b).add(a);
        else
            map.put(b, new HashSet<>(Collections.singletonList(a)));
    }
}
/*
문제 설명
  1. 친구 추천 알고리즘을 구현하고자 아래와 같은 규칙을 세움
    - 사용자와 함께 아는 친구의 수 = 10점
    - 사용자의 타임 라인에 방문한 횟수 = 1점
  2. 친구 추천 규칙에 따라 점수가 가장 높은 순으로 정렬하여 최대 5명을 리턴
  3. 추천 점수가 0점인 경우 추천하지 않으며, 추천 점수가 같은 경우 이름순으로 정렬함

문제 예시
  - [mrko] <> [donut] <> [andole, jun]
  - [mrko] <> [shakevan] <> [andole, jun]
  - 위와 같은 친구 관계로 andole과 jun은 20점
  - visitors에 있는 친구들은 전부 1점씩 추가
  - 점수 별로 정렬하여 최대 5명 리턴

제한사항 및 주의할점
  - user는 길이가 1 이상 30 이하인 문자열
  - friends는 길이가 1 이상 10,000 이하인 리스트/배열
  - frineds는 각 원소의 길이가 2인 리스트/배열로 [아이디 A, 아이디 B]순으로 들어있음
    - A와 B는 친구라는 의미
    - 아이디는 길이가 1 이상 30 이하인 문자열
  - visitors는 길이가 0 이상 10,000 이하인 리스트/배열
  - 사용자 아이디는 알파벳 소문자로만 이루어짐
  - 동일한 친구 관계가 중복해서 주어지지 않음
  - 추천할 친구가 없는 경우 주어지지 않음
 */