package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        // 1. 친구 추천 점수를 저장할 맵 생성
        HashMap<String, Integer> scoreMap = new HashMap<>();

        // 2. 유저별 친구 목록을 저장할 맵 생성
        HashMap<String, Set<String>> personalFriendsMap = makePersonalFriendsMap(friends);


        List<String> answer = Collections.emptyList();
        return answer;
    }

    // 유저별 친구 목록 생성 기능
    private static HashMap<String, Set<String>> makePersonalFriendsMap(List<List<String>> friends) {
        HashMap<String, Set<String>> personalFriendsMap = new HashMap<>();
        // 유저별 친구 목록 생성
        for (List<String> friend : friends) {
            addFriend(personalFriendsMap, friend);
        }
        return personalFriendsMap;
    }

    // 친구 추가 기능
    private static void addFriend(HashMap<String, Set<String>> personalFriendsMap, List<String> friend) {
        // 왼쪽 유저 유저목록 추가
        if (!personalFriendsMap.containsKey(friend.get(0))) {
            personalFriendsMap.put(friend.get(0), new HashSet<>());
        }
        personalFriendsMap.get(friend.get(0)).add(friend.get(1));
        // 오른쪽 유저 유저목록 추가
        if (!personalFriendsMap.containsKey(friend.get(1))) {
            personalFriendsMap.put(friend.get(1), new HashSet<>());
        }
        personalFriendsMap.get(friend.get(1)).add(friend.get(0));

    }


}
