package onboarding;

import java.util.*;

/*
 * # 기능 정리
 * [O] 친구 관계 저장
 * [O] 방문자 점수 계산
 * [X] 함께 아는 친구 계산
 * [X] 추천 친구 목록 계산(원래 친구 제외)
 * [X] 추천 친구 정렬
 * [X] solution 작성
 * [X] 테스트 확인
 */

public class Problem7 {
    static final int VISIT_POINT = 1;
    static final int FRIEND_POINT = 10;

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();

        Map<String, List<String>> friendsMap = new HashMap<>();
        Map<String, Integer> recommendPoints = new HashMap<>();

        initFriendsMap(friends, friendsMap);

        calculateVisitors(visitors, recommendPoints);

        return answer;
    }

    private static void calculateVisitors(List<String> visitors, Map<String, Integer> recommendPoints) {
        for(int i = 0; i < visitors.size(); i++){
            String visitorId = visitors.get(i);

            if(!recommendPoints.containsKey(visitorId))
                recommendPoints.put(visitorId, 0);
            recommendPoints.put(visitorId, recommendPoints.get(visitorId) + VISIT_POINT);
        }
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
