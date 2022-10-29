package onboarding;

import java.util.*;

/*
 * # 기능 정리
 * [O] 친구 관계 저장
 * [X] 방문자 점수 계산
 * [X] 함께 아는 친구 계산
 * [X] 추천 친구 목록 계산(원래 친구 제외)
 * [X] 추천 친구 정렬
 * [X] solution 작성
 * [X] 테스트 확인
 */

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();

        Map<String, List<String>> friendsMap = new HashMap<>();

        initFriendsMap(friends, friendsMap);

        return answer;
    }

    private static void initFriendsMap(List<List<String>> friends, Map<String, List<String>> friendsMap) {
        for(int i = 0; i < friends.size(); i++){
            String userA = friends.get(i).get(0);
            String userB = friends.get(i).get(1);

            if(!friendsMap.containsKey(userA))
                friendsMap.put(userA, new ArrayList<>());
            if(!friendsMap.containsKey(userB))
                friendsMap.put(userB, new ArrayList<>());

            friendsMap.get(userA).add(userB);
            friendsMap.get(userB).add(userA);
        }
    }
}
